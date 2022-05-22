SET SERVEROUTPUT ON

-- PACKAGES
-- áreas de armazenamentos de procedures, functions, etc
-- conceder privilégios
-- organização

-- PACKAGE SPECIFICATION
-- conteúdo a ser compartilhado com outras aplicações
-- interface das aplicações

CREATE OR REPLACE PACKAGE faculdade AS
    cnome CONSTANT VARCHAR2(4) := 'FIAP';
    cfone CONSTANT VARCHAR2(13) := '(11)3385-8010';
    cnota CONSTANT NUMBER(2) := 10;
END faculdade;

-- uso do pacote
DECLARE
    melhor VARCHAR2(30);
BEGIN
    melhor := faculdade.cnome || ', a melhor faculdade';
    dbms_output.put_line(melhor);
END;


-- exemplo com procedures e functions
CREATE OR REPLACE PACKAGE rh AS
    FUNCTION descobrir_salario (p_id IN emp.empno%TYPE)
        RETURN NUMBER;
    PROCEDURE reajuste (v_codigo_emp IN emp.empno%type,
                        v_porcentagem IN number DEFAULT 25);
END rh;

-- explicar o pacote
DESC rh;


-- PACKAGE BODY
-- conteúdo das procedures ou funções

CREATE OR REPLACE PACKAGE BODY rh
AS
    FUNCTION descobrir_salario (p_id IN emp.empno%TYPE)
        RETURN NUMBER
    IS
        v_salario emp.sal%TYPE := 0;
    BEGIN
        SELECT sal INTO v_salario
        FROM emp
        WHERE empno = p_id;
        RETURN v_salario;
    END descobrir_salario;
    PROCEDURE reajuste (v_codigo_emp IN emp.empno%type,
                        v_porcentagem IN number DEFAULT 25)
    IS
    BEGIN
        UPDATE emp
        SET sal = sal + (sal *( v_porcentagem / 100 ) )
        WHERE empno = v_codigo_emp;
        COMMIT;
    END reajuste;
END rh;


-- uso do package body
-- function
SELECT rh.descobrir_salario(7900) FROM dual;

-- procedure
DECLARE
    v_sal NUMBER(8,2);
BEGIN
    v_sal := rh.descobrir_salario(7900);
    DBMS_OUTPUT.PUT_LINE ('Salario atual - ' || v_sal);
    rh.reajuste (7900, faculdade.cnota);
    v_sal := rh.descobrir_salario(7900);
    DBMS_OUTPUT.PUT_LINE ('Salario atualizado - ' || v_sal);
END;

-- TRIGGERS
-- são ativados automaticamente após algum evento no banco

-- before
-- o gatilho será executando antes do evento ser concluido

-- after
-- o gatilho será executado após a conclusão do evento

-- os eventos possíveis são INSERT, UPDATE, DELETE

-- trigger DML
CREATE OR REPLACE TRIGGER mudancas_salariais 
BEFORE UPDATE ON emp -- antes de um update na emp
-- BEFORE INSERT OR UPDATE OR DELETE ON emp -- pode ser em qualquer operação
FOR EACH ROW -- realizar o bloco a seguir para cada linha modificada
-- WHEN (NEW.SAL > 1000) -- podemos configurar uma condição para o gatilho
DECLARE
    saldo number;
BEGIN
    saldo := :NEW.sal  - :OLD.sal; -- pseudocolunas como ROWNUM
    DBMS_OUTPUT.PUT_LINE('Salario Anterior: ' || :OLD.sal);
    DBMS_OUTPUT.PUT_LINE('Salario Novo: ' || :NEW.sal);
    DBMS_OUTPUT.PUT_LINE('Diferenca Salarial: ' || saldo);
END;

-- testar o gatilho
UPDATE EMP     
SET sal = sal * 2
WHERE empno = 7900;

-- LOGS

-- Salario Anterior: 1045
-- Salario Novo: 2090
--Diferenca Salarial: 1045


--1 row updated.
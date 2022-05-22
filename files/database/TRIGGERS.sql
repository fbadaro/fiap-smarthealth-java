CREATE OR REPLACE TRIGGER TR_DELETE_POSTOSAUDE    
BEFORE UPDATE ON HT01_SAUDE
REFERENCING NEW AS v_current_posto OLD AS v_old_posto;
FOR EACH ROW
BEGIN
    -- DECLARE e_not_exists_posto EXCEPTION;

    -- DECLARE v_old_postoId := v_old_posto.PS_ID;
    -- DECLARE v_old_postoBairro := v_old_posto.PS_BAIRRO;

    -- DECLARE v_new_posto HT01_SAUDE%ROWTYPE;
    -- DECLARE v_new_posto_count NUMBER;

    -- VERIFICAR OUTRO POSTO DE SAUDE POR BAIRRO
    -- SELECT Count(*) INTO v_new_posto_count
    -- FROM HT01_SAUDE
    -- WHERE PS_BAIRRO = v_old_postoBairro;

    -- IF v_new_posto_count = 0 THEN
    --     RAISE e_not_exists_posto;
    -- ELSE
    --     SELECT * INTO v_new_posto
    --     FROM HT01_SAUDE
    --     WHERE PS_BAIRRO = v_old_postoBairro;
    -- END IF;


    -- LOOP AGENTES DE SAUDE

    -- DBMS_OUTPUT.PUT_LINE ('Posto' || v_old_postoId);

    -- LOOP FAMILIAS

    -- EXCEPTION
    --     WHEN E_NOT_EXISTS_POSTO THEN
    --         DBMS_OUTPUT.PUT_LINE ('Não existe posto de saude');
END;
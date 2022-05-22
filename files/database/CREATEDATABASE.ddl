-- Generated by Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   at:        2022-03-01 13:17:24 BRT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



CREATE TABLE ht01_saude (
    ps_id           INTEGER NOT NULL,
    ps_nome         VARCHAR2(150) NOT NULL,
    ps_cnpj         VARCHAR2(14) NOT NULL,
    ps_cep          VARCHAR2(9) NOT NULL,
    ps_endereco     VARCHAR2(150) NOT NULL,
    ps_complemento  VARCHAR2(30),
    ps_bairro       VARCHAR2(150) NOT NULL,
    ps_telefone     VARCHAR2(14) NOT NULL,
    ps_email        VARCHAR2(30) NOT NULL,
    ps_horario      VARCHAR2(10)
);

ALTER TABLE ht01_saude ADD CONSTRAINT ht01_saude_pk PRIMARY KEY ( ps_id );

CREATE TABLE ht02_medico (
    md_id           INTEGER NOT NULL,
    md_nome         VARCHAR2(150) NOT NULL,
    md_cpf          VARCHAR2(11) NOT NULL,
    md_cpf_emissor  VARCHAR2(5),
    md_cpf_uf       CHAR(2 CHAR) NOT NULL,
    md_cpnj         VARCHAR2(14) NOT NULL,
    md_crm          VARCHAR2(10) NOT NULL,
    md_crm_uf       CHAR(2 CHAR) NOT NULL,
    md_telefone     VARCHAR2(14) NOT NULL,
    md_nascimento   DATE NOT NULL
);

ALTER TABLE ht02_medico ADD CONSTRAINT ht02_medico_pk PRIMARY KEY ( md_id );

CREATE TABLE ht03_agsaude (
    ag_id             INTEGER NOT NULL,
    ag_nome           VARCHAR2(150) NOT NULL,
    ag_cpf            VARCHAR2(11) NOT NULL,
    ag_cpf_emissor    VARCHAR2(5) NOT NULL,
    ag_cpf_uf         CHAR(2 CHAR) NOT NULL,
    ag_telefone       VARCHAR2(14) NOT NULL,
    ag_nascimento     DATE NOT NULL,
    ag_cns            VARCHAR2(15) NOT NULL,
    ht01_saude_ps_id  INTEGER NOT NULL
);

ALTER TABLE ht03_agsaude ADD CONSTRAINT ht03_agsaude_pk PRIMARY KEY ( ag_id );

CREATE TABLE ht04_familia (
    fm_id             INTEGER NOT NULL,
    fm_sobrenome      VARCHAR2(150) NOT NULL,
    fm_cns            VARCHAR2(15) NOT NULL,
    fm_cep            VARCHAR2(9) NOT NULL,
    fm_endereco       VARCHAR2(150),
    fm_complemento    VARCHAR2(30) NOT NULL,
    fm_bairro         VARCHAR2(150) NOT NULL,
    fm_telefone       VARCHAR2(14) NOT NULL,
    fm_email          VARCHAR2(30) NOT NULL,
    ht01_saude_ps_id  INTEGER NOT NULL
);

ALTER TABLE ht04_familia ADD CONSTRAINT ht04_familia_pk PRIMARY KEY ( fm_id );

CREATE TABLE ht05_membro (
    mb_id               INTEGER NOT NULL,
    mb_nome             VARCHAR2(150) NOT NULL,
    mb_nome_social      VARCHAR2(150),
    mb_cpf              VARCHAR2(11) NOT NULL,
    mb_cpf_emissor      VARCHAR2(5) NOT NULL,
    mb_cpf_uf           CHAR(2 CHAR) NOT NULL,
    mb_rg               VARCHAR2(15) NOT NULL,
    mb_nascimento       DATE NOT NULL,
    mb_responsavel      CHAR(1) NOT NULL,
    ht04_familia_fm_id  INTEGER NOT NULL,
    ht10_sexo_sx_id     INTEGER NOT NULL
);

ALTER TABLE ht05_membro ADD CONSTRAINT ht05_membro_pk PRIMARY KEY ( mb_id );

CREATE TABLE ht06_regvacin (
    rv_id              INTEGER NOT NULL,
    rv_nome            VARCHAR2(150) NOT NULL,
    rv_data            DATE NOT NULL,
    rv_vencimento      DATE,
    ht05_membro_mb_id  INTEGER NOT NULL
);

ALTER TABLE ht06_regvacin ADD CONSTRAINT ht06_regvacin_pk PRIMARY KEY ( rv_id );

CREATE TABLE ht09_especiali (
    es_id    INTEGER NOT NULL,
    es_tipo  VARCHAR2(150) NOT NULL
);

ALTER TABLE ht09_especiali ADD CONSTRAINT ht09_especiali_pk PRIMARY KEY ( es_id );

CREATE TABLE ht10_sexo (
    sx_id             INTEGER NOT NULL,
    sx_identificacao  VARCHAR2(50) NOT NULL
);

ALTER TABLE ht10_sexo ADD CONSTRAINT ht10_sexo_pk PRIMARY KEY ( sx_id );

CREATE TABLE r01_ht01_ht02 (
    ht01_saude_ps_id   INTEGER NOT NULL,
    ht02_medico_md_id  INTEGER NOT NULL
);

ALTER TABLE r01_ht01_ht02 ADD CONSTRAINT r01_ht01_ht02_pk PRIMARY KEY ( ht01_saude_ps_id,
                                                                        ht02_medico_md_id );

CREATE TABLE r03_ht03_ht04 (
    ht03_agsaude_ag_id  INTEGER NOT NULL,
    ht04_familia_fm_id  INTEGER NOT NULL
);

ALTER TABLE r03_ht03_ht04 ADD CONSTRAINT r03_ht03_ht04_pk PRIMARY KEY ( ht03_agsaude_ag_id,
                                                                        ht04_familia_fm_id );

CREATE TABLE r08_ht02_ht09 (
    ht02_medico_md_id     INTEGER NOT NULL,
    th09_especiali_es_id  INTEGER NOT NULL,
    ht09_especiali_es_id  INTEGER NOT NULL
);

ALTER TABLE r08_ht02_ht09
    ADD CONSTRAINT r08_ht02_ht09_pk PRIMARY KEY ( ht02_medico_md_id,
                                                  th09_especiali_es_id,
                                                  ht09_especiali_es_id );

CREATE TABLE r09_ht02_ht04 (
    ht02_medico_md_id   INTEGER NOT NULL,
    ht04_familia_fm_id  INTEGER NOT NULL,
    tc_realizada        CHAR(1) NOT NULL,
    tc_data             DATE
);

ALTER TABLE r09_ht02_ht04 ADD CONSTRAINT r09_ht02_ht04_pk PRIMARY KEY ( ht02_medico_md_id,
                                                                        ht04_familia_fm_id );

ALTER TABLE ht03_agsaude
    ADD CONSTRAINT ht03_agsaude_ht01_saude_fk FOREIGN KEY ( ht01_saude_ps_id )
        REFERENCES ht01_saude ( ps_id );

ALTER TABLE ht04_familia
    ADD CONSTRAINT ht04_familia_ht01_saude_fk FOREIGN KEY ( ht01_saude_ps_id )
        REFERENCES ht01_saude ( ps_id );

ALTER TABLE ht05_membro
    ADD CONSTRAINT ht05_membro_ht04_familia_fk FOREIGN KEY ( ht04_familia_fm_id )
        REFERENCES ht04_familia ( fm_id );

ALTER TABLE ht05_membro
    ADD CONSTRAINT ht05_membro_ht10_sexo_fk FOREIGN KEY ( ht10_sexo_sx_id )
        REFERENCES ht10_sexo ( sx_id );

ALTER TABLE ht06_regvacin
    ADD CONSTRAINT ht06_regvacin_ht05_membro_fk FOREIGN KEY ( ht05_membro_mb_id )
        REFERENCES ht05_membro ( mb_id );

ALTER TABLE r01_ht01_ht02
    ADD CONSTRAINT r01_ht01_ht02_ht01_saude_fk FOREIGN KEY ( ht01_saude_ps_id )
        REFERENCES ht01_saude ( ps_id );

ALTER TABLE r01_ht01_ht02
    ADD CONSTRAINT r01_ht01_ht02_ht02_medico_fk FOREIGN KEY ( ht02_medico_md_id )
        REFERENCES ht02_medico ( md_id );

ALTER TABLE r03_ht03_ht04
    ADD CONSTRAINT r03_ht03_ht04_ht03_agsaude_fk FOREIGN KEY ( ht03_agsaude_ag_id )
        REFERENCES ht03_agsaude ( ag_id );

ALTER TABLE r03_ht03_ht04
    ADD CONSTRAINT r03_ht03_ht04_ht04_familia_fk FOREIGN KEY ( ht04_familia_fm_id )
        REFERENCES ht04_familia ( fm_id );

ALTER TABLE r08_ht02_ht09
    ADD CONSTRAINT r08_ht02_ht09_ht02_medico_fk FOREIGN KEY ( ht02_medico_md_id )
        REFERENCES ht02_medico ( md_id );

ALTER TABLE r08_ht02_ht09
    ADD CONSTRAINT r08_ht02_ht09_ht09_especia_fk FOREIGN KEY ( ht09_especiali_es_id )
        REFERENCES ht09_especiali ( es_id );

ALTER TABLE r09_ht02_ht04
    ADD CONSTRAINT r09_ht02_ht04_ht02_medico_fk FOREIGN KEY ( ht02_medico_md_id )
        REFERENCES ht02_medico ( md_id );

ALTER TABLE r09_ht02_ht04
    ADD CONSTRAINT r09_ht02_ht04_ht04_familia_fk FOREIGN KEY ( ht04_familia_fm_id )
        REFERENCES ht04_familia ( fm_id );



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            12
-- CREATE INDEX                             0
-- ALTER TABLE                             25
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

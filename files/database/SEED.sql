-- ================================= POSTO DE SAUDE ==========================================

INSERT INTO HT01_SAUDE( 
  PS_ID,   
  PS_NOME,
  PS_CNPJ,
  PS_CEP,
  PS_ENDERECO,
  PS_COMPLEMENTO,
  PS_BAIRRO,
  PS_TELEFONE,
  PS_EMAIL,
  PS_HORARIO
)
VALUES
(    
  SAUDE_ID_SEQ.Nextval,
  'Posto de Saude 1',
  '80363720000150',
  '09720-478',
  'Endereco Posto de Saude 1',
  '450',
  'Bairro 1',
  '44448888',
  'posto1@saude.org.br',
  '07-00 - 18:00'
);

INSERT INTO HT01_SAUDE( 
  PS_ID,   
  PS_NOME,
  PS_CNPJ,
  PS_CEP,
  PS_ENDERECO,
  PS_COMPLEMENTO,
  PS_BAIRRO,
  PS_TELEFONE,
  PS_EMAIL,
  PS_HORARIO
)
VALUES
(    
  SAUDE_ID_SEQ.Nextval,
  'Posto de Saude 2',
  '61459433000102',
  '09720-470',
  'Endereco Posto de Saude 2',
  '103',
  'Bairro 2',
  '11118888',
  'posto2@saude.org.br',
  '07-00 - 18:00'
);

INSERT INTO HT01_SAUDE( 
  PS_ID,   
  PS_NOME,
  PS_CNPJ,
  PS_CEP,
  PS_ENDERECO,
  PS_COMPLEMENTO,
  PS_BAIRRO,
  PS_TELEFONE,
  PS_EMAIL,
  PS_HORARIO
)
VALUES
(    
  SAUDE_ID_SEQ.Nextval,
  'Posto de Saude 3',
  '51224679000133',
  '09720-500',
  'Endereco Posto de Saude 3',
  '138',
  'Bairro 3',
  '22228888',
  'posto3@saude.org.br',
  '07-00 - 18:00'
);


-- ================================= MEDICO ==========================================


INSERT INTO HT02_MEDICO(
  MD_ID,
  MD_NOME,
  MD_CPF,
  MD_CPF_EMISSOR,
  MD_CPF_UF,
  MD_CPNJ,
  MD_CRM,
  MD_CRM_UF,
  MD_TELEFONE,
  MD_NASCIMENTO
)
VALUES
(
  MEDICO_ID_SEQ.NEXTVAL,
  'Juan Matheus Yuri Costa',
  '37060357904',
  'SSP',
  'SP',
  '29145837000100',
  '123456CRM',
  'SP',
  '988887777',
  TO_DATE( '05 Jan 1967', 'DD MON YYYY' )
);

INSERT INTO HT02_MEDICO(
  MD_ID,
  MD_NOME,
  MD_CPF,
  MD_CPF_EMISSOR,
  MD_CPF_UF,
  MD_CPNJ,
  MD_CRM,
  MD_CRM_UF,
  MD_TELEFONE,
  MD_NASCIMENTO
)
VALUES
(
  MEDICO_ID_SEQ.NEXTVAL,
  'Elias Noah Cavalcanti',
  '35754679513',
  'SSP',
  'SP',
  '38900730000111',
  '654321CRM',
  'SP',
  '966665555',
  TO_DATE( '12 Jun 1958', 'DD MON YYYY' )
);

INSERT INTO HT02_MEDICO(
  MD_ID,
  MD_NOME,
  MD_CPF,
  MD_CPF_EMISSOR,
  MD_CPF_UF,
  MD_CPNJ,
  MD_CRM,
  MD_CRM_UF,
  MD_TELEFONE,
  MD_NASCIMENTO
)
VALUES
(
  MEDICO_ID_SEQ.NEXTVAL,
  'Pedro Alexandre Freitas',
  '94406862943',
  'SSP',
  'SP',
  '33882014000135',
  '134679CRM',
  'SP',
  '944443333',
  TO_DATE( '23 Dec 1970', 'DD MON YYYY' )
);


-- ================================= AGENTE DE SAUDE ==========================================


DECLARE V_HT01_ID INTEGER;

BEGIN
  SELECT PS_ID INTO V_HT01_ID FROM HT01_SAUDE WHERE PS_NOME = 'Posto de Saude 1';

  INSERT INTO HT03_AGSAUDE(
    AG_ID,
    AG_NOME,
    AG_CPF,
    AG_CPF_EMISSOR,
    AG_CPF_UF,
    AG_TELEFONE,
    AG_NASCIMENTO,
    AG_CNS,
    HT01_SAUDE_PS_ID
  )
  VALUES
  (
    AGSAUDE_ID_SEQ.NEXTVAL,
    'Elza Cristiane da Paz',
    '86847658770',
    'SSP',
    'SP',
    '988887777',
    TO_DATE('21 Feb 1978', 'DD MON YYYY' ),
    '153899670860008',
    V_HT01_ID 
  );

END;

DECLARE V_HT01_ID INTEGER;

BEGIN
  SELECT PS_ID INTO V_HT01_ID FROM HT01_SAUDE WHERE PS_NOME = 'Posto de Saude 1';

  INSERT INTO HT03_AGSAUDE(
    AG_ID,
    AG_NOME,
    AG_CPF,
    AG_CPF_EMISSOR,
    AG_CPF_UF,
    AG_TELEFONE,
    AG_NASCIMENTO,
    AG_CNS,
    HT01_SAUDE_PS_ID
  )
  VALUES
  (
    AGSAUDE_ID_SEQ.NEXTVAL,
    'Theo Joaquim Paulo Gomes',
    '83981944640',
    'SSP',
    'SP',
    '966665555',
    TO_DATE('15 Jul 1970', 'DD MON YYYY' ),
    '799018288270003',
    V_HT01_ID 
  );
  
END;

DECLARE V_HT01_ID INTEGER;

BEGIN
  SELECT PS_ID INTO V_HT01_ID FROM HT01_SAUDE WHERE PS_NOME = 'Posto de Saude 2';

  INSERT INTO HT03_AGSAUDE(
    AG_ID,
    AG_NOME,
    AG_CPF,
    AG_CPF_EMISSOR,
    AG_CPF_UF,
    AG_TELEFONE,
    AG_NASCIMENTO,
    AG_CNS,
    HT01_SAUDE_PS_ID
  )
  VALUES
  (
    AGSAUDE_ID_SEQ.NEXTVAL,
    'Elaine Sophia de Paula',
    '83065346621',
    'SSP',
    'SP',
    '944443333',
    TO_DATE('08 Jan 2002', 'DD MON YYYY' ),
    '967963370000008',
    V_HT01_ID 
  );
  
END;

DECLARE V_HT01_ID INTEGER;

BEGIN
  SELECT PS_ID INTO V_HT01_ID FROM HT01_SAUDE WHERE PS_NOME = 'Posto de Saude 2';

  INSERT INTO HT03_AGSAUDE(
    AG_ID,
    AG_NOME,
    AG_CPF,
    AG_CPF_EMISSOR,
    AG_CPF_UF,
    AG_TELEFONE,
    AG_NASCIMENTO,
    AG_CNS,
    HT01_SAUDE_PS_ID
  )
  VALUES
  (
    AGSAUDE_ID_SEQ.NEXTVAL,
    'Benedito Pietro Fogaça',
    '68018511446',
    'SSP',
    'SP',
    '922221111',
    TO_DATE('09 Aug 1993', 'DD MON YYYY'),
    '915215891400018',
    V_HT01_ID 
  );
  
END;


-- ================================= FAMILIA ==========================================

DECLARE V_HT01_ID INTEGER;

BEGIN
  SELECT PS_ID INTO V_HT01_ID FROM HT01_SAUDE WHERE PS_NOME = 'Posto de Saude 1';

  INSERT INTO HT04_FAMILIA(
    FM_ID,
    FM_SOBRENOME,
    FM_CNS,
    FM_CEP,
    FM_ENDERECO,
    FM_COMPLEMENTO,
    FM_BAIRRO,
    FM_TELEFONE,
    FM_EMAIL,
    HT01_SAUDE_PS_ID
  )
  VALUES
  (
    FAMILIA_ID_SEQ.NEXTVAL,
    'Familia Castro Silva',
    '239456542800004',
    '79046-042',
    'Rua Jambo da Índia',
    '103',
    'Residencial Damha II',
    '999994444',
    'raquel.lais.castro@live.ie',
    V_HT01_ID
  );

END;

DECLARE V_HT01_ID INTEGER;

BEGIN
  SELECT PS_ID INTO V_HT01_ID FROM HT01_SAUDE WHERE PS_NOME = 'Posto de Saude 2';

  INSERT INTO HT04_FAMILIA(
    FM_ID,
    FM_SOBRENOME,
    FM_CNS,
    FM_CEP,
    FM_ENDERECO,
    FM_COMPLEMENTO,
    FM_BAIRRO,
    FM_TELEFONE,
    FM_EMAIL,
    HT01_SAUDE_PS_ID
  )
  VALUES
  (
    FAMILIA_ID_SEQ.NEXTVAL,
    'Familia Regina Melo',
    '794556807180002',
    '66077-345',
    'Rua Muiracatiara',
    '4568',
    'Terra Firme',
    '966665555',
    'milena_melo@santosferreira.br',
    V_HT01_ID
  );

END;


-- ================================= SEXO ==========================================


INSERT INTO HT10_SEXO(
  SX_ID,
  SX_IDENTIFICACAO
)
VALUES
(
  SEXO_ID_SEQ.NEXTVAL,
  'Masculino'
);

INSERT INTO HT10_SEXO(
  SX_ID,
  SX_IDENTIFICACAO
)
VALUES
(
  SEXO_ID_SEQ.NEXTVAL,
  'Feminino'
);


-- ================================= FAMILIA => MEMBROS ==========================================


DECLARE V_HT04_ID INTEGER;

BEGIN
  SELECT FM_ID INTO V_HT04_ID FROM HT04_FAMILIA WHERE FM_SOBRENOME = 'Familia Castro Silva';

  INSERT INTO HT05_MEMBRO(
    MB_ID,
    MB_NOME,
    MB_NOME_SOCIAL,
    MB_CPF,
    MB_CPF_EMISSOR,
    MB_CPF_UF,
    MB_RG,
    MB_NASCIMENTO,
    MB_RESPONSAVEL,
    HT04_FAMILIA_FM_ID,
    HT10_SEXO_SX_ID
  )
  VALUES
  (
    MEMBRO_ID_SEQ.NEXTVAL,
    'Bernardo Castro Silva',
    NULL,
    '90887092381',
    'SSP',
    'SP',
    '202457205',
    TO_DATE('06 Jun 1957', 'DD MON YYYY'),
    'S',
    V_HT04_ID,
    1
  );

END;

DECLARE V_HT04_ID INTEGER;

BEGIN
  SELECT FM_ID INTO V_HT04_ID FROM HT04_FAMILIA WHERE FM_SOBRENOME = 'Familia Castro Silva';

  INSERT INTO HT05_MEMBRO(
    MB_ID,
    MB_NOME,
    MB_NOME_SOCIAL,
    MB_CPF,
    MB_CPF_EMISSOR,
    MB_CPF_UF,
    MB_RG,
    MB_NASCIMENTO,
    MB_RESPONSAVEL,
    HT04_FAMILIA_FM_ID,
    HT10_SEXO_SX_ID
  )
  VALUES
  (
    MEMBRO_ID_SEQ.NEXTVAL,
    'Beatriz Castro Silva',
    NULL,
    '77979260180',
    'SSP',
    'SP',
    '265062202',
    TO_DATE('27 Mar 1963', 'DD MON YYYY'),
    'N',
    V_HT04_ID,
    2
  );

END;

DECLARE V_HT04_ID INTEGER;

BEGIN
  SELECT FM_ID INTO V_HT04_ID FROM HT04_FAMILIA WHERE FM_SOBRENOME = 'Familia Regina Melo';

  INSERT INTO HT05_MEMBRO(
    MB_ID,
    MB_NOME,
    MB_NOME_SOCIAL,
    MB_CPF,
    MB_CPF_EMISSOR,
    MB_CPF_UF,
    MB_RG,
    MB_NASCIMENTO,
    MB_RESPONSAVEL,
    HT04_FAMILIA_FM_ID,
    HT10_SEXO_SX_ID
  )
  VALUES
  (
    MEMBRO_ID_SEQ.NEXTVAL,
    'Cauã Pietro Viana Melo',
    NULL,
    '36790941169',
    'SSP',
    'SP',
    '186463066',
    TO_DATE('03 Jun 1961', 'DD MON YYYY'),
    'S',
    V_HT04_ID,
    1
  );

END;

DECLARE V_HT04_ID INTEGER;

BEGIN
  SELECT FM_ID INTO V_HT04_ID FROM HT04_FAMILIA WHERE FM_SOBRENOME = 'Familia Regina Melo';

  INSERT INTO HT05_MEMBRO(
    MB_ID,
    MB_NOME,
    MB_NOME_SOCIAL,
    MB_CPF,
    MB_CPF_EMISSOR,
    MB_CPF_UF,
    MB_RG,
    MB_NASCIMENTO,
    MB_RESPONSAVEL,
    HT04_FAMILIA_FM_ID,
    HT10_SEXO_SX_ID
  )
  VALUES
  (
    MEMBRO_ID_SEQ.NEXTVAL,
    'Lorena Nair Melo',
    NULL,
    '81067802797',
    'SSP',
    'SP',
    '489222985',
    TO_DATE('11 Feb 1965', 'DD MON YYYY'),
    'N',
    V_HT04_ID,
    2
  );

END;


-- ================================= REGISTRO DE VACINA ==========================================

INSERT INTO HT06_REGVACIN(
  RV_ID,
  RV_NOME,
  RV_DATA,
  RV_VENCIMENTO,
  HT05_MEMBRO_MB_ID
)
VALUES
(
  REGVACIN_ID_SEQ.NEXTVAL,
  'Coronavac',
  SYSDATE,
  ADD_MONTHS(SYSDATE, 1),
  6
);
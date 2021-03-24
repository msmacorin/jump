/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases V8.1.2                     */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          jump.dez                                        */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2014-08-06 11:31                                */
/* ---------------------------------------------------------------------- */


create schema admin;
create schema estoque;
create schema pcm;
create schema pessoa;
create schema contabilidade;
create schema timesheet;

/* ---------------------------------------------------------------------- */
/* Add sequences                                                          */
/* ---------------------------------------------------------------------- */

CREATE SEQUENCE seq_cep_localidade INCREMENT 1 START 1;

CREATE SEQUENCE seq_cliente INCREMENT 1 START 1;

CREATE SEQUENCE seq_consulta INCREMENT 1 START 1;

CREATE SEQUENCE seq_criticidade INCREMENT 1 START 1;

CREATE SEQUENCE seq_fornecedor INCREMENT 1 START 1;

CREATE SEQUENCE seq_genero_produto INCREMENT 1 START 1;

CREATE SEQUENCE seq_grupo_empresa INCREMENT 1 START 1;

CREATE SEQUENCE seq_grupo_produto INCREMENT 1 START 1;

CREATE SEQUENCE seq_licenca INCREMENT 1 START 1;

CREATE SEQUENCE seq_localidade INCREMENT 1 START 1;

CREATE SEQUENCE seq_login_token INCREMENT 1 START 1;

CREATE SEQUENCE seq_pais INCREMENT 1 START 1;

CREATE SEQUENCE seq_perfil INCREMENT 1 START 1;

CREATE SEQUENCE seq_pessoa INCREMENT 1 START 1;

CREATE SEQUENCE seq_pessoa_endereco INCREMENT 1 START 1;

CREATE SEQUENCE seq_prioridade INCREMENT 1 START 1;

CREATE SEQUENCE seq_programa INCREMENT 1 START 1;

CREATE SEQUENCE seq_tipo_documento INCREMENT 1 START 1;

CREATE SEQUENCE seq_tipo_endereco INCREMENT 1 START 1;

CREATE SEQUENCE seq_tipomanutencao INCREMENT 1 START 1;

CREATE SEQUENCE seq_unidade_federacao INCREMENT 1 START 1;

CREATE SEQUENCE seq_usuario INCREMENT 1 START 1;

/* ---------------------------------------------------------------------- */
/* Add domains                                                            */
/* ---------------------------------------------------------------------- */

CREATE DOMAIN ID AS INTEGER;

CREATE DOMAIN SIM_NAO AS CHARACTER VARYING(1) DEFAULT 'N' CHECK (value in ('S', 'N'));

CREATE DOMAIN TIPO_PERMISSAO AS CHARACTER VARYING(1) CHECK (value in ('P', 'B'));

CREATE DOMAIN MODULO AS CHARACTER VARYING(100) CHECK (value in ('ADMIN', 'ESTOQUE', 'PCM', 'PESSOA', 'CONTABILIDADE', 'TIMESHEET'));

CREATE DOMAIN QUANTIDADE AS NUMERIC(12,4);

CREATE DOMAIN MONETARIO AS NUMERIC(12,2);

CREATE DOMAIN SITUACAO AS INTEGER CHECK (value in (1, 2, 3));

CREATE DOMAIN TIPO_PESSOA AS CHARACTER VARYING(3) CHECK (value in ('FIS', 'JUR', 'OUT'));

/* ---------------------------------------------------------------------- */
/* Add tables                                                             */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "admin.grupo_empresa"                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.grupo_empresa (
    id_grupo_empresa ID  NOT NULL,
    nome CHARACTER VARYING(50)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    CONSTRAINT PK_grupo_empresa PRIMARY KEY (id_grupo_empresa)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.gre_modulo"                                           */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.gre_modulo (
    id_gre_modulo ID  NOT NULL,
    modulo MODULO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_gre_modulo PRIMARY KEY (id_gre_modulo)
);

COMMENT ON TABLE admin.gre_modulo IS 'Tabela onde é indicado quais os modulos que a empresa tem acesso.';

/* ---------------------------------------------------------------------- */
/* Add table "admin.programa"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.programa (
    id_programa ID  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    action_web CHARACTER VARYING(200)  NOT NULL,
    modulo MODULO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    CONSTRAINT PK_programa PRIMARY KEY (id_programa)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.programa_modulo"                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.programa_modulo (
    id_programa_modulo ID  NOT NULL,
    id_programa INTEGER  NOT NULL,
    modulo MODULO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    CONSTRAINT PK_programa_modulo PRIMARY KEY (id_programa_modulo)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.permissao_programa"                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.permissao_programa (
    id_permissao_programa ID  NOT NULL,
    tipo_permissao TIPO_PERMISSAO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER,
    id_programa INTEGER  NOT NULL,
    CONSTRAINT PK_permissao_programa PRIMARY KEY (id_permissao_programa)
);

COMMENT ON TABLE admin.permissao_programa IS 'ON';

/* ---------------------------------------------------------------------- */
/* Add table "admin.permissao_modulo"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.permissao_modulo (
    id_permissao_modulo ID  NOT NULL,
    tipo_permissao TIPO_PERMISSAO  NOT NULL,
    modulo MODULO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_permissao_modulo PRIMARY KEY (id_permissao_modulo)
);

COMMENT ON TABLE admin.permissao_modulo IS 'ON';

/* ---------------------------------------------------------------------- */
/* Add table "pcm.prioridade"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.prioridade (
    id_prioridade ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    tempo_resolucao NUMERIC  NOT NULL,
    CONSTRAINT PK_prioridade PRIMARY KEY (id_prioridade)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.criticidade"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.criticidade (
    id_criticidade ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    faixa_inicio NUMERIC  NOT NULL,
    faixa_fim NUMERIC  NOT NULL,
    CONSTRAINT PK_criticidade PRIMARY KEY (id_criticidade)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.perfil"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.perfil (
    id_perfil ID  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_perfil PRIMARY KEY (id_perfil)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.tipo_manutencao"                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.tipo_manutencao (
    id_tipo_manutencao ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_tipo_manutencao PRIMARY KEY (id_tipo_manutencao)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.tim_prioridade"                                         */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.tim_prioridade (
    id_tim_prioridade ID  NOT NULL,
    id_tipo_manutencao INTEGER  NOT NULL,
    id_prioridade INTEGER  NOT NULL,
    CONSTRAINT PK_tim_prioridade PRIMARY KEY (id_tim_prioridade)
);

COMMENT ON TABLE pcm.tim_prioridade IS 'ON';

/* ---------------------------------------------------------------------- */
/* Add table "pcm.plano_manutencao"                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.plano_manutencao (
    id_plano_manutencao ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    id_plm_superior INTEGER,
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_plano_manutencao PRIMARY KEY (id_plano_manutencao)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.plm_item"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.plm_item (
    id_plm_item ID  NOT NULL,
    id_plano_manutencao INTEGER,
    id_tipo_manutencao INTEGER,
    CONSTRAINT PK_plm_item PRIMARY KEY (id_plm_item)
);

COMMENT ON TABLE pcm.plm_item IS 'ON';

/* ---------------------------------------------------------------------- */
/* Add table "pcm.nivel"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.nivel (
    id_nivel ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    seta_criticidade SIM_NAO  NOT NULL,
    seta_servico SIM_NAO  NOT NULL,
    seta_peca SIM_NAO  NOT NULL,
    CONSTRAINT PK_nivel PRIMARY KEY (id_nivel)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.matriz_criticidade"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.matriz_criticidade (
    id_matriz_criticidade ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_matriz_criticidade PRIMARY KEY (id_matriz_criticidade)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.mac_item"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.mac_item (
    id_mac_item ID  NOT NULL,
    id_matriz_criticidade INTEGER,
    descricao CHARACTER VARYING(100)  NOT NULL,
    peso INTEGER  NOT NULL,
    CONSTRAINT PK_mac_item PRIMARY KEY (id_mac_item)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.pmi_peca"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.pmi_peca (
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.trabalho"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.trabalho (
    id_trabalho ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    custo_hora MONETARIO,
    CONSTRAINT PK_trabalho PRIMARY KEY (id_trabalho)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.genero_produto"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.genero_produto (
    id_genero_produto ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_genero_produto PRIMARY KEY (id_genero_produto)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.grupo_produto"                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.grupo_produto (
    id_grupo_produto ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_grupo_produto PRIMARY KEY (id_grupo_produto)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.unidade_medida"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.unidade_medida (
    id_unidade_medida CHARACTER VARYING(5)  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_unidade_medida PRIMARY KEY (id_unidade_medida)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.ncm"                                                */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.ncm (
    id_ncm CHARACTER VARYING(11)  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    id_ncm_pai CHARACTER VARYING(11),
    descricao CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_ncm PRIMARY KEY (id_ncm)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.licenca"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.licenca (
    id_licenca ID  NOT NULL,
    inicio DATE  NOT NULL,
    prazo INTEGER  NOT NULL,
    validacao CHARACTER VARYING(100)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    PRIMARY KEY (id_licenca)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.tipo_documento"                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.tipo_documento (
    id_tipo_documento ID  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    CONSTRAINT PK_tipo_documento PRIMARY KEY (id_tipo_documento)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.pessoa"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.pessoa (
    id_pessoa ID  NOT NULL,
    tipo_pessoa TIPO_PESSOA  NOT NULL,
    identificacao CHARACTER(20)  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    nome_reduzido CHARACTER VARYING(50)  NOT NULL,
    data_inclusao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_pessoa PRIMARY KEY (id_pessoa),
    CONSTRAINT TUC_pessoa_1 UNIQUE (identificacao, id_grupo_empresa)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.pessoa_documento"                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.pessoa_documento (
    id_pessoa_documento ID  NOT NULL,
    id_pessoa INTEGER  NOT NULL,
    id_tipo_documento INTEGER  NOT NULL,
    identificacao CHARACTER(50)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    CONSTRAINT PK_pessoa_documento PRIMARY KEY (id_pessoa_documento)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.tipo_endereco"                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.tipo_endereco (
    id_tipo_endereco ID  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_tipo_endereco PRIMARY KEY (id_tipo_endereco)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.cliente"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.cliente (
    id_cliente ID  NOT NULL,
    id_pessoa INTEGER  NOT NULL,
    situacao SITUACAO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    CONSTRAINT PK_cliente PRIMARY KEY (id_cliente)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.fornecedor"                                          */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.fornecedor (
    id_fornecedor ID  NOT NULL,
    id_pessoa INTEGER  NOT NULL,
    situacao SITUACAO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    CONSTRAINT PK_fornecedor PRIMARY KEY (id_fornecedor)
);

/* ---------------------------------------------------------------------- */
/* Add table "contabilidade.centro_custo"                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE contabilidade.centro_custo (
    id_centro_custo ID  NOT NULL,
    codigo CHARACTER VARYING(20)  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_centro_custo PRIMARY KEY (id_centro_custo)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.cargo"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.cargo (
    id_cargo ID  NOT NULL,
    id_centro_custo INTEGER,
    nome CHARACTER VARYING(100)  NOT NULL,
    custo_hora MONETARIO,
    CONSTRAINT PK_cargo PRIMARY KEY (id_cargo)
);

/* ---------------------------------------------------------------------- */
/* Add table "timesheet.tarefa"                                           */
/* ---------------------------------------------------------------------- */

CREATE TABLE timesheet.tarefa (
    id_tarefa ID  NOT NULL,
    CONSTRAINT PK_tarefa PRIMARY KEY (id_tarefa)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.pais"                                                */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.pais (
    id_pais INTEGER  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    codigo_banco_central CHARACTER VARYING(5),
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_pais PRIMARY KEY (id_pais),
    CONSTRAINT TUC_pais_1 UNIQUE (codigo_banco_central, id_grupo_empresa, situacao)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.pem_perfil"                                           */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.pem_perfil (
    id_pem_perfil ID  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_permissao_modulo INTEGER  NOT NULL,
    id_perfil INTEGER  NOT NULL,
    CONSTRAINT PK_pem_perfil PRIMARY KEY (id_pem_perfil)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.pep_perfil"                                           */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.pep_perfil (
    id_pep_perfil ID  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_permissao_programa INTEGER  NOT NULL,
    id_perfil INTEGER  NOT NULL,
    CONSTRAINT PK_pep_perfil PRIMARY KEY (id_pep_perfil)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa_fisica"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa_fisica (
    id_pessoa INTEGER  NOT NULL,
    data_alteracao DATE  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_nascimento DATE  NOT NULL,
    sexo CHARACTER(40),
    CONSTRAINT PK_pessoa_fisica PRIMARY KEY (id_pessoa)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa_juridica"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa_juridica (
    id_pessoa INTEGER  NOT NULL,
    CONSTRAINT PK_pessoa_juridica PRIMARY KEY (id_pessoa)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.usuario"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.usuario (
    id_usuario ID  NOT NULL,
    id_perfil INTEGER,
    id_grupo_empresa INTEGER,
    nome CHARACTER VARYING(50)  NOT NULL,
    usuario CHARACTER VARYING(50)  NOT NULL,
    senha CHARACTER VARYING(50)  NOT NULL,
    email CHARACTER VARYING(50)  NOT NULL,
    alterar_senha SIM_NAO  NOT NULL,
    data_expiracao DATE,
    data_criacao TIMESTAMP  NOT NULL,
    data_alteracao TIMESTAMP  NOT NULL,
    situacao SITUACAO  NOT NULL,
    CONSTRAINT PK_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT TUC_usuario_1 UNIQUE (id_grupo_empresa, usuario),
    CONSTRAINT TUC_usuario_2 UNIQUE (id_grupo_empresa, email)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.produto"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.produto (
    id_produto ID  NOT NULL,
    id_genero_produto INTEGER,
    id_grupo_empresa INTEGER  NOT NULL,
    id_grupo_produto INTEGER,
    id_unidade_medida CHARACTER VARYING(5)  NOT NULL,
    id_ncm CHARACTER VARYING(11),
    descricao CHARACTER VARYING(150)  NOT NULL,
    peso_bruto QUANTIDADE,
    peso_liquido NUMERIC(11,4),
    CONSTRAINT PK_produto PRIMARY KEY (id_produto)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.conversao_produto"                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.conversao_produto (
    id_conversao_produto ID  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    id_produto_destino INTEGER  NOT NULL,
    id_produto_origem INTEGER  NOT NULL,
    fator QUANTIDADE  NOT NULL,
    CONSTRAINT PK_conversao_produto PRIMARY KEY (id_conversao_produto)
);

COMMENT ON TABLE estoque.conversao_produto IS 'ON';

/* ---------------------------------------------------------------------- */
/* Add table "pcm.objeto_tag"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.objeto_tag (
    id_objeto_tag ID  NOT NULL,
    id_nivel INTEGER  NOT NULL,
    id_matriz_criticidade INTEGER  NOT NULL,
    id_obt_superior INTEGER,
    id_grupo_empresa INTEGER  NOT NULL,
    descricao CHARACTER VARYING(100)  NOT NULL,
    complemento TEXT,
    CONSTRAINT PK_objeto_tag PRIMARY KEY (id_objeto_tag)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.obt_criticidade"                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.obt_criticidade (
    id_obt_criticidade ID  NOT NULL,
    id_mac_item INTEGER  NOT NULL,
    id_objeto_tag INTEGER  NOT NULL,
    peso INTEGER  NOT NULL,
    CONSTRAINT PK_obt_criticidade PRIMARY KEY (id_obt_criticidade)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.pmi_servico"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.pmi_servico (
    id_pmi_servico ID  NOT NULL,
    id_plm_item INTEGER  NOT NULL,
    id_trabalho INTEGER  NOT NULL,
    CONSTRAINT PK_pmi_servico PRIMARY KEY (id_pmi_servico)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.pmis_peca"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.pmis_peca (
    id_pmis_peca ID  NOT NULL,
    id_pmi_servico INTEGER  NOT NULL,
    id_produto INTEGER  NOT NULL,
    quantidade QUANTIDADE  NOT NULL,
    CONSTRAINT PK_pmis_peca PRIMARY KEY (id_pmis_peca)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.obt_peca"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.obt_peca (
    id_obt_peca ID  NOT NULL,
    id_produto INTEGER  NOT NULL,
    id_objeto_tag INTEGER  NOT NULL,
    quantidade QUANTIDADE  NOT NULL,
    CONSTRAINT PK_obt_peca PRIMARY KEY (id_obt_peca)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.obt_servico"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.obt_servico (
    id_obt_servico ID  NOT NULL,
    id_objeto_tag INTEGER  NOT NULL,
    id_trabalho INTEGER  NOT NULL,
    CONSTRAINT PK_obt_servico PRIMARY KEY (id_obt_servico)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.ots_peca"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.ots_peca (
    id_ots_peca ID  NOT NULL,
    id_obt_servico INTEGER  NOT NULL,
    id_produto INTEGER  NOT NULL,
    quantidade QUANTIDADE  NOT NULL,
    CONSTRAINT PK_ots_peca PRIMARY KEY (id_ots_peca)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.obt_imagem"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.obt_imagem (
    id_obt_imagem ID  NOT NULL,
    id_objeto_tag INTEGER  NOT NULL,
    arquivo CHARACTER  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_obt_imagem PRIMARY KEY (id_obt_imagem)
);

/* ---------------------------------------------------------------------- */
/* Add table "pcm.obt_manual"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE pcm.obt_manual (
    id_obt_manual ID  NOT NULL,
    id_objeto_tag INTEGER  NOT NULL,
    arquivo CHARACTER  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    CONSTRAINT PK_obt_manual PRIMARY KEY (id_obt_manual)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.login_token"                                          */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.login_token (
    id_login_token ID  NOT NULL,
    token CHARACTER VARYING(50)  NOT NULL,
    id_usuario INTEGER  NOT NULL,
    CONSTRAINT PK_login_token PRIMARY KEY (id_login_token)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.unidade_federacao"                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.unidade_federacao (
    id_uf ID  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    sigla CHARACTER VARYING(2)  NOT NULL,
    codigo_ibge INTEGER,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_pais INTEGER  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_unidade_federacao PRIMARY KEY (id_uf),
    CONSTRAINT TUC_unidade_federacao_1 UNIQUE (codigo_ibge, situacao, id_grupo_empresa)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.recurso"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.recurso (
    id_recurso ID  NOT NULL,
    id_pessoa INTEGER  NOT NULL,
    id_centro_custo INTEGER  NOT NULL,
    custo_hora MONETARIO,
    CONSTRAINT PK_recurso PRIMARY KEY (id_recurso)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.localidade"                                          */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.localidade (
    id_localidade INTEGER  NOT NULL,
    nome CHARACTER VARYING(100)  NOT NULL,
    codigo_ibge INTEGER,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_uf INTEGER  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_localidade PRIMARY KEY (id_localidade),
    CONSTRAINT TUC_localidade_1 UNIQUE (codigo_ibge, id_grupo_empresa, situacao)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.cep_localidade"                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.cep_localidade (
    id_cep_localidade ID  NOT NULL,
    cep CHARACTER VARYING(10)  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_localidade INTEGER  NOT NULL,
    id_grupo_empresa INTEGER  NOT NULL,
    CONSTRAINT PK_localidade_cep PRIMARY KEY (id_cep_localidade),
    CONSTRAINT TUC_cep_localidade_1 UNIQUE (cep, id_grupo_empresa, situacao)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.pem_usuario"                                          */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.pem_usuario (
    id_pem_usuario ID  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_usuario INTEGER  NOT NULL,
    id_permissao_modulo INTEGER  NOT NULL,
    CONSTRAINT PK_pem_usuario PRIMARY KEY (id_pem_usuario)
);

/* ---------------------------------------------------------------------- */
/* Add table "admin.pep_usuario"                                          */
/* ---------------------------------------------------------------------- */

CREATE TABLE admin.pep_usuario (
    id_pep_usuario ID  NOT NULL,
    data_criacao TIMESTAMP  NOT NULL,
    data_alteracao TIMESTAMP  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_usuario INTEGER  NOT NULL,
    id_permissao_programa INTEGER  NOT NULL,
    CONSTRAINT PK_pep_usuario PRIMARY KEY (id_pep_usuario)
);

/* ---------------------------------------------------------------------- */
/* Add table "estoque.iva"                                                */
/* ---------------------------------------------------------------------- */

CREATE TABLE estoque.iva (
    id_iva ID  NOT NULL,
    id_ncm CHARACTER VARYING(11)  NOT NULL,
    id_uf_origem INTEGER  NOT NULL,
    id_uf_destino INTEGER  NOT NULL,
    inicio DATE  NOT NULL,
    percentual QUANTIDADE  NOT NULL,
    CONSTRAINT PK_iva PRIMARY KEY (id_iva),
    CONSTRAINT TUC_iva_1 UNIQUE (inicio, id_uf_origem, id_uf_destino)
);

/* ---------------------------------------------------------------------- */
/* Add table "pessoa.pessoa_endereco"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE pessoa.pessoa_endereco (
    id_pessoa_endereco ID  NOT NULL,
    id_pessoa INTEGER  NOT NULL,
    id_tipo_endereco INTEGER  NOT NULL,
    logradouro CHARACTER VARYING(200)  NOT NULL,
    numero CHARACTER VARYING(10)  NOT NULL,
    bairro CHARACTER VARYING(50),
    complemento CHARACTER VARYING(50),
    principal SIM_NAO  NOT NULL,
    data_criacao DATE  NOT NULL,
    data_alteracao DATE  NOT NULL,
    situacao SITUACAO  NOT NULL,
    id_cep_localidade INTEGER  NOT NULL,
    CONSTRAINT PK_pessoa_endereco PRIMARY KEY (id_pessoa_endereco)
);

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */

ALTER TABLE admin.usuario ADD CONSTRAINT grupo_empresa_usuario 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE admin.usuario ADD CONSTRAINT perfil_usuario 
    FOREIGN KEY (id_perfil) REFERENCES admin.perfil (id_perfil);

ALTER TABLE admin.gre_modulo ADD CONSTRAINT grupo_empresa_gre_modulo 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE admin.programa_modulo ADD CONSTRAINT programa_programa_modulo 
    FOREIGN KEY (id_programa) REFERENCES admin.programa (id_programa);

ALTER TABLE admin.permissao_programa ADD CONSTRAINT programa_permissao_programa 
    FOREIGN KEY (id_programa) REFERENCES admin.programa (id_programa);

ALTER TABLE admin.permissao_programa ADD CONSTRAINT grupo_empresa_permissao_programa 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE admin.permissao_modulo ADD CONSTRAINT grupo_empresa_permissao_modulo 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE estoque.produto ADD CONSTRAINT grupo_empresa_produto 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE estoque.produto ADD CONSTRAINT genero_produto_produto 
    FOREIGN KEY (id_genero_produto) REFERENCES estoque.genero_produto (id_genero_produto);

ALTER TABLE estoque.produto ADD CONSTRAINT grupo_produto_produto 
    FOREIGN KEY (id_grupo_produto) REFERENCES estoque.grupo_produto (id_grupo_produto);

ALTER TABLE estoque.produto ADD CONSTRAINT unidade_medida_produto 
    FOREIGN KEY (id_unidade_medida) REFERENCES estoque.unidade_medida (id_unidade_medida);

ALTER TABLE estoque.produto ADD CONSTRAINT ncm_produto 
    FOREIGN KEY (id_ncm) REFERENCES estoque.ncm (id_ncm);

ALTER TABLE estoque.conversao_produto ADD CONSTRAINT produto_conversao_produto_2 
    FOREIGN KEY (id_produto_origem) REFERENCES estoque.produto (id_produto);

ALTER TABLE estoque.conversao_produto ADD CONSTRAINT produto_conversao_produto 
    FOREIGN KEY (id_produto_destino) REFERENCES estoque.produto (id_produto);

ALTER TABLE estoque.conversao_produto ADD CONSTRAINT grupo_empresa_conversao_produto 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.prioridade ADD CONSTRAINT grupo_empresa_prioridade 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.criticidade ADD CONSTRAINT grupo_empresa_criticidade 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE admin.perfil ADD CONSTRAINT grupo_empresa_perfil 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.tipo_manutencao ADD CONSTRAINT grupo_empresa_tipo_manutencao 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.tim_prioridade ADD CONSTRAINT tipo_manutencao_tim_prioridade 
    FOREIGN KEY (id_tipo_manutencao) REFERENCES pcm.tipo_manutencao (id_tipo_manutencao);

ALTER TABLE pcm.tim_prioridade ADD CONSTRAINT prioridade_tim_prioridade 
    FOREIGN KEY (id_prioridade) REFERENCES pcm.prioridade (id_prioridade);

ALTER TABLE pcm.plano_manutencao ADD CONSTRAINT grupo_empresa_plano_manutencao 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.plano_manutencao ADD CONSTRAINT plano_manutencao_plano_manutencao 
    FOREIGN KEY (id_plm_superior) REFERENCES pcm.plano_manutencao (id_plano_manutencao);

ALTER TABLE pcm.plm_item ADD CONSTRAINT plano_manutencao_plm_item 
    FOREIGN KEY (id_plano_manutencao) REFERENCES pcm.plano_manutencao (id_plano_manutencao);

ALTER TABLE pcm.plm_item ADD CONSTRAINT tipo_manutencao_plm_item 
    FOREIGN KEY (id_tipo_manutencao) REFERENCES pcm.tipo_manutencao (id_tipo_manutencao);

ALTER TABLE pcm.objeto_tag ADD CONSTRAINT nivel_objeto_tag 
    FOREIGN KEY (id_nivel) REFERENCES pcm.nivel (id_nivel);

ALTER TABLE pcm.objeto_tag ADD CONSTRAINT matriz_criticidade_objeto_tag 
    FOREIGN KEY (id_matriz_criticidade) REFERENCES pcm.matriz_criticidade (id_matriz_criticidade);

ALTER TABLE pcm.objeto_tag ADD CONSTRAINT objeto_tag_objeto_tag 
    FOREIGN KEY (id_obt_superior) REFERENCES pcm.objeto_tag (id_objeto_tag);

ALTER TABLE pcm.objeto_tag ADD CONSTRAINT grupo_empresa_objeto_tag 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.nivel ADD CONSTRAINT grupo_empresa_nivel 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.matriz_criticidade ADD CONSTRAINT grupo_empresa_matriz_criticidade 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pcm.mac_item ADD CONSTRAINT matriz_criticidade_mac_item 
    FOREIGN KEY (id_matriz_criticidade) REFERENCES pcm.matriz_criticidade (id_matriz_criticidade);

ALTER TABLE pcm.obt_criticidade ADD CONSTRAINT objeto_tag_obt_criticidade 
    FOREIGN KEY (id_objeto_tag) REFERENCES pcm.objeto_tag (id_objeto_tag);

ALTER TABLE pcm.obt_criticidade ADD CONSTRAINT mac_item_obt_criticidade 
    FOREIGN KEY (id_mac_item) REFERENCES pcm.mac_item (id_mac_item);

ALTER TABLE pcm.pmi_servico ADD CONSTRAINT plm_item_pmi_servico 
    FOREIGN KEY (id_plm_item) REFERENCES pcm.plm_item (id_plm_item);

ALTER TABLE pcm.pmi_servico ADD CONSTRAINT trabalho_pmi_servico 
    FOREIGN KEY (id_trabalho) REFERENCES pcm.trabalho (id_trabalho);

ALTER TABLE pcm.pmis_peca ADD CONSTRAINT pmi_servico_pmis_peca 
    FOREIGN KEY (id_pmi_servico) REFERENCES pcm.pmi_servico (id_pmi_servico);

ALTER TABLE pcm.pmis_peca ADD CONSTRAINT produto_pmis_peca 
    FOREIGN KEY (id_produto) REFERENCES estoque.produto (id_produto);

ALTER TABLE pcm.obt_peca ADD CONSTRAINT objeto_tag_obt_peca 
    FOREIGN KEY (id_objeto_tag) REFERENCES pcm.objeto_tag (id_objeto_tag);

ALTER TABLE pcm.obt_peca ADD CONSTRAINT produto_obt_peca 
    FOREIGN KEY (id_produto) REFERENCES estoque.produto (id_produto);

ALTER TABLE pcm.obt_servico ADD CONSTRAINT objeto_tag_obt_servico 
    FOREIGN KEY (id_objeto_tag) REFERENCES pcm.objeto_tag (id_objeto_tag);

ALTER TABLE pcm.obt_servico ADD CONSTRAINT trabalho_obt_servico 
    FOREIGN KEY (id_trabalho) REFERENCES pcm.trabalho (id_trabalho);

ALTER TABLE pcm.ots_peca ADD CONSTRAINT obt_servico_ots_peca 
    FOREIGN KEY (id_obt_servico) REFERENCES pcm.obt_servico (id_obt_servico);

ALTER TABLE pcm.ots_peca ADD CONSTRAINT produto_ots_peca 
    FOREIGN KEY (id_produto) REFERENCES estoque.produto (id_produto);

ALTER TABLE pcm.obt_imagem ADD CONSTRAINT objeto_tag_obt_imagem 
    FOREIGN KEY (id_objeto_tag) REFERENCES pcm.objeto_tag (id_objeto_tag);

ALTER TABLE pcm.obt_manual ADD CONSTRAINT objeto_tag_obt_manual 
    FOREIGN KEY (id_objeto_tag) REFERENCES pcm.objeto_tag (id_objeto_tag);

ALTER TABLE pcm.trabalho ADD CONSTRAINT grupo_empresa_trabalho 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE admin.login_token ADD CONSTRAINT usuario_login_token 
    FOREIGN KEY (id_usuario) REFERENCES admin.usuario (id_usuario);

ALTER TABLE estoque.genero_produto ADD CONSTRAINT grupo_empresa_genero_produto 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE estoque.grupo_produto ADD CONSTRAINT grupo_empresa_grupo_produto 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE estoque.unidade_medida ADD CONSTRAINT grupo_empresa_unidade_medida 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE estoque.ncm ADD CONSTRAINT ncm_ncm 
    FOREIGN KEY (id_ncm_pai) REFERENCES estoque.ncm (id_ncm);

ALTER TABLE estoque.ncm ADD CONSTRAINT grupo_empresa_ncm 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE estoque.iva ADD CONSTRAINT ncm_iva 
    FOREIGN KEY (id_ncm) REFERENCES estoque.ncm (id_ncm);

ALTER TABLE estoque.iva ADD CONSTRAINT unidade_federacao_iva 
    FOREIGN KEY (id_uf_origem) REFERENCES pessoa.unidade_federacao (id_uf);

ALTER TABLE estoque.iva ADD CONSTRAINT unidade_federacao_iva22 
    FOREIGN KEY (id_uf_destino) REFERENCES pessoa.unidade_federacao (id_uf);

ALTER TABLE pessoa.unidade_federacao ADD CONSTRAINT grupo_empresa_unidade_federacao 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pessoa.unidade_federacao ADD CONSTRAINT pais_unidade_federacao 
    FOREIGN KEY (id_pais) REFERENCES pessoa.pais (id_pais);

ALTER TABLE admin.licenca ADD CONSTRAINT grupo_empresa_licenca 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pessoa.pessoa ADD CONSTRAINT grupo_empresa_pessoa 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pessoa.pessoa_documento ADD CONSTRAINT pessoa_pessoa_documento 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

ALTER TABLE pessoa.pessoa_documento ADD CONSTRAINT tipo_documento_pessoa_documento 
    FOREIGN KEY (id_tipo_documento) REFERENCES pessoa.tipo_documento (id_tipo_documento);

ALTER TABLE pessoa.tipo_endereco ADD CONSTRAINT grupo_empresa_tipo_endereco 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pessoa.pessoa_endereco ADD CONSTRAINT tipo_endereco_pessoa_endereco 
    FOREIGN KEY (id_tipo_endereco) REFERENCES pessoa.tipo_endereco (id_tipo_endereco);

ALTER TABLE pessoa.pessoa_endereco ADD CONSTRAINT pessoa_pessoa_endereco 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

ALTER TABLE pessoa.pessoa_endereco ADD CONSTRAINT cep_localidade_pessoa_endereco 
    FOREIGN KEY (id_cep_localidade) REFERENCES pessoa.cep_localidade (id_cep_localidade);

ALTER TABLE pessoa.cliente ADD CONSTRAINT pessoa_cliente 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

ALTER TABLE pessoa.fornecedor ADD CONSTRAINT pessoa_fornecedor 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

ALTER TABLE pessoa.recurso ADD CONSTRAINT pessoa_recurso 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

ALTER TABLE pessoa.recurso ADD CONSTRAINT centro_custo_recurso 
    FOREIGN KEY (id_centro_custo) REFERENCES contabilidade.centro_custo (id_centro_custo);

ALTER TABLE pessoa.cargo ADD CONSTRAINT centro_custo_cargo 
    FOREIGN KEY (id_centro_custo) REFERENCES contabilidade.centro_custo (id_centro_custo);

ALTER TABLE pessoa.localidade ADD CONSTRAINT unidade_federacao_localidade 
    FOREIGN KEY (id_uf) REFERENCES pessoa.unidade_federacao (id_uf);

ALTER TABLE pessoa.localidade ADD CONSTRAINT grupo_empresa_localidade 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pessoa.pais ADD CONSTRAINT grupo_empresa_pais 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE pessoa.cep_localidade ADD CONSTRAINT localidade_localidade_cep 
    FOREIGN KEY (id_localidade) REFERENCES pessoa.localidade (id_localidade);

ALTER TABLE pessoa.cep_localidade ADD CONSTRAINT grupo_empresa_cep_localidade 
    FOREIGN KEY (id_grupo_empresa) REFERENCES admin.grupo_empresa (id_grupo_empresa);

ALTER TABLE admin.pem_usuario ADD CONSTRAINT usuario_pem_usuario 
    FOREIGN KEY (id_usuario) REFERENCES admin.usuario (id_usuario);

ALTER TABLE admin.pem_usuario ADD CONSTRAINT permissao_modulo_pem_usuario 
    FOREIGN KEY (id_permissao_modulo) REFERENCES admin.permissao_modulo (id_permissao_modulo);

ALTER TABLE admin.pem_perfil ADD CONSTRAINT permissao_modulo_pem_perfil 
    FOREIGN KEY (id_permissao_modulo) REFERENCES admin.permissao_modulo (id_permissao_modulo);

ALTER TABLE admin.pem_perfil ADD CONSTRAINT perfil_pem_perfil 
    FOREIGN KEY (id_perfil) REFERENCES admin.perfil (id_perfil);

ALTER TABLE admin.pep_usuario ADD CONSTRAINT usuario_pep_usuario 
    FOREIGN KEY (id_usuario) REFERENCES admin.usuario (id_usuario);

ALTER TABLE admin.pep_usuario ADD CONSTRAINT permissao_programa_pep_usuario 
    FOREIGN KEY (id_permissao_programa) REFERENCES admin.permissao_programa (id_permissao_programa);

ALTER TABLE admin.pep_perfil ADD CONSTRAINT permissao_programa_pep_perfil 
    FOREIGN KEY (id_permissao_programa) REFERENCES admin.permissao_programa (id_permissao_programa);

ALTER TABLE admin.pep_perfil ADD CONSTRAINT perfil_pep_perfil 
    FOREIGN KEY (id_perfil) REFERENCES admin.perfil (id_perfil);

ALTER TABLE pessoa_fisica ADD CONSTRAINT pessoa_pessoa_fisica 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

ALTER TABLE pessoa_juridica ADD CONSTRAINT pessoa_pessoa_juridica 
    FOREIGN KEY (id_pessoa) REFERENCES pessoa.pessoa (id_pessoa);

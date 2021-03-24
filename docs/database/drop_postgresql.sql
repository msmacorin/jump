/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases V8.1.2                     */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          jump.dez                                        */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database drop script                            */
/* Created on:            2014-08-06 11:31                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Drop foreign key constraints                                           */
/* ---------------------------------------------------------------------- */

ALTER TABLE admin.usuario DROP CONSTRAINT grupo_empresa_usuario;

ALTER TABLE admin.usuario DROP CONSTRAINT perfil_usuario;

ALTER TABLE admin.gre_modulo DROP CONSTRAINT grupo_empresa_gre_modulo;

ALTER TABLE admin.programa_modulo DROP CONSTRAINT programa_programa_modulo;

ALTER TABLE admin.permissao_programa DROP CONSTRAINT programa_permissao_programa;

ALTER TABLE admin.permissao_programa DROP CONSTRAINT grupo_empresa_permissao_programa;

ALTER TABLE admin.permissao_modulo DROP CONSTRAINT grupo_empresa_permissao_modulo;

ALTER TABLE estoque.produto DROP CONSTRAINT grupo_empresa_produto;

ALTER TABLE estoque.produto DROP CONSTRAINT genero_produto_produto;

ALTER TABLE estoque.produto DROP CONSTRAINT grupo_produto_produto;

ALTER TABLE estoque.produto DROP CONSTRAINT unidade_medida_produto;

ALTER TABLE estoque.produto DROP CONSTRAINT ncm_produto;

ALTER TABLE estoque.conversao_produto DROP CONSTRAINT produto_conversao_produto_2;

ALTER TABLE estoque.conversao_produto DROP CONSTRAINT produto_conversao_produto;

ALTER TABLE estoque.conversao_produto DROP CONSTRAINT grupo_empresa_conversao_produto;

ALTER TABLE pcm.prioridade DROP CONSTRAINT grupo_empresa_prioridade;

ALTER TABLE pcm.criticidade DROP CONSTRAINT grupo_empresa_criticidade;

ALTER TABLE admin.perfil DROP CONSTRAINT grupo_empresa_perfil;

ALTER TABLE pcm.tipo_manutencao DROP CONSTRAINT grupo_empresa_tipo_manutencao;

ALTER TABLE pcm.tim_prioridade DROP CONSTRAINT tipo_manutencao_tim_prioridade;

ALTER TABLE pcm.tim_prioridade DROP CONSTRAINT prioridade_tim_prioridade;

ALTER TABLE pcm.plano_manutencao DROP CONSTRAINT grupo_empresa_plano_manutencao;

ALTER TABLE pcm.plano_manutencao DROP CONSTRAINT plano_manutencao_plano_manutencao;

ALTER TABLE pcm.plm_item DROP CONSTRAINT plano_manutencao_plm_item;

ALTER TABLE pcm.plm_item DROP CONSTRAINT tipo_manutencao_plm_item;

ALTER TABLE pcm.objeto_tag DROP CONSTRAINT nivel_objeto_tag;

ALTER TABLE pcm.objeto_tag DROP CONSTRAINT matriz_criticidade_objeto_tag;

ALTER TABLE pcm.objeto_tag DROP CONSTRAINT objeto_tag_objeto_tag;

ALTER TABLE pcm.objeto_tag DROP CONSTRAINT grupo_empresa_objeto_tag;

ALTER TABLE pcm.nivel DROP CONSTRAINT grupo_empresa_nivel;

ALTER TABLE pcm.matriz_criticidade DROP CONSTRAINT grupo_empresa_matriz_criticidade;

ALTER TABLE pcm.mac_item DROP CONSTRAINT matriz_criticidade_mac_item;

ALTER TABLE pcm.obt_criticidade DROP CONSTRAINT objeto_tag_obt_criticidade;

ALTER TABLE pcm.obt_criticidade DROP CONSTRAINT mac_item_obt_criticidade;

ALTER TABLE pcm.pmi_servico DROP CONSTRAINT plm_item_pmi_servico;

ALTER TABLE pcm.pmi_servico DROP CONSTRAINT trabalho_pmi_servico;

ALTER TABLE pcm.pmis_peca DROP CONSTRAINT pmi_servico_pmis_peca;

ALTER TABLE pcm.pmis_peca DROP CONSTRAINT produto_pmis_peca;

ALTER TABLE pcm.obt_peca DROP CONSTRAINT objeto_tag_obt_peca;

ALTER TABLE pcm.obt_peca DROP CONSTRAINT produto_obt_peca;

ALTER TABLE pcm.obt_servico DROP CONSTRAINT objeto_tag_obt_servico;

ALTER TABLE pcm.obt_servico DROP CONSTRAINT trabalho_obt_servico;

ALTER TABLE pcm.ots_peca DROP CONSTRAINT obt_servico_ots_peca;

ALTER TABLE pcm.ots_peca DROP CONSTRAINT produto_ots_peca;

ALTER TABLE pcm.obt_imagem DROP CONSTRAINT objeto_tag_obt_imagem;

ALTER TABLE pcm.obt_manual DROP CONSTRAINT objeto_tag_obt_manual;

ALTER TABLE pcm.trabalho DROP CONSTRAINT grupo_empresa_trabalho;

ALTER TABLE admin.login_token DROP CONSTRAINT usuario_login_token;

ALTER TABLE estoque.genero_produto DROP CONSTRAINT grupo_empresa_genero_produto;

ALTER TABLE estoque.grupo_produto DROP CONSTRAINT grupo_empresa_grupo_produto;

ALTER TABLE estoque.unidade_medida DROP CONSTRAINT grupo_empresa_unidade_medida;

ALTER TABLE estoque.ncm DROP CONSTRAINT ncm_ncm;

ALTER TABLE estoque.ncm DROP CONSTRAINT grupo_empresa_ncm;

ALTER TABLE estoque.iva DROP CONSTRAINT ncm_iva;

ALTER TABLE estoque.iva DROP CONSTRAINT unidade_federacao_iva;

ALTER TABLE estoque.iva DROP CONSTRAINT unidade_federacao_iva22;

ALTER TABLE pessoa.unidade_federacao DROP CONSTRAINT grupo_empresa_unidade_federacao;

ALTER TABLE pessoa.unidade_federacao DROP CONSTRAINT pais_unidade_federacao;

ALTER TABLE admin.licenca DROP CONSTRAINT grupo_empresa_licenca;

ALTER TABLE pessoa.pessoa DROP CONSTRAINT grupo_empresa_pessoa;

ALTER TABLE pessoa.pessoa_documento DROP CONSTRAINT pessoa_pessoa_documento;

ALTER TABLE pessoa.pessoa_documento DROP CONSTRAINT tipo_documento_pessoa_documento;

ALTER TABLE pessoa.tipo_endereco DROP CONSTRAINT grupo_empresa_tipo_endereco;

ALTER TABLE pessoa.pessoa_endereco DROP CONSTRAINT tipo_endereco_pessoa_endereco;

ALTER TABLE pessoa.pessoa_endereco DROP CONSTRAINT pessoa_pessoa_endereco;

ALTER TABLE pessoa.pessoa_endereco DROP CONSTRAINT cep_localidade_pessoa_endereco;

ALTER TABLE pessoa.cliente DROP CONSTRAINT pessoa_cliente;

ALTER TABLE pessoa.fornecedor DROP CONSTRAINT pessoa_fornecedor;

ALTER TABLE pessoa.recurso DROP CONSTRAINT pessoa_recurso;

ALTER TABLE pessoa.recurso DROP CONSTRAINT centro_custo_recurso;

ALTER TABLE pessoa.cargo DROP CONSTRAINT centro_custo_cargo;

ALTER TABLE pessoa.localidade DROP CONSTRAINT unidade_federacao_localidade;

ALTER TABLE pessoa.localidade DROP CONSTRAINT grupo_empresa_localidade;

ALTER TABLE pessoa.pais DROP CONSTRAINT grupo_empresa_pais;

ALTER TABLE pessoa.cep_localidade DROP CONSTRAINT localidade_localidade_cep;

ALTER TABLE pessoa.cep_localidade DROP CONSTRAINT grupo_empresa_cep_localidade;

ALTER TABLE admin.pem_usuario DROP CONSTRAINT usuario_pem_usuario;

ALTER TABLE admin.pem_usuario DROP CONSTRAINT permissao_modulo_pem_usuario;

ALTER TABLE admin.pem_perfil DROP CONSTRAINT permissao_modulo_pem_perfil;

ALTER TABLE admin.pem_perfil DROP CONSTRAINT perfil_pem_perfil;

ALTER TABLE admin.pep_usuario DROP CONSTRAINT usuario_pep_usuario;

ALTER TABLE admin.pep_usuario DROP CONSTRAINT permissao_programa_pep_usuario;

ALTER TABLE admin.pep_perfil DROP CONSTRAINT permissao_programa_pep_perfil;

ALTER TABLE admin.pep_perfil DROP CONSTRAINT perfil_pep_perfil;

ALTER TABLE pessoa_fisica DROP CONSTRAINT pessoa_pessoa_fisica;

ALTER TABLE pessoa_juridica DROP CONSTRAINT pessoa_pessoa_juridica;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.pessoa_endereco"                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.pessoa_endereco DROP CONSTRAINT PK_pessoa_endereco;

DROP TABLE pessoa.pessoa_endereco;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.iva"                                               */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.iva DROP CONSTRAINT PK_iva;

ALTER TABLE estoque.iva DROP CONSTRAINT TUC_iva_1;

DROP TABLE estoque.iva;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.pep_usuario"                                         */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.pep_usuario DROP CONSTRAINT PK_pep_usuario;

DROP TABLE admin.pep_usuario;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.pem_usuario"                                         */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.pem_usuario DROP CONSTRAINT PK_pem_usuario;

DROP TABLE admin.pem_usuario;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.cep_localidade"                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.cep_localidade DROP CONSTRAINT PK_localidade_cep;

ALTER TABLE pessoa.cep_localidade DROP CONSTRAINT TUC_cep_localidade_1;

DROP TABLE pessoa.cep_localidade;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.localidade"                                         */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.localidade DROP CONSTRAINT PK_localidade;

ALTER TABLE pessoa.localidade DROP CONSTRAINT TUC_localidade_1;

DROP TABLE pessoa.localidade;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.recurso"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.recurso DROP CONSTRAINT PK_recurso;

DROP TABLE pessoa.recurso;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.unidade_federacao"                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.unidade_federacao DROP CONSTRAINT PK_unidade_federacao;

ALTER TABLE pessoa.unidade_federacao DROP CONSTRAINT TUC_unidade_federacao_1;

DROP TABLE pessoa.unidade_federacao;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.login_token"                                         */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.login_token DROP CONSTRAINT PK_login_token;

DROP TABLE admin.login_token;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.obt_manual"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.obt_manual DROP CONSTRAINT PK_obt_manual;

DROP TABLE pcm.obt_manual;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.obt_imagem"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.obt_imagem DROP CONSTRAINT PK_obt_imagem;

DROP TABLE pcm.obt_imagem;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.ots_peca"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.ots_peca DROP CONSTRAINT PK_ots_peca;

DROP TABLE pcm.ots_peca;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.obt_servico"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.obt_servico DROP CONSTRAINT PK_obt_servico;

DROP TABLE pcm.obt_servico;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.obt_peca"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.obt_peca DROP CONSTRAINT PK_obt_peca;

DROP TABLE pcm.obt_peca;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.pmis_peca"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.pmis_peca DROP CONSTRAINT PK_pmis_peca;

DROP TABLE pcm.pmis_peca;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.pmi_servico"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.pmi_servico DROP CONSTRAINT PK_pmi_servico;

DROP TABLE pcm.pmi_servico;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.obt_criticidade"                                       */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.obt_criticidade DROP CONSTRAINT PK_obt_criticidade;

DROP TABLE pcm.obt_criticidade;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.objeto_tag"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.objeto_tag DROP CONSTRAINT PK_objeto_tag;

DROP TABLE pcm.objeto_tag;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.conversao_produto"                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.conversao_produto DROP CONSTRAINT PK_conversao_produto;

DROP TABLE estoque.conversao_produto;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.produto"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.produto DROP CONSTRAINT PK_produto;

DROP TABLE estoque.produto;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.usuario"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.usuario DROP CONSTRAINT PK_usuario;

ALTER TABLE admin.usuario DROP CONSTRAINT TUC_usuario_1;

ALTER TABLE admin.usuario DROP CONSTRAINT TUC_usuario_2;

DROP TABLE admin.usuario;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa_juridica"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa_juridica DROP CONSTRAINT PK_pessoa_juridica;

DROP TABLE pessoa_juridica;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa_fisica"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa_fisica DROP CONSTRAINT PK_pessoa_fisica;

DROP TABLE pessoa_fisica;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.pep_perfil"                                          */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.pep_perfil DROP CONSTRAINT PK_pep_perfil;

DROP TABLE admin.pep_perfil;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.pem_perfil"                                          */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.pem_perfil DROP CONSTRAINT PK_pem_perfil;

DROP TABLE admin.pem_perfil;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.pais"                                               */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.pais DROP CONSTRAINT PK_pais;

ALTER TABLE pessoa.pais DROP CONSTRAINT TUC_pais_1;

DROP TABLE pessoa.pais;

/* ---------------------------------------------------------------------- */
/* Drop table "timesheet.tarefa"                                          */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE timesheet.tarefa DROP CONSTRAINT PK_tarefa;

DROP TABLE timesheet.tarefa;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.cargo"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.cargo DROP CONSTRAINT PK_cargo;

DROP TABLE pessoa.cargo;

/* ---------------------------------------------------------------------- */
/* Drop table "contabilidade.centro_custo"                                */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE contabilidade.centro_custo DROP CONSTRAINT PK_centro_custo;

DROP TABLE contabilidade.centro_custo;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.fornecedor"                                         */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.fornecedor DROP CONSTRAINT PK_fornecedor;

DROP TABLE pessoa.fornecedor;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.cliente"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.cliente DROP CONSTRAINT PK_cliente;

DROP TABLE pessoa.cliente;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.tipo_endereco"                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.tipo_endereco DROP CONSTRAINT PK_tipo_endereco;

DROP TABLE pessoa.tipo_endereco;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.pessoa_documento"                                   */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.pessoa_documento DROP CONSTRAINT PK_pessoa_documento;

DROP TABLE pessoa.pessoa_documento;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.pessoa"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.pessoa DROP CONSTRAINT PK_pessoa;

ALTER TABLE pessoa.pessoa DROP CONSTRAINT TUC_pessoa_1;

DROP TABLE pessoa.pessoa;

/* ---------------------------------------------------------------------- */
/* Drop table "pessoa.tipo_documento"                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pessoa.tipo_documento DROP CONSTRAINT PK_tipo_documento;

DROP TABLE pessoa.tipo_documento;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.licenca"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.licenca DROP CONSTRAINT ;

DROP TABLE admin.licenca;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.ncm"                                               */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.ncm DROP CONSTRAINT PK_ncm;

DROP TABLE estoque.ncm;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.unidade_medida"                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.unidade_medida DROP CONSTRAINT PK_unidade_medida;

DROP TABLE estoque.unidade_medida;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.grupo_produto"                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.grupo_produto DROP CONSTRAINT PK_grupo_produto;

DROP TABLE estoque.grupo_produto;

/* ---------------------------------------------------------------------- */
/* Drop table "estoque.genero_produto"                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE estoque.genero_produto DROP CONSTRAINT PK_genero_produto;

DROP TABLE estoque.genero_produto;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.trabalho"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.trabalho DROP CONSTRAINT PK_trabalho;

DROP TABLE pcm.trabalho;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.pmi_peca"                                              */
/* ---------------------------------------------------------------------- */

DROP TABLE pcm.pmi_peca;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.mac_item"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.mac_item DROP CONSTRAINT PK_mac_item;

DROP TABLE pcm.mac_item;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.matriz_criticidade"                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.matriz_criticidade DROP CONSTRAINT PK_matriz_criticidade;

DROP TABLE pcm.matriz_criticidade;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.nivel"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.nivel DROP CONSTRAINT PK_nivel;

DROP TABLE pcm.nivel;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.plm_item"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.plm_item DROP CONSTRAINT PK_plm_item;

DROP TABLE pcm.plm_item;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.plano_manutencao"                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.plano_manutencao DROP CONSTRAINT PK_plano_manutencao;

DROP TABLE pcm.plano_manutencao;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.tim_prioridade"                                        */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.tim_prioridade DROP CONSTRAINT PK_tim_prioridade;

DROP TABLE pcm.tim_prioridade;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.tipo_manutencao"                                       */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.tipo_manutencao DROP CONSTRAINT PK_tipo_manutencao;

DROP TABLE pcm.tipo_manutencao;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.perfil"                                              */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.perfil DROP CONSTRAINT PK_perfil;

DROP TABLE admin.perfil;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.criticidade"                                           */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.criticidade DROP CONSTRAINT PK_criticidade;

DROP TABLE pcm.criticidade;

/* ---------------------------------------------------------------------- */
/* Drop table "pcm.prioridade"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE pcm.prioridade DROP CONSTRAINT PK_prioridade;

DROP TABLE pcm.prioridade;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.permissao_modulo"                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.permissao_modulo DROP CONSTRAINT PK_permissao_modulo;

DROP TABLE admin.permissao_modulo;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.permissao_programa"                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.permissao_programa DROP CONSTRAINT PK_permissao_programa;

DROP TABLE admin.permissao_programa;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.programa_modulo"                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.programa_modulo DROP CONSTRAINT PK_programa_modulo;

DROP TABLE admin.programa_modulo;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.programa"                                            */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.programa DROP CONSTRAINT PK_programa;

DROP TABLE admin.programa;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.gre_modulo"                                          */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.gre_modulo DROP CONSTRAINT PK_gre_modulo;

DROP TABLE admin.gre_modulo;

/* ---------------------------------------------------------------------- */
/* Drop table "admin.grupo_empresa"                                       */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE admin.grupo_empresa DROP CONSTRAINT PK_grupo_empresa;

DROP TABLE admin.grupo_empresa;

/* ---------------------------------------------------------------------- */
/* Drop domains                                                           */
/* ---------------------------------------------------------------------- */

DROP DOMAIN ID;

DROP DOMAIN SIM_NAO;

DROP DOMAIN TIPO_PERMISSAO;

DROP DOMAIN MODULO;

DROP DOMAIN QUANTIDADE;

DROP DOMAIN MONETARIO;

DROP DOMAIN SITUACAO;

DROP DOMAIN TIPO_PESSOA;

/* ---------------------------------------------------------------------- */
/* Drop sequences                                                         */
/* ---------------------------------------------------------------------- */

DROP SEQUENCE seq_cep_localidade;

DROP SEQUENCE seq_cliente;

DROP SEQUENCE seq_consulta;

DROP SEQUENCE seq_criticidade;

DROP SEQUENCE seq_fornecedor;

DROP SEQUENCE seq_genero_produto;

DROP SEQUENCE seq_grupo_empresa;

DROP SEQUENCE seq_grupo_produto;

DROP SEQUENCE seq_licenca;

DROP SEQUENCE seq_localidade;

DROP SEQUENCE seq_login_token;

DROP SEQUENCE seq_pais;

DROP SEQUENCE seq_perfil;

DROP SEQUENCE seq_pessoa;

DROP SEQUENCE seq_pessoa_endereco;

DROP SEQUENCE seq_prioridade;

DROP SEQUENCE seq_programa;

DROP SEQUENCE seq_tipo_documento;

DROP SEQUENCE seq_tipo_endereco;

DROP SEQUENCE seq_tipomanutencao;

DROP SEQUENCE seq_unidade_federacao;

DROP SEQUENCE seq_usuario;

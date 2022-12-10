set foreign_key_checks = 0;

delete from tbperfil;
delete from tbperfil_permissao;
delete from tbpermissao;
delete from tbpessoa;
delete from tbrede_social;
delete from tbendereco;
delete from tbcontato;
delete from tbusuario;
delete from tbsistema;
delete from tbusuario_perfil;
delete from tbpessoa_sistema;
delete from tbpermissao;

set foreign_key_checks = 1;

alter table tbperfil auto_increment = 1;
alter table tbpermissao auto_increment = 1;
alter table tbpessoa auto_increment=1;
alter table tbrede_social auto_increment=1;
alter table tbendereco auto_increment=1;
alter table tbcontato auto_increment=1;
alter table tbusuario auto_increment=1;
alter table tbsistema auto_increment=1;
alter table tbpermissao auto_increment=1;

insert into tbrede_social (id, whatsapp, instagram, email) values (1, '5596984072732', '@carloseduardoselhorst', 'cadu.selhorst@gmail.com');
insert into tbrede_social (id, email) values (2, 'contato@aliancamedicor.com.br');

insert into tbpessoa (id, cod_integracao, tipo_pessoa, nome, tratamento_fantasia, cpf_cnpj, rg_ie, eleitor_im, genero,
data_nascimento, cnh_suframa, rede_social_id) values (1, '2cc1abb0-b5f3-11ec-b909-0242ac120002 ', 'CPF', 'CARLOS EDUARDO SELHORST', 'CARLOS', '03440132943', '681396', '076745030612', 'M',
'1982-03-28 03:00:00', '02013150127', 1);

insert into tbpessoa (id, cod_integracao, tipo_pessoa, nome, tratamento_fantasia, cpf_cnpj, rg_ie, eleitor_im, genero,
data_nascimento, cnh_suframa, rede_social_id) values (2, 'c7defc10-b5f8-11ec-b909-0242ac120002 ', 'CNPJ', 'N. C. DO REGO EIRELI', 'ALIANÇA MEDICOR', '84409085000156', '6546546', '656545', 'M',
'1982-03-28 03:00:00', '65654654', 2);


insert into tbendereco (pessoa_id, cep, tipo_logradouro, logradouro, numero, complemento, bairro, cidade, estado, uf)
values (1, '68902020', 'AV', 'LEOPOLDO MACHADO', '3270', 'ALTOS DA COURO REVESTIMENTOS', 'BEIROL', 'MACAPÁ', 'AMAPÁ', 'AP');

insert into tbcontato (pessoa_id, ddd, numero) values (1, '96', '984072732');

insert into tbusuario (id, senha, pessoa_id, expirado, inativo) values (1, '$2a$12$o944kMfhDooLWWHvIqdDceLEMMiCv9m9pQeZ0FN8WWbVKa45jA.oe', 1, false, false);
update tbpessoa set usuario_id = 1 where id=1;

insert into tbsistema (id, nome, descricao, versao) values (1, 'ALIANÇA MEDICOR API', 'API PRIVADA, PROTEGIDA, CENTRALIZADORA DE DADOS','1.0.0');
insert into tbsistema (id, nome, descricao, versao) values (2, 'PRONTUÁRIO ELETRÔNICO', 'PRONTUARIO DE SAÚDE ELETRÔNICO','1.0.0');
insert into tbpessoa_sistema values (2, 1), (2, 2), (1, 2);

insert into tbperfil (nome, sistema_id) values ('ADMINISTRADOR', 1);

insert into tbusuario_perfil values (1, 1);

insert into tbpermissao (id, nome, descricao) values (1,  'PERMITE_GERENCIAR_PESSOA', 'Permite gerenciar o cadastro de pessoa');
insert into tbpermissao (id, nome, descricao) values (2,  'PERMITE_CONSULTAR_PESSOA', 'Permite consultar o cadastro de pessoa');
insert into tbpermissao (id, nome, descricao) values (3,  'PERMITE_GERENCIAR_SISTEMA', 'Permite gerenciar o cadastro de sistema');
insert into tbpermissao (id, nome, descricao) values (4,  'PERMITE_CONSULTAR_SISTEMA', 'Permite consultar o cadastro de sistema');
insert into tbpermissao (id, nome, descricao) values (5,  'PERMITE_ASSOCIAR_PESSOA_SISTEMA', 'Permite associar/desassociar pessoa a sistema');
insert into tbpermissao (id, nome, descricao) values (6,  'PERMITE_CONSULTAR_CBO_OCUPACOES', 'Permite associar/desassociar pessoa a sistema');
insert into tbpermissao (id, nome, descricao) values (7,  'PERMITE_GERENCIAR_USUARIOS', 'Permite gerenciar os usuários associados às pessoas');
insert into tbpermissao (id, nome, descricao) values (8,  'PERMITE_CONSULTAR_USUARIOS', 'Permite realizar consultas aos registros de usuários');
insert into tbpermissao (id, nome, descricao) values (9,  'PERMITE_GERENCIAR_PERFIS', 'Permite gerenciar os perfis de acesso');
insert into tbpermissao (id, nome, descricao) values (10, 'PERMITE_CONSULTAR_PERFIS', 'Permite realizar consultas aos registros de perfis');

insert into tbperfil_permissao values (1, 1),  (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10);
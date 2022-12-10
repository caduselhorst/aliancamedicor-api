create table tbpessoa_log (
	id bigint not null auto_increment,
	pessoa_id bigint not null,
    tipo_pessoa varchar(4) not null,
    nome varchar(145) not null,
    nome_social varchar(145) not null,
    tratamento_fantasia varchar(145) not null,
    cpf_cnpj varchar(20) not null,
    rg_ie varchar(20) not null,
    eleitor_im varchar(20),
    genero varchar(1),
    data_nascimento date,
    cnh_suframa varchar(30),
    cod_integracao varchar(36) not null,
    primary key(id)
) engine=InnoDB default charset=utf8mb4;
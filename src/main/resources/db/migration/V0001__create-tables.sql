create table tbpessoa (
	id bigint not null auto_increment,
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
    rede_social_id bigint not null,
    primary key(id)
) engine=InnoDB default charset=utf8mb4;

create table tbendereco
(
	id bigint not null auto_increment,
	pessoa_id bigint not null,
	cep varchar(10),
	tipo_logradouro varchar(5),
	logradouro varchar(255),
	numero varchar(10),
	complemento varchar(255),
	bairro varchar(100),
	cidade varchar(100),
	estado varchar(100),
	uf varchar(5),
	primary key (id),
    constraint fk_endereco_pessoa foreign key (pessoa_id) references tbpessoa (id)
) engine=InnoDB default charset=utf8mb4;

create table tbcontato
(
	id bigint not null auto_increment,
	pessoa_id bigint not null,
	ddd varchar(5),
	numero varchar(10),
	primary key (id),
	constraint fk_contato_pessoa foreign key (pessoa_id) references tbpessoa (id)
) engine=InnoDB default charset=utf8mb4;

create table tbrede_social
(
	id bigint not null auto_increment,
	whatsapp varchar(45),
	facebook varchar(45),
	instagram varchar(45),
	twitter varchar(45),
	telegram varchar(45),
	skype varchar(45),
	email varchar(45),
	primary key (id)
) engine=InnoDB default charset=utf8mb4;

create unique index idx_pessoa_documento on tbpessoa (cpf_cnpj);

alter table tbpessoa add constraint fk_pessoa_redesocial foreign key (rede_social_id) references tbrede_social (id);

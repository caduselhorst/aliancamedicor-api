create table tbusuario (
	id bigint not null auto_increment,
	senha varchar(150),
	pessoa_id bigint not null,
	expirado boolean not null,
	inativo boolean not null,
	primary key (id),
	foreign key (pessoa_id) references tbpessoa (id)
	
) engine=InnoDB default charset=utf8mb4;

create table tbsistema
(
	id bigint not null auto_increment,
	nome varchar(50) not null,
	descricao varchar(255) not null,
	versao varchar(10) not null,
	primary key (id)
) engine=InnoDB default charset=utf8mb4;

create table tbperfil (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	sistema_id bigint not null,
	primary key (id),
	foreign key (sistema_id) references tbsistema (id)
) engine=InnoDB default charset=utf8mb4;

create table tbpermissao (
	id bigint not null auto_increment,
	descricao varchar(60) not null,
	nome varchar(100) not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8mb4;

create table tbpessoa_sistema
(
	pessoa_id bigint not null,
	sistema_id bigint not null,
	primary key (pessoa_id, sistema_id),
	foreign key (pessoa_id) references tbpessoa (id),
	foreign key (sistema_id) references tbsistema (id)
);

create table tbperfil_permissao (
	perfil_id bigint not null,
	permissao_id bigint not null,
	
	primary key (perfil_id, permissao_id)
) engine=InnoDB default charset=utf8mb4;

create table tbusuario_perfil (
	perfil_id bigint not null,
	usuario_id bigint not null,
	primary key (perfil_id, usuario_id),
	foreign key (perfil_id) references tbperfil (id),
	foreign key (usuario_id) references tbusuario (id)
) engine=InnoDB default charset=utf8mb4;

alter table tbperfil_permissao add constraint fk_perfil_permissao_permissao
foreign key (permissao_id) references tbpermissao (id);

alter table tbperfil_permissao add constraint fk_perfil_permissao_grupo
foreign key (perfil_id) references tbperfil (id);

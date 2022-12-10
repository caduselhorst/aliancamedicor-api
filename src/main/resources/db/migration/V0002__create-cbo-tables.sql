create table tbcbo_grande_grupo
(
	codigo varchar(10) not null,
	titulo varchar(255) not null,
	
	primary key (codigo)
) engine=InnoDB default charset=utf8mb4;

create table tbcbo_subgrupo_principal
(
	codigo varchar(10) not null,
	titulo varchar(255) not null,
	
	primary key (codigo)
) engine=InnoDB default charset=utf8mb4;

create table tbcbo_subgrupo
(
	codigo varchar(10) not null,
	titulo varchar(255) not null,
	
	primary key (codigo)
) engine=InnoDB default charset=utf8mb4;

create table tbcbo_familia
(
	codigo varchar(10) not null,
	titulo varchar(255) not null,
	
	primary key (codigo)
) engine=InnoDB default charset=utf8mb4;

create table tbcbo_ocupacao
(
	codigo varchar(10) not null,
	titulo varchar(255) not null,
	
	primary key (codigo)
) engine=InnoDB default charset=utf8mb4;

create table tbcbo_perfil_ocupacional
(
	id bigint not null auto_increment,
	cod_grande_grupo varchar(10) not null,
	cod_subgrupo_principal varchar(10) not null,
	cod_subgrupo varchar(10) not null,
	cod_familia varchar(10) not null,
	cod_ocupacao varchar(10) not null,
	sgl_grande_area varchar(5) not null,
	nome_grande_area varchar(150) not null,
	cod_atividade bigint not null,
	nome_atividade varchar(255),
	
	primary key (id)
) engine=InnoDB default charset=utf8mb4;

alter table tbcbo_perfil_ocupacional add constraint 
	fk_perfilocup_gdegrupo foreign key (cod_grande_grupo) references tbcbo_grande_grupo (codigo);
alter table tbcbo_perfil_ocupacional add constraint 
	fk_perfilocup_sgrupoprinc foreign key (cod_subgrupo_principal) references tbcbo_subgrupo_principal (codigo);
alter table tbcbo_perfil_ocupacional add constraint 
	fk_perfilocup_subgrupo foreign key (cod_subgrupo) references tbcbo_subgrupo (codigo);
alter table tbcbo_perfil_ocupacional add constraint 
	fk_perfilocup_familia foreign key (cod_familia) references tbcbo_familia (codigo);
alter table tbcbo_perfil_ocupacional add constraint 
	fk_perfilocup_ocup foreign key (cod_ocupacao) references tbcbo_ocupacao (codigo);
create table tbcid_capitulo (
	id bigint not null,
	capitulo varchar(5) not null,
	descricao varchar(255) not null,
	primary key (id)
) engine=InnoDB default charset=utf8mb4;

create table tbcid_classificacao (
	id bigint not null,
	capitulo_id bigint not null,
	descricao varchar(500) not null,
	classificacao varchar(10),
	classificacao_pai bigint,
	primary key (id),
	constraint fk_classificacao_capitulo foreign key (capitulo_id) references tbcid_capitulo (id),
	constraint fk_classificacao_pai foreign key (classificacao_pai) references tbcid_classificacao (id)
) engine=InnoDB default charset=utf8mb4;
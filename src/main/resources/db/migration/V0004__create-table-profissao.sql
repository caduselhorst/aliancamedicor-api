create table tbprofissao
(
	id bigint not null auto_increment,
	pessoa_id bigint not null,
	ocupacao_codigo varchar(10) not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8mb4;

alter table tbprofissao add constraint fk_profissao_cbo_ocupacao foreign key (ocupacao_codigo) references tbcbo_ocupacao(codigo);
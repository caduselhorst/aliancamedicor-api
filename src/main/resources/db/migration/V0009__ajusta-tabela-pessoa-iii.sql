alter table tbpessoa add usuario_id bigint;
alter table tbpessoa add constraint fk_pessoa_usuario foreign key (usuario_id) references tbusuario (id);
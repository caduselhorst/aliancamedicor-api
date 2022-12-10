alter table tbpessoa add cod_integracao varchar(36) not null after id;
alter table tbpessoa add constraint uk_pedido_codigo unique (cod_integracao);
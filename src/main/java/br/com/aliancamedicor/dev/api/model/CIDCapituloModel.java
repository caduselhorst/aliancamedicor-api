package br.com.aliancamedicor.dev.api.model;

import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CIDCapituloModel {
	
	@EqualsAndHashCode.Include
	private Long id;
	private String capitulo;
	private String descricao;
	
	private Set<CIDClassificacaoModel> classificacoes;

}

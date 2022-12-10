package br.com.aliancamedicor.dev.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class CIDClassificacaoModel {
	
	private Long id;
	
	private String descricao;
	private String classificacao;
	

}

package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representa uma profissao")
public class ProfissaoModel {

	@ApiModelProperty(value = "Codigo identificador da profissão")
	private Long id;
	@ApiModelProperty(value = "Referência da profissão no CBO")
	private CBOOcupacaoModel ocupacao;
	
}

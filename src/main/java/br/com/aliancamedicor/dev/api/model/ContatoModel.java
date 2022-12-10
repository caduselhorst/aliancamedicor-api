package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Representa um contato de pessoa")
public class ContatoModel {

	@ApiModelProperty(value = "Código identificador do contato")
	private Long id;
	@ApiModelProperty(value = "DDD", example = "96")
	private String ddd;
	@ApiModelProperty(value = "Número de contato", example = "999451234")
	private String numero;

}

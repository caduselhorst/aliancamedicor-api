package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de representação de uma ocupação, padronizada pelo Código Brasileiro de Ocupações (CBO).
 * 
 * @author carlos
 *
 */
@Getter
@Setter
@ApiModel(description = "Representa uma ocupação do Código Brasileito de Ocupações")
public class CBOOcupacaoModel {
	
	@ApiModelProperty(value = "Código da ocupação", example = "252510")
	private String codigo;
	@ApiModelProperty(value = "Título da ocupação", example = "ANALISTA DE CÂMBIO")
	private String titulo;

}

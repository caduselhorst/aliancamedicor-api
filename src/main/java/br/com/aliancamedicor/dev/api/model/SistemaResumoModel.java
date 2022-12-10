package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SistemaResumoModel {

	@ApiModelProperty(value = "Identificador do perfil", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome do perfil", example = "ADMINISTRADOR")
	private String nome;
	
}

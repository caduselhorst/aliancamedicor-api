package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Modelo de represetação de um ussário")
@Getter
@Setter
public class UsuarioModel {
	
	@ApiModelProperty(value = "Identificador do usuário", example = "1")
	private Long id;

}

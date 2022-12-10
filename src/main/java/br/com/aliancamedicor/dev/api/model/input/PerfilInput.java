package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo de representação de um input de Perfil")
public class PerfilInput {

	@ApiModelProperty(value = "Nome do perfil", example = "ADMINISTRADOR")
	@NotBlank
	private String nome;
	
	@Valid
	private SistemaIdInput sistema;
	
	
}

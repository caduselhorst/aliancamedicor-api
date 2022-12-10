package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Representa um input de alteração de senha")
@Getter
@Setter
public class SenhaInput {
	
	@NotBlank
	@ApiModelProperty(value = "Senha atual do usuário")
	private String senhaAtual;
	
	@NotBlank
	@ApiModelProperty(value = "Nova senha")
	private String novaSenha;

}

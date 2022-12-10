package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representação de um input de pessoa pelo ID")
public class PessoaIdInput {

	@NotNull
	@ApiModelProperty(value = "Id da pessoa", example = "1")
	private Long pessoaId;
	
}

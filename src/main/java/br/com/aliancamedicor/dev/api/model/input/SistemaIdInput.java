package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo de representação de um input de identificação de sistema")
public class SistemaIdInput {
	
	@NotNull
	@ApiModelProperty(value = "Identificador do sistema", example = "1")
	private Long id;

}

package br.com.aliancamedicor.dev.api.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo de representação de input de ID de permissão")
public class PermissaoIdInput {

	@ApiModelProperty(value = "Identificador da permissão", example = "1")
	private Long pemissaoId;
	
}

package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa um input de profissão")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfissaoInput {
	
	@ApiModelProperty(value = "Código do CBO", example = "314515 (ver end-point de consulta aos códigos de ocupação)")
	@NotBlank
	private String codOcupacao;

}

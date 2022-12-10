package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa um modelo de input de contato")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContatoInput {
	
	@ApiModelProperty(value="DDD do telefone de contato", example = "96")
	@NotBlank
	private String ddd;
	
	@ApiModelProperty(value="Número do telefone de contato", example = "984787878")
	@NotBlank
	private String numero;

}

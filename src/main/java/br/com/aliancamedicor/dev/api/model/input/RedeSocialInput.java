package br.com.aliancamedicor.dev.api.model.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Representa um input de endereços de rede social")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RedeSocialInput {

	@ApiModelProperty(value = "Numero do Whatsapp", example = "55969845789633")
	private String whatsapp;
	
	@ApiModelProperty(value = "Nome no Facebook", example = "João da Silva")
	private String facebook;
	
	@ApiModelProperty(value = "Identificação no Instagram", example = "@joaosilva")
	private String instagram;
	
	@ApiModelProperty(value = "Endereço no Twitter", example = "@joaosilva")
	private String twitter;
	
	@ApiModelProperty(value = "Número no Telegram", example = "55969845789633")
	private String telegram;
	
	@ApiModelProperty(value = "Identificação no Skype", example = "joaosilva")
	private String skype;
	
	@ApiModelProperty(value = "E-mail", example = "joao.silva@emailpessoa.com")
	private String email;
	
}

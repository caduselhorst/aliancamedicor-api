package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RedeSocialModel {
	
	
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

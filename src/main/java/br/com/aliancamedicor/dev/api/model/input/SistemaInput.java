package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Modelo de representação de um sistema")
public class SistemaInput {
	
	@ApiModelProperty(value = "Nome do sistema", example = "ALIANÇA MEDICOR API")
	@NotBlank
	private String nome;
	
	@ApiModelProperty(value = "Descrição do sistema", example = "API PRIVADA CENTRALIZADORA DE DADOS")
	@NotBlank
	private String descricao;
	
	@ApiModelProperty(value = "Versão do sistema", example = "1.0.0")
	@NotBlank
	private String versao;
		
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}

}

package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representa uma permissão")
public class PermissaoModel {
	
	@ApiModelProperty(value = "Identificador da permissão", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome da permissão", example = "PERMITE_GERENCIAR_USUARIOS")
	private String nome;
	
	@ApiModelProperty(value = "Descrição da permissão", example = "Permite gerenciar os usuários associados às pessoas")
	private String descricao;

}

package br.com.aliancamedicor.dev.api.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representa um perfil")
public  class PerfilModel {
	
	@ApiModelProperty(value = "Identificador do perfil", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome do perfil", example = "ADMINISTRADOR")
	private String nome;
	
	@ApiModelProperty(value = "Sistema ao qual o perfil está associado")
	private SistemaModel sistema;
	
	@ApiModelProperty(value = "Pemissões associadas ao perfil")
	private List<PermissaoModel> permissoes;

}

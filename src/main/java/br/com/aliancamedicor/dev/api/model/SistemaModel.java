package br.com.aliancamedicor.dev.api.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representação completa de um sistema")
public class SistemaModel extends SistemaResumoModel {
	
	@ApiModelProperty(value = "Descrição do sistema", example = "API privada centralizadora de dados")
	private String descricao;
	
	@ApiModelProperty(value = "Versão corrente", example = "1.0.0")
	private String versao;
	
	@ApiModelProperty("Pessoa responsável pelo sistema")
	private List<PessoaResumoModel> pessoas;

}

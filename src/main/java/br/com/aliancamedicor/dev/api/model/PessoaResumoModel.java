package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representa uma pessoa, com atributos resumidos")
public class PessoaResumoModel {
	
	@ApiModelProperty(value = "Identificador", example = "1")
	private Long id;
	@ApiModelProperty(value = "Nome da pessoa, caso CPF ou Razão social caso CNPJ", example = "JOÃO DA SILVA")
	private String nome;
	@ApiModelProperty(value = "Nome social", example = "JOÃO DA SILVA")
	private String nomeSocial;
	@ApiModelProperty(value = "Tratamento da pessoa, caso CPF, ou nome fantasia, caso CNPJ", example = "SR.")
	private String tratamentoFantasia;
	@ApiModelProperty(value = "Número CPF ou CNPJ", example = "0344555101")
	private String cpfCnpj;
	@ApiModelProperty(value = "RG, caso CPF, ou inscrição estadual, caso CNPJ", example = "647845/AP")
	private String rgIe;

}

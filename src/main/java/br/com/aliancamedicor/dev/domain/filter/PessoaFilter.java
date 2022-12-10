package br.com.aliancamedicor.dev.domain.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("FiltroPessoa")
public class PessoaFilter {
	
	@ApiModelProperty(value = "CPF ou CNPJ da pessoa (valor exato)", example = "05448415678")
	private String cpfCnpj;
	
	@ApiModelProperty(value = "Nome ou razão social da pessoa (ao menos 3 caracteres)", example = "João da Silva")
	private String nomeRazao;
	

}

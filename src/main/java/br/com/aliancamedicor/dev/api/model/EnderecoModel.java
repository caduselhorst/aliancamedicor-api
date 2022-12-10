package br.com.aliancamedicor.dev.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Representa um endereço")
public class EnderecoModel {
	
	@ApiModelProperty(value = "Código identificador do endereco")
	private Long id;
	
	@ApiModelProperty(value = "CEP do endereço", example = "68900000")
	private String cep;
	
	@ApiModelProperty(value = "Tipo do logradouro", example = "AV")
	private String tipoLogradouro;
	
	@ApiModelProperty(value = "Logradouro", example = "LEOPOLDO MACHADO")
	private String logradouro;
	
	@ApiModelProperty(value = "Número", example = "4567")
	private String numero;
	
	@ApiModelProperty(value = "Complemento do endereço", example = "CASA DOS FUNDOS")
	private String complemento;
	
	@ApiModelProperty(value = "Bairro", example = "BEIROL")
	private String bairro;
	
	@ApiModelProperty(value = "Cidade", example = "MACAPÁ")
	private String cidade;
	
	@ApiModelProperty(value = "Estado", example = "AMAPÁ")
	private String estado;
	
	@ApiModelProperty(value = "Estado", example = "AP")
	private String uf;

}

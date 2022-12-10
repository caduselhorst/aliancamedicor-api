package br.com.aliancamedicor.dev.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@ApiModel(description = "Representa um input de endereço")
@Getter
@ToString
public class EnderecoInput {

	@ApiModelProperty(value="CEP do endereço", example = "68902020")
	@NotBlank
	private String cep;
	
	@ApiModelProperty(value = "Tipo do logradouro", example = "AV")
	@NotBlank
	private String tipoLogradouro;
	
	@ApiModelProperty(value = "Nome do logradouro", example = "Leopoldo Machado")
	@NotBlank
	private String logradouro;
	
	@ApiModelProperty(value = "Numero do endereço", example = "4545")
	@NotBlank
	private String numero;
	
	@ApiModelProperty(value = "Complemento do endereço", example = "Casa dos fundos")
	private String complemento;
	
	@ApiModelProperty(value = "Bairro do endereço", example = "Beirol")
	@NotBlank
	private String bairro;
	
	@ApiModelProperty(value = "Cidade", example = "Macapá")
	@NotBlank
	private String cidade;
	
	@ApiModelProperty(value = "Estado", example = "Amapá")
	@NotBlank
	private String estado;
	
	@ApiModelProperty(value = "Sigla da unidade da federação", example = "AP")
	@NotBlank
	private String uf;
	
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro.toUpperCase();
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.toUpperCase();
	}

	public void setCep(String cep) {
		this.cep = cep.toUpperCase();
	}

	public void setNumero(String numero) {
		this.numero = numero.toUpperCase();
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento.toUpperCase();
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}

	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}

	public void setUf(String uf) {
		this.uf = uf.toUpperCase();
	}
	
	
}

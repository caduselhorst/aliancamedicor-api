package br.com.aliancamedicor.dev.api.model.input;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.aliancamedicor.dev.core.validation.Lista;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Representa um input de uma pessoa")
@Getter
@Setter
@ToString
public class PessoaInput {
	
	@ApiModelProperty(value = "Tipo de pessoa", example = "CPF", allowableValues = "CPF, CNPJ", required = true)
	@NotBlank
	@Lista(allowed = {"CNPJ", "CPF"})
	private String tipoPessoa;
	
	@ApiModelProperty(value = "Nome da pessoa para CPF ou razão social para CNPJ", example = "João da Silva")
	@NotBlank
	private String nome;
	
	@ApiModelProperty(value = "Nome de identificação social", example = "João da Silva")
	private String nomeSocial;
	
	@ApiModelProperty(value = "Tipo de tratamento para CPF ou nome fantasia para CNPJ", example = "Sr")
	@NotBlank
	private String tratamentoFantasia;
	
	@ApiModelProperty(value = "Número do registro", example = "55222634078")
	@NotBlank
	private String cpfCnpj;
	
	@ApiModelProperty(value = "RG para CPF ou inscrição estadual para CNPJ", example = "681596/AP")
	@NotBlank
	private String rgIe;
	
	@ApiModelProperty(value = "Título de eleitor para CPF ou inscrição municipal para CNPJ", example = "454654454654")
	@NotBlank
	private String eleitorIm;
	
	@ApiModelProperty(value = "Gênero", example = "M", required = true, allowableValues = "F, M")
	@NotBlank
	@Lista(allowed = {"M", "F"})
	private String genero;
	
	@ApiModelProperty(value = "Data de nascimento (em UTC)", example = "1978-03-15T00:00:00Z")
	@NotNull
	private OffsetDateTime dataNascimento;
	
	@ApiModelProperty(value = "Registro CNH para CPF ou registro SUFRAMA para CNPJ", example = "45465412321")
	@NotBlank
	private String cnhSuframa;
	
	@ApiModelProperty(value = "Lista de contatos")
	@Valid
	@NotNull
	private List<ContatoInput> contatos;
	
	@ApiModelProperty(value = "Endereço da pessoa")
	@Valid
	@NotNull
	private EnderecoInput endereco;
	
	@ApiModelProperty(value = "Profissão da pessoa")
	@Valid
	@NotNull
	private ProfissaoInput profissao;
	
	@ApiModelProperty(value = "Redes sociais da pessoa")
	@Valid
	@NotNull
	private RedeSocialInput redeSocial;
		
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj.replace(".", "").replace("/", "").replace("-", "");
	}
	
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public void setNomeSocial(String nomeSocial) {
		if(nomeSocial != null) {
			this.nomeSocial = nomeSocial.toUpperCase();
		}
	}
	
	public void setTratamentoFantasia(String tratamentoFantasia) {
		this.tratamentoFantasia = tratamentoFantasia.toUpperCase();
	}
}

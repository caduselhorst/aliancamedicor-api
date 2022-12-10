package br.com.aliancamedicor.dev.api.model;

import java.time.OffsetDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Representa uma pessoa")
public class PessoaModel extends PessoaResumoModel {

	@ApiModelProperty(value = "Tipo de pessoa", allowableValues = "CPF, CNPJ", example = "CPF")
	private String tipoPessoa;
	@ApiModelProperty(value = "Nro. título de eleitor, para CPF, ou nro. da inscrição municipal para CNPJ", example = "1115465464")
	private String eleitorIm;
	@ApiModelProperty(value = "Gênero da pessoa", allowableValues = "F, M", example = "F")
	private String genero;
	@ApiModelProperty(value = "Data de nascimento. Retornado em UTC", example = "1982-03-20T00:00:00Z")
	private OffsetDateTime dataNascimento;
	@ApiModelProperty(value = "Registro da CNH, para CPF, ou nro. da inscrição na SUFRAMA para CNPJ", example = "1115465464")
	private String cnhSuframa;
	
	@ApiModelProperty(value = "Lista de endereços")
	private List<EnderecoModel> enderecos;
	
	@ApiModelProperty(value = "Lista de contatos")
	private List<ContatoModel> contatos;
	
	@ApiModelProperty(value = "Lista de profissões")
	private List<ProfissaoModel> profissoes;
	
	@ApiModelProperty(value = "Redes sociais do contato")
	private RedeSocialModel redeSocial;
	
}

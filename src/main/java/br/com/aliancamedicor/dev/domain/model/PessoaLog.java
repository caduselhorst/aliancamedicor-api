package br.com.aliancamedicor.dev.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbpessoa_log")
public class PessoaLog {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long pessoaId;
	@Enumerated(EnumType.STRING )
	private TipoPessoa tipoPessoa;
	private String nome;
	private String nomeSocial;
	private String tratamentoFantasia;
	private String cpfCnpj;
	private String rgIe;
	private String eleitorIm;
	@Enumerated(EnumType.STRING )
	private Genero genero;
	private OffsetDateTime dataNascimento;
	private String cnhSuframa;
	private String codIntegracao;
	

}
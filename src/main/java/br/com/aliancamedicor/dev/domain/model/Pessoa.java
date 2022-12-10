package br.com.aliancamedicor.dev.domain.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbpessoa")
public class Pessoa {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING )
	@Column(nullable = false)
	private TipoPessoa tipoPessoa;
	
	@Column(nullable = false)
	private String nome;
	
	private String nomeSocial;
	
	@Column(nullable = false)
	private String tratamentoFantasia;
	
	@Column(nullable = false)
	private String cpfCnpj;
	
	@Column(nullable = false)
	private String rgIe;
	
	private String eleitorIm;
	
	@Enumerated(EnumType.STRING )
	private Genero genero;
	
	private OffsetDateTime dataNascimento;
	
	private String cnhSuframa;
	
	private String codIntegracao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Endereco> enderecos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Contato> contatos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Profissao> profissoes;
	
	@OneToOne
	private RedeSocial redeSocial;
	@OneToOne
	private Usuario usuario;
	
	@PrePersist
	private void gerarCodigo() {
		setCodIntegracao(UUID.randomUUID().toString());
	}

}
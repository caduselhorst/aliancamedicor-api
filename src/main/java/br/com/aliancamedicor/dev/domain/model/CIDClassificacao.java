package br.com.aliancamedicor.dev.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbcid_classificacao")
public class CIDClassificacao implements Serializable {
	
	private static final long serialVersionUID = -4738786394415628783L;

	@EqualsAndHashCode.Include
	@Id
	private Long id;
	
	private String descricao;
	private String classificacao;
	
	@ManyToOne
	private CIDCapitulo capitulo;
	
	@ManyToOne
	@JoinColumn(name = "classificacao_pai")
	private CIDClassificacao classificacaPai;
	

}

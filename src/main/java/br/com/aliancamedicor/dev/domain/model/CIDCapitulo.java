package br.com.aliancamedicor.dev.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbcid_capitulo")
public class CIDCapitulo implements Serializable {
	
	private static final long serialVersionUID = -607937078354096610L;
	
	
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String capitulo;
	private String descricao;
	
	
	@OneToMany(mappedBy = "capitulo", cascade = CascadeType.ALL)
	private List<CIDClassificacao> classificacoes;

}

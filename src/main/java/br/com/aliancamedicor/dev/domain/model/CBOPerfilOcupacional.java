package br.com.aliancamedicor.dev.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbcbo_perfil_ocupacional")
public class CBOPerfilOcupacional {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cod_grande_grupo")
	private CBOGrandeGrupo grandeGrupo;
	
	@ManyToOne
	@JoinColumn(name = "cod_subgrupo_principal")
	private CBOSubGrupoPrincipal subGrupoPrincipal;
	
	@ManyToOne
	@JoinColumn(name = "cod_subgrupo")
	private CBOSubGrupo subGrupo;
	
	@ManyToOne
	@JoinColumn(name = "cod_familia")
	private CBOFamilia familia;
	
	@ManyToOne
	@JoinColumn(name = "cod_ocupacao")
	private CBOOcupacao ocupacao;
	
	@Column(name = "sgl_grande_area")
	private String siglaGrandeArea;

	@Column(name = "nome_grande_area")
	private String nomeGrandeArea;
	
	@Column(name = "cod_atividade")
	private Integer codigoAtividade;
	
	@Column(name = "nome_atividade")
	private String nomeAtividade;
	
}

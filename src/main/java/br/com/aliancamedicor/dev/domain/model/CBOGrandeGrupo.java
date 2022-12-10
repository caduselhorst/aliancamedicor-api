package br.com.aliancamedicor.dev.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbcbo_grande_grupo")
public class CBOGrandeGrupo {
	
	@EqualsAndHashCode.Include
	@Id
	private String codigo;
	private String titulo;

}

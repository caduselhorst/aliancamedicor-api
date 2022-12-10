package br.com.aliancamedicor.dev.infrastructure.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import br.com.aliancamedicor.dev.domain.model.CBOOcupacao;

public class CBOOcupacaoSpecs {

	public static Specification<CBOOcupacao> comTituloSemelhante(String titulo) {
		return (root, query, builder) -> 
			builder.like(root.get("titulo"), "%" + titulo + "%");
		
	}
	
}

package br.com.aliancamedicor.dev.infrastructure.repository.specs;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.aliancamedicor.dev.domain.filter.PessoaFilter;
import br.com.aliancamedicor.dev.domain.model.Pessoa;

public class PessoaSpecs {
	
	public static Specification<Pessoa> filtro(PessoaFilter filter) {
		return (root, query, builder) -> {
			
			var predicates = new ArrayList<Predicate>();
			
			if(filter.getCpfCnpj() != null) {
				predicates.add(builder.equal(root.get("cpfCnpj"), filter.getCpfCnpj()));
			}
			
			if(filter.getNomeRazao() != null) {
				predicates.add(builder.like(root.get("nome"), "%" + filter.getNomeRazao() + "%"));
			}
			
			return builder.and(predicates.toArray(new Predicate[] {}));
		};
	}

}

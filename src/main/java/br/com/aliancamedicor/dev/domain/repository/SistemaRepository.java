package br.com.aliancamedicor.dev.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.Sistema;

public interface SistemaRepository extends JpaRepository<Sistema, Long> {
		
	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = "pessoas")
	public List<Sistema> findAll();
	
}

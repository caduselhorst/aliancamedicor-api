package br.com.aliancamedicor.dev.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import br.com.aliancamedicor.dev.domain.model.Perfil;
import br.com.aliancamedicor.dev.domain.model.Sistema;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	@EntityGraph(type = EntityGraphType.FETCH, attributePaths = "sistema")
	public List<Perfil> findAll();
	public List<Perfil> findBySistema(Sistema sistema);
	
}

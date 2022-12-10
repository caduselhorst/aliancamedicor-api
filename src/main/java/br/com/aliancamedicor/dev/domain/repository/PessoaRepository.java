package br.com.aliancamedicor.dev.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.aliancamedicor.dev.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa> {
		
	public Optional<Pessoa> findByCodIntegracao(String codIntegracao);
	
}

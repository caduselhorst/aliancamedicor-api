package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.aliancamedicor.dev.domain.model.CBOOcupacao;

public interface CBOOcupacaoRepository extends JpaRepository<CBOOcupacao, String>, 
	JpaSpecificationExecutor<CBOOcupacao> {

}

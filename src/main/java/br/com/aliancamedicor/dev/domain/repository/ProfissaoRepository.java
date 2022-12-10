package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.Profissao;

public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

}

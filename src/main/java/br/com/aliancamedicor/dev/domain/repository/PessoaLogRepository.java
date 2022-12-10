package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.PessoaLog;

public interface PessoaLogRepository extends JpaRepository<PessoaLog, Long> {

}

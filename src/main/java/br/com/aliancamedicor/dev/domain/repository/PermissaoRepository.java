package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}

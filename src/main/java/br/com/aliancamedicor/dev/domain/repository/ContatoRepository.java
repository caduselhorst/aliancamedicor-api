package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

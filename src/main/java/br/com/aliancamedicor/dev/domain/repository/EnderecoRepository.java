package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}

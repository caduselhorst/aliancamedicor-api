package br.com.aliancamedicor.dev.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aliancamedicor.dev.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

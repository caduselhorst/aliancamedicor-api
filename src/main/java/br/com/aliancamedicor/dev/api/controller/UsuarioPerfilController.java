package br.com.aliancamedicor.dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aliancamedicor.dev.api.assembler.PerfilModelAssembler;
import br.com.aliancamedicor.dev.api.model.PerfilModel;
import br.com.aliancamedicor.dev.api.openapi.controller.UsuarioPerfilControllerOpenApi;
import br.com.aliancamedicor.dev.core.security.CheckSecurity;
import br.com.aliancamedicor.dev.domain.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios/{usuarioId}/perfis", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioPerfilController implements UsuarioPerfilControllerOpenApi {

	@Autowired
	private PerfilModelAssembler perfilModelAssembler;
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	@CheckSecurity.Usuarios.PodeConsultarUsuario
	@GetMapping
	public List<PerfilModel> listar(@PathVariable Long usuarioId) {
		return perfilModelAssembler.toCollectionModel(usuarioService.listaPerfis(usuarioId));
	}
	
	@Override
	@CheckSecurity.Usuarios.PodeGerenciarUsuario
	@PutMapping("/{perfilId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> associaPerfil(@PathVariable Long usuarioId, @PathVariable Long perfilId) {
		usuarioService.associarPerfil(usuarioId, perfilId);
		return ResponseEntity.noContent().build();
		
	}
	
	@Override
	@CheckSecurity.Usuarios.PodeGerenciarUsuario
	@DeleteMapping("/{perfilId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> desassociaPerfil(@PathVariable Long usuarioId, @PathVariable Long perfilId) {
		usuarioService.desassociarPerfil(usuarioId, perfilId);
		return ResponseEntity.noContent().build();
		
	}
}

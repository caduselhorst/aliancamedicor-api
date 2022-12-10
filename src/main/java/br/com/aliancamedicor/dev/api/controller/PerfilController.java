package br.com.aliancamedicor.dev.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aliancamedicor.dev.api.assembler.PerfilModelAssembler;
import br.com.aliancamedicor.dev.api.assembler.PerfilResumoModelAssembler;
import br.com.aliancamedicor.dev.api.model.PerfilModel;
import br.com.aliancamedicor.dev.api.model.PerfilResumoModel;
import br.com.aliancamedicor.dev.api.model.input.PerfilInput;
import br.com.aliancamedicor.dev.api.openapi.controller.PerfilControllerOpenApi;
import br.com.aliancamedicor.dev.core.security.CheckSecurity;
import br.com.aliancamedicor.dev.domain.service.PerfilService;

@RestController
@RequestMapping(path = "/perfis", produces = MediaType.APPLICATION_JSON_VALUE)
public class PerfilController implements PerfilControllerOpenApi {
	
	@Autowired
	private PerfilService perfilservice;
	@Autowired
	private PerfilModelAssembler perfilModelAssembler;
	@Autowired
	private PerfilResumoModelAssembler perfilResumoModelAssembler;
	
	@Override
	@CheckSecurity.Perfis.PodeConsultarPerfis
	@GetMapping
	public List<PerfilResumoModel> listar() {
		return perfilResumoModelAssembler.toCollectionModel(perfilservice.listar());
	}
	
	@Override
	@CheckSecurity.Perfis.PodeConsultarPerfis
	@GetMapping("/{perfilId}")
	public PerfilModel buscar(@PathVariable Long perfilId) {
		return perfilModelAssembler.toModel(perfilservice.buscar(perfilId));
	}
	
	@Override
	@CheckSecurity.Perfis.PodeGerenciarPerfis
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PerfilModel cadastrar(@RequestBody @Valid PerfilInput input) {
		return perfilModelAssembler.toModel(perfilservice.gravaPerfil(input));
	}
	
	@Override
	@CheckSecurity.Perfis.PodeGerenciarPerfis
	@PutMapping("/{perfilId}")
	public PerfilModel alterar(@PathVariable Long perfilId, @RequestBody @Valid PerfilInput perfilInput) {
		return perfilModelAssembler.toModel(perfilservice.alteraPerfil(perfilId, perfilInput));
	}
	
	@Override
	@CheckSecurity.Perfis.PodeGerenciarPerfis
	@PutMapping("/{perfilId}/permissao/{permissaoId}")
	public ResponseEntity<Void> associaPermissao(@PathVariable Long perfilId, @PathVariable Long permissaoId) {
		perfilservice.associaPermissao(perfilId, permissaoId);
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@CheckSecurity.Perfis.PodeGerenciarPerfis
	@DeleteMapping("/{perfilId}/permissao/{permissaoId}")
	public ResponseEntity<Void> desassociaPermissao(@PathVariable Long perfilId, @PathVariable Long permissaoId) {
		perfilservice.desassociaPermissao(perfilId, permissaoId);
		return ResponseEntity.noContent().build();
	}

}

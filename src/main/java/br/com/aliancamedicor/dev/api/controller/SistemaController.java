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

import br.com.aliancamedicor.dev.api.assembler.SistemaModelAssembler;
import br.com.aliancamedicor.dev.api.model.SistemaModel;
import br.com.aliancamedicor.dev.api.model.input.SistemaInput;
import br.com.aliancamedicor.dev.api.openapi.controller.SistemaControllerOpenApi;
import br.com.aliancamedicor.dev.core.security.CheckSecurity;
import br.com.aliancamedicor.dev.domain.service.SistemaService;

@RestController
@RequestMapping(path = "/sistemas", produces = MediaType.APPLICATION_JSON_VALUE)
public class SistemaController implements SistemaControllerOpenApi {
	
	@Autowired
	private SistemaService sistemaService;
	@Autowired
	private SistemaModelAssembler sistemaModelAssembler;
	
	@Override
	@CheckSecurity.Sistemas.PodeConsultarSistemas
	@GetMapping
	public List<SistemaModel> listar() {
		return sistemaModelAssembler.toCollectionModel(sistemaService.listar());
	}
	
	@Override
	@CheckSecurity.Sistemas.PodeConsultarSistemas
	@GetMapping("/{sistemaId}")
	public SistemaModel buscar(@PathVariable Long sistemaId) {
		return sistemaModelAssembler.toModel(sistemaService.buscar(sistemaId));
	}
	
	@Override
	@CheckSecurity.Sistemas.PodeGerenciarSistemas
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SistemaModel criar(@RequestBody @Valid SistemaInput sistemaInput) {
		return sistemaModelAssembler.toModel(sistemaService.cria(sistemaInput));
	}
	
	@Override
	@CheckSecurity.Sistemas.PodeGerenciarSistemas
	@PutMapping("/{sistemaId}")
	public SistemaModel alterar(@PathVariable Long sistemaId, @RequestBody @Valid SistemaInput sistemaInput) {
		return sistemaModelAssembler.toModel(sistemaService.altera(sistemaId, sistemaInput));
	}
	
	@Override
	@CheckSecurity.Sistemas.PodeGerenciarSistemas
	@PutMapping("/{sistemaId}/pessoa/{pessoaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> associaPessoa(@PathVariable Long sistemaId, @PathVariable Long pessoaId) {
		sistemaService.associaPessoa(sistemaId, pessoaId);
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@CheckSecurity.Sistemas.PodeGerenciarSistemas
	@DeleteMapping("/{sistemaId}/pessoa/{pessoaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> desassociaPessoa(@PathVariable Long sistemaId, @PathVariable Long pessoaId) {
		sistemaService.desassociaPessoa(sistemaId, pessoaId);
		return ResponseEntity.noContent().build();
	}

}

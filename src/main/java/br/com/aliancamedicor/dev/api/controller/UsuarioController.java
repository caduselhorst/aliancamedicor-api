package br.com.aliancamedicor.dev.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aliancamedicor.dev.api.assembler.UsuarioModelAssembler;
import br.com.aliancamedicor.dev.api.model.UsuarioModel;
import br.com.aliancamedicor.dev.api.model.input.PessoaIdInput;
import br.com.aliancamedicor.dev.api.model.input.SenhaInput;
import br.com.aliancamedicor.dev.api.openapi.controller.UsuarioControllerOpenApi;
import br.com.aliancamedicor.dev.core.security.CheckSecurity;
import br.com.aliancamedicor.dev.domain.service.UsuarioService;


@RestController
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController implements UsuarioControllerOpenApi {
	
	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;

	@Override
	@CheckSecurity.Usuarios.PodeAlterarSenha
	@PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInput senha) {
        service.alteraSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
    }
	
	@Override
	@CheckSecurity.Usuarios.PodeGerenciarUsuario
	@PostMapping
	public UsuarioModel criaUsuario(@RequestBody PessoaIdInput pessoaId) {
		return usuarioModelAssembler.toModel(service.criaUsuario(pessoaId.getPessoaId()));
	}
	
}

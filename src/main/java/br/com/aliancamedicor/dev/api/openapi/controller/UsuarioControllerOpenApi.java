package br.com.aliancamedicor.dev.api.openapi.controller;


import javax.validation.Valid;

import br.com.aliancamedicor.dev.api.model.UsuarioModel;
import br.com.aliancamedicor.dev.api.model.input.PessoaIdInput;
import br.com.aliancamedicor.dev.api.model.input.SenhaInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Usuários")
public interface UsuarioControllerOpenApi {
	
	@ApiOperation("Realiza a alteração da senha de um usuário")
	public void alterarSenha(@ApiParam(value = "Id do usuário", example = "1") Long usuarioId, 
			@ApiParam("Modelo de representação de input de alteração de senha") SenhaInput senha);
	
	@ApiOperation("Realiza a criação de um usuário e associa a uma pessoa")
	public UsuarioModel criaUsuario(@ApiParam(value="Presentação do input do ID pessoa") @Valid PessoaIdInput pessoaId);

}
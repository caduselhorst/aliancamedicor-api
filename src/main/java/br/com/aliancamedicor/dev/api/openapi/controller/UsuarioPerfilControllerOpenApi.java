package br.com.aliancamedicor.dev.api.openapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.aliancamedicor.dev.api.model.PerfilModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Usuários")
public interface UsuarioPerfilControllerOpenApi {

	@ApiOperation("Lista os perfis do usuário")
	public List<PerfilModel> listar(@ApiParam(value = "Identificador do usuário", example = "1") Long usuarioId);
	
	@ApiOperation("Associa um perfil ao usuario")
	public ResponseEntity<Void> associaPerfil(@ApiParam(value = "Identificador do usuário", example = "1") Long usuarioId, 
			@ApiParam(value = "Identificador do perfil", example = "1") Long perfilId);
	
	@ApiOperation("Desassocia um perfil do usuario")
	public ResponseEntity<Void> desassociaPerfil(@ApiParam(value = "Identificador do usuário", example = "1") Long usuarioId, 
			@ApiParam(value = "Identificador do perfil", example = "1") Long perfilId);

}
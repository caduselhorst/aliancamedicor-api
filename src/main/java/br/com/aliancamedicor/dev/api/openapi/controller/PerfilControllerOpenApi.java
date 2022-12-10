package br.com.aliancamedicor.dev.api.openapi.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.aliancamedicor.dev.api.exceptionhandler.Problem;
import br.com.aliancamedicor.dev.api.model.PerfilModel;
import br.com.aliancamedicor.dev.api.model.PerfilResumoModel;
import br.com.aliancamedicor.dev.api.model.input.PerfilInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Perfis")
public interface PerfilControllerOpenApi {

	@ApiOperation(value = "Lista todas as permissões cadastradas")
	List<PerfilResumoModel> listar();

	@ApiOperation(value = "Busca um perfil pelo Id")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Permissão não encontrada", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	PerfilModel buscar(@ApiParam(value = "Identificador do perfil", example = "1") Long perfilId);

	@ApiOperation(value = "Cadastra um novo perfil")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Sistema não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "201", description = "Perfil cadastrado")
	})
	PerfilModel cadastrar(@ApiParam(value = "Representação de input de perfil") PerfilInput input);

	@ApiOperation(value = "Altera um perdil")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Sistema não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Perfil não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "201", description = "Perfil alterado")
	})
	PerfilModel alterar(@ApiParam(value = "Identificador do perfil", example = "1") Long perfilId, 
			@ApiParam("Representação de input de perfil") PerfilInput perfilInput);

	@ApiOperation(value = "Associa uma permissão a um perfil")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Perfil não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Permissão não encontrada", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "204", description = "Permissão associada")
	})
	ResponseEntity<Void> associaPermissao(Long perfilId, Long permissaoId);
	
	@ApiOperation(value = "Desassocia uma permissão de um perfil")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Perfil não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Permissão não encontrada", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "204", description = "Permissão desassociada")
	})
	ResponseEntity<Void> desassociaPermissao(Long perfilId, Long permissaoId);

}
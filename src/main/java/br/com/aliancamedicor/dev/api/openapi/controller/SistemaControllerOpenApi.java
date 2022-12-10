package br.com.aliancamedicor.dev.api.openapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.aliancamedicor.dev.api.exceptionhandler.Problem;
import br.com.aliancamedicor.dev.api.model.SistemaModel;
import br.com.aliancamedicor.dev.api.model.input.SistemaInput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Sistemas")
public interface SistemaControllerOpenApi {

	@ApiOperation("Lista os sitemas cadastrados")
	public List<SistemaModel> listar();

	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Sistema não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "400", description = "ID do sistema inválido", 
		content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	public SistemaModel buscar(@ApiParam(value = "Identificador do sistema", example = "1") Long sistemaId);

	@ApiOperation("Cadastra um sistema")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Sistema cadastrado"),
	})
	public SistemaModel criar(SistemaInput sistemaInput);

	@ApiOperation("Altera um sistema por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Sistema não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "200", description = "Sistema atualizado")
	})
	public SistemaModel alterar(Long sistemaId, SistemaInput sistemaInput);
	
	@ApiOperation("Associa uma pessoa a um sistema")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Sistema não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Pessoa não encontrada", 
			content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "204", description = "Pessoa associada")
	})
	public ResponseEntity<Void> associaPessoa(
			@ApiParam(value = "Identificador do sistema", example = "1") Long sistemaId, 
			@ApiParam(value = "Identificador da pessoa") Long pessoaId);
	
	@ApiOperation("Desassocia uma pessoa de um sistema")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Sistema não encontrado", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "404", description = "Pessoa não encontrada", 
			content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))),
		@ApiResponse(responseCode = "204", description = "Pessoa desassociada")
	})
	public ResponseEntity<Void> desassociaPessoa(
			@ApiParam(value = "Identificador do sistema", example = "1") Long sistemaId, 
			@ApiParam(value = "Identificador da pessoa") Long pessoaId);

}
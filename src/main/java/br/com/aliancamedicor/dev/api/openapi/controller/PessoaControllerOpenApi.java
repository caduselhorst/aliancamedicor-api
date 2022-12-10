package br.com.aliancamedicor.dev.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.aliancamedicor.dev.api.exceptionhandler.Problem;
import br.com.aliancamedicor.dev.api.model.PessoaModel;
import br.com.aliancamedicor.dev.api.model.PessoaResumoModel;
import br.com.aliancamedicor.dev.api.model.input.PessoaInput;
import br.com.aliancamedicor.dev.domain.filter.PessoaFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Pessoas")
public interface PessoaControllerOpenApi {
	
	@ApiOperation(value = "Cria o registro de uma pessoa na base geral")
	public PessoaModel gravaPessoa(PessoaInput input);
	
	@ApiOperation(value = "Carrega uma pessoa pelo códido")
	@ApiResponses({
		@ApiResponse(responseCode = "404", description = "Pessoa não encontrada", 
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
	})
	public PessoaModel getPessoaPeloId(@ApiParam(value = "Código da pessoa") Long pessoaId);
	
	@ApiOperation(value = "Recupera uma lista paginada de pessoas com atributos resumidos")
	public Page<PessoaResumoModel> lista(@ApiParam("Atributos de filtro") PessoaFilter filter, @ApiParam("Atributos de paginação") Pageable pageable);
	
	@ApiOperation(value = "Realiza a alteração de uma pessoa")
	public PessoaModel alteraPessoa(Long pessoaId, PessoaInput input);

}
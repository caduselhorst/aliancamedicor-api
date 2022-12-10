package br.com.aliancamedicor.dev.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.aliancamedicor.dev.api.model.CBOOcupacaoModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Ocupações")
public interface CBOOcupacaoControllerOpenApi {

	@ApiOperation(value = "Filtra as ocupações, executando a paginação")
	public Page<CBOOcupacaoModel> filtraOcupacoes(@ApiParam(value = "Parâmetros de página") Pageable pageable, 
			@ApiParam(value = "Titulo", example = "analista", defaultValue = "analista") String filtro);
	
}

package br.com.aliancamedicor.dev.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.aliancamedicor.dev.api.assembler.CBOOcupacaoModelAssembler;
import br.com.aliancamedicor.dev.api.model.CBOOcupacaoModel;
import br.com.aliancamedicor.dev.api.openapi.controller.CBOOcupacaoControllerOpenApi;
import br.com.aliancamedicor.dev.core.security.CheckSecurity;
import br.com.aliancamedicor.dev.domain.model.CBOOcupacao;
import br.com.aliancamedicor.dev.domain.repository.CBOOcupacaoRepository;
import br.com.aliancamedicor.dev.infrastructure.repository.specs.CBOOcupacaoSpecs;

@RestController
@RequestMapping(value = "/cbo-ocupacoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class CBOOcupacaoController implements CBOOcupacaoControllerOpenApi {
	
	@Autowired
	private CBOOcupacaoRepository cboOcupacaoRepository;
	@Autowired
	private CBOOcupacaoModelAssembler cboOcupacaoModelAssembler;
	
	@Override
	@GetMapping
	@CheckSecurity.CBOOcupacoes.PodeConsultar
	public Page<CBOOcupacaoModel> filtraOcupacoes(@PageableDefault(size = 10) Pageable pageable, @RequestParam String filtro) {
		
		Page<CBOOcupacao> page = cboOcupacaoRepository.findAll(CBOOcupacaoSpecs.comTituloSemelhante(filtro), pageable);
		
		return cboOcupacaoModelAssembler.toPageModel(page);
		
	}

}

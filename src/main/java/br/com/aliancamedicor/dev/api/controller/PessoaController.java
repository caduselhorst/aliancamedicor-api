package br.com.aliancamedicor.dev.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aliancamedicor.dev.api.assembler.PessoaModelAssembler;
import br.com.aliancamedicor.dev.api.assembler.PessoaResumoModelAssembler;
import br.com.aliancamedicor.dev.api.model.PessoaModel;
import br.com.aliancamedicor.dev.api.model.PessoaResumoModel;
import br.com.aliancamedicor.dev.api.model.input.PessoaInput;
import br.com.aliancamedicor.dev.api.openapi.controller.PessoaControllerOpenApi;
import br.com.aliancamedicor.dev.core.security.CheckSecurity;
import br.com.aliancamedicor.dev.domain.filter.PessoaFilter;
import br.com.aliancamedicor.dev.domain.model.Pessoa;
import br.com.aliancamedicor.dev.domain.repository.PessoaRepository;
import br.com.aliancamedicor.dev.domain.service.PessoaService;
import br.com.aliancamedicor.dev.infrastructure.repository.specs.PessoaSpecs;

@RestController
@RequestMapping(path = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController implements PessoaControllerOpenApi {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaModelAssembler pessoaModelAssembler;
	
	@Autowired
	private PessoaResumoModelAssembler pessoaResumoModelAssembler;
	
	@Override
	@CheckSecurity.Pessoas.PodeGerenciar
	@PostMapping
	public PessoaModel gravaPessoa(@Valid @RequestBody PessoaInput input) {
		return pessoaModelAssembler.toModel(pessoaService.gravaPessoa(input, new Pessoa()));
	}
		
	@Override
	@CheckSecurity.Pessoas.PodeConsultar
	@GetMapping("/{pessoaId}")
	public PessoaModel getPessoaPeloId(@PathVariable Long pessoaId) {
		return pessoaModelAssembler.toModel(pessoaService.buscar(pessoaId));
	}
	
	@Override
	@CheckSecurity.Pessoas.PodeConsultar
	@GetMapping
	public Page<PessoaResumoModel> lista(PessoaFilter filter, Pageable pageable) {
		return pessoaResumoModelAssembler.toPageModel(pessoaRepository.findAll(PessoaSpecs.filtro(filter), pageable));
	}
	
	@Override
	@CheckSecurity.Pessoas.PodeConsultar
	@PutMapping("/{pessoaId}")
	public PessoaModel alteraPessoa(@PathVariable Long pessoaId, @Valid @RequestBody PessoaInput input) {
		return pessoaModelAssembler.toModel(pessoaService.alteraPessoa(pessoaId, input));
	}

}

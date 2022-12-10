package br.com.aliancamedicor.dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aliancamedicor.dev.api.assembler.CIDCapituloModelAssembler;
import br.com.aliancamedicor.dev.api.model.CIDCapituloModel;
import br.com.aliancamedicor.dev.domain.exception.CIDCapituloNaoEncontradoException;
import br.com.aliancamedicor.dev.domain.model.CIDCapitulo;
import br.com.aliancamedicor.dev.domain.repository.CIDCapituloRepository;

@RestController
@RequestMapping("/cid")
public class CIDCapituloController {
	
	@Autowired
	private CIDCapituloRepository repository;
	
	@Autowired
	private CIDCapituloModelAssembler assembler;
	
	@GetMapping
	private List<CIDCapitulo> lista() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	private CIDCapituloModel carregaPorId(@PathVariable Long id) {
		return assembler.toModel(repository.findById(id).orElseThrow(() -> new CIDCapituloNaoEncontradoException(id)));
	}

}

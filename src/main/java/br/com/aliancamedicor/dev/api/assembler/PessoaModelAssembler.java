package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.PessoaModel;
import br.com.aliancamedicor.dev.domain.model.Pessoa;

@Component
public class PessoaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaModel toModel(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaModel.class);
	}
	
	public List<PessoaModel> toCollectionModel(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(this::toModel).collect(Collectors.toList());
	}
	
	public Page<PessoaModel> toPageModel(Page<Pessoa> pageable) {
		
		List<PessoaModel> pessoasModel = toCollectionModel(pageable.getContent());
		Page<PessoaModel> pagePessoaModel = new PageImpl<>(pessoasModel, 
				pageable.getPageable(), pageable.getNumberOfElements());
		
		return pagePessoaModel;
		
	}

}

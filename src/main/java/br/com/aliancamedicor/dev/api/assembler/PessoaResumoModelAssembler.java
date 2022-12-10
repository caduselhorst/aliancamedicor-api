package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.PessoaResumoModel;
import br.com.aliancamedicor.dev.domain.model.Pessoa;

@Component
public class PessoaResumoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public PessoaResumoModel toModel(Pessoa pessoa) {
		return modelMapper.map(pessoa, PessoaResumoModel.class);
	}
	
	public List<PessoaResumoModel> toCollectionModel(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(this::toModel).collect(Collectors.toList());
	}
	
	public Page<PessoaResumoModel> toPageModel(Page<Pessoa> pageable) {
		
		List<PessoaResumoModel> pessoasModel = toCollectionModel(pageable.getContent());
		Page<PessoaResumoModel> pagePessoaModel = new PageImpl<>(pessoasModel, 
				pageable.getPageable(), pageable.getNumberOfElements());
		
		return pagePessoaModel;
		
	}
	
}

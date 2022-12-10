package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.CBOOcupacaoModel;
import br.com.aliancamedicor.dev.domain.model.CBOOcupacao;

/**
 * Classe que realiza o mapeamento de modelo de domínio {@link br.com.aliancamedicor.dev.domain.model.CBOOcupacao} para o
 * modelo de representação {@link br.com.aliancamedicor.dev.api.model.CBOOcupacaoModel}
 * 
 * @author carlos
 *
 */
@Component
public class CBOOcupacaoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public CBOOcupacaoModel toModel(CBOOcupacao ocupacao) {
		return modelMapper.map(ocupacao, CBOOcupacaoModel.class);
	}
	
	public List<CBOOcupacaoModel> toCollectionModel(List<CBOOcupacao> ocupacoes) {
		return ocupacoes.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Page<CBOOcupacaoModel> toPageModel(Page<CBOOcupacao> pageable) {
		
		List<CBOOcupacaoModel> listModel = toCollectionModel(pageable.getContent());
		
		Page<CBOOcupacaoModel> pageModel = new PageImpl<>(listModel, pageable.getPageable(), pageable.getTotalElements());
		
		return pageModel;
	}
	
}

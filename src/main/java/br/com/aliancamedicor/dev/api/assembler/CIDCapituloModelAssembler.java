package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.CIDCapituloModel;
import br.com.aliancamedicor.dev.domain.model.CIDCapitulo;

@Component
public class CIDCapituloModelAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public CIDCapituloModel toModel(CIDCapitulo capitulo) {
		return mapper.map(capitulo, CIDCapituloModel.class);
	}
	
	public List<CIDCapituloModel> toCollectionModel(List<CIDCapitulo> capitulos) {
		return capitulos.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
}

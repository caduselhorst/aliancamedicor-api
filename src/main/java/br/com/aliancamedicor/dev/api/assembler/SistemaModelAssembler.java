package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.SistemaModel;
import br.com.aliancamedicor.dev.domain.model.Sistema;

@Component
public class SistemaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SistemaModel toModel(Sistema sistema) {
		return modelMapper.map(sistema, SistemaModel.class);
	}
	
	public List<SistemaModel> toCollectionModel(List<Sistema> sistemas) {
		return sistemas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

}

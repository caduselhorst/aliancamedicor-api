package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.PerfilModel;
import br.com.aliancamedicor.dev.domain.model.Perfil;

@Component
public class PerfilModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PerfilModel toModel(Perfil perfil) {
		return modelMapper.map(perfil, PerfilModel.class);
	}
	
	public List<PerfilModel> toCollectionModel(Set<Perfil> perfis) {
		return perfis.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public List<PerfilModel> toCollectionModel(List<Perfil> perfis) {
		return perfis.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

}

package br.com.aliancamedicor.dev.api.assembler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.PerfilResumoModel;
import br.com.aliancamedicor.dev.domain.model.Perfil;

@Component
public class PerfilResumoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PerfilResumoModel toModel(Perfil perfil) {
		return modelMapper.map(perfil, PerfilResumoModel.class);
	}
	
	public List<PerfilResumoModel> toCollectionModel(Set<Perfil> perfis) {
		return perfis.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public List<PerfilResumoModel> toCollectionModel(List<Perfil> perfis) {
		return perfis.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

}

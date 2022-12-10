package br.com.aliancamedicor.dev.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.input.RedeSocialInput;
import br.com.aliancamedicor.dev.domain.model.RedeSocial;

@Component
public class RedeSocialInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public RedeSocial toDomainModel(RedeSocialInput input) {
		return modelMapper.map(input, RedeSocial.class);
	}
	
	public void toDomainModel(RedeSocialInput input, RedeSocial redeSocial) {
		modelMapper.map(input, redeSocial);
	}
	
}

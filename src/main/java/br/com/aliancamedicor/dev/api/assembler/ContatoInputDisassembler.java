package br.com.aliancamedicor.dev.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.input.ContatoInput;
import br.com.aliancamedicor.dev.domain.model.Contato;

@Component
public class ContatoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Contato toDomainModel(ContatoInput input) {
		
		return modelMapper.map(input, Contato.class);
		
	}
	
}

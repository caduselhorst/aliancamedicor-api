package br.com.aliancamedicor.dev.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.input.EnderecoInput;
import br.com.aliancamedicor.dev.domain.model.Endereco;

@Component
public class EnderecoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Endereco toDomainModel(EnderecoInput input) {
		return modelMapper.map(input, Endereco.class);
	}
	
}

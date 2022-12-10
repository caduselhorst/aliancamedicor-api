package br.com.aliancamedicor.dev.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.input.PessoaInput;
import br.com.aliancamedicor.dev.domain.model.Pessoa;

@Component
public class PessoaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pessoa toDomainModel(PessoaInput input) {
		return modelMapper.map(input, Pessoa.class);
	}
	
	public void toDomainModel(PessoaInput input, Pessoa pessoa) {
		modelMapper.map(input, pessoa);
	}

}

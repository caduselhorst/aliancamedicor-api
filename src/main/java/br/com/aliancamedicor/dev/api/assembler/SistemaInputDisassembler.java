package br.com.aliancamedicor.dev.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.input.SistemaInput;
import br.com.aliancamedicor.dev.domain.model.Sistema;

@Component
public class SistemaInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Sistema toDomainModel(SistemaInput sistemaInput) {
		return modelMapper.map(sistemaInput, Sistema.class);
	}
	
	public void toDomainModel(SistemaInput sistemaInput, Sistema sistema) {
		modelMapper.map(sistemaInput, sistema);
	}
}

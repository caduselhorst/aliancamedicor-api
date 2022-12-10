package br.com.aliancamedicor.dev.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aliancamedicor.dev.api.model.input.RedeSocialInput;
import br.com.aliancamedicor.dev.api.model.input.SistemaInput;
import br.com.aliancamedicor.dev.domain.model.Pessoa;
import br.com.aliancamedicor.dev.domain.model.PessoaLog;
import br.com.aliancamedicor.dev.domain.model.RedeSocial;
import br.com.aliancamedicor.dev.domain.model.Sistema;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper getModelMapper() {
		
		var modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(RedeSocialInput.class, RedeSocial.class)
			.addMappings(mapper -> mapper.skip(RedeSocial::setId));
		
		modelMapper.createTypeMap(SistemaInput.class, Sistema.class)
			.addMappings(mapper -> mapper.skip(Sistema::setId));
		
		var typeMapPessoaToPessoaLog = modelMapper.createTypeMap(Pessoa.class, PessoaLog.class);
		
		typeMapPessoaToPessoaLog.<Long>addMapping(pessoa -> pessoa.getId(), 
				(pessoaLog, value) -> pessoaLog.setPessoaId(value));
		
		return modelMapper;
	}
	
}

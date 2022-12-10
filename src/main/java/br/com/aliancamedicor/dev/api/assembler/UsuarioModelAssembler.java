package br.com.aliancamedicor.dev.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.api.model.UsuarioModel;
import br.com.aliancamedicor.dev.domain.model.Usuario;

@Component
public class UsuarioModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioModel toModel(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioModel.class);
	}

}

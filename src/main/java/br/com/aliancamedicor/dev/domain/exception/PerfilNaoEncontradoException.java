package br.com.aliancamedicor.dev.domain.exception;

public class PerfilNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1394558305056278128L;
	
	public PerfilNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PerfilNaoEncontradoException(Long perfilId) {
		this(String.format("Não existe um cadastro de perfil com o código %d.", perfilId));
	}

}

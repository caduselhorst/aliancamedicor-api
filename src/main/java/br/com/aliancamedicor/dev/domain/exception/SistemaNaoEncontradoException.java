package br.com.aliancamedicor.dev.domain.exception;

public class SistemaNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1394558305056278128L;
	
	public SistemaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public SistemaNaoEncontradoException(Long sistemaId) {
		this(String.format("Não existe um cadastro de sistema com o código %d.", sistemaId));
	}

}

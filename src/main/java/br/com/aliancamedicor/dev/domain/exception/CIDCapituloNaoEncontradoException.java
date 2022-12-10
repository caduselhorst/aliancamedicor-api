package br.com.aliancamedicor.dev.domain.exception;

public class CIDCapituloNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1394558305056278128L;
	
	public CIDCapituloNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CIDCapituloNaoEncontradoException(Long id) {
		this(String.format("Não existe o capítulo do CID cadastrado com o código %d.", id));
	}

}

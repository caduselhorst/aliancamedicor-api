package br.com.aliancamedicor.dev.domain.exception;

public class CIDClassificacaoNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1394558305056278128L;
	
	public CIDClassificacaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CIDClassificacaoNaoEncontradoException(Long id) {
		this(String.format("Não existe uma classificação do CID cadastrado com o código %d.", id));
	}

}

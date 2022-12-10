package br.com.aliancamedicor.dev.domain.exception;

import org.springframework.security.access.AccessDeniedException;

public class SenhaExpiradaException extends AccessDeniedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7735968656111535835L;

	public SenhaExpiradaException(String msg) {
		super(msg);
	}

}

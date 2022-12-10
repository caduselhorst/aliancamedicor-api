package br.com.aliancamedicor.dev.core.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import br.com.aliancamedicor.dev.domain.exception.SenhaExpiradaException;

@Component
public class AliancaMedicorSecurity {
	

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public Long getUsuarioId() {
		
		Jwt jwt = (Jwt) getAuthentication().getPrincipal();
		
		return jwt.getClaim("usuario_id");
	}
	
	public boolean isExpirado() {
		Jwt jwt = (Jwt) getAuthentication().getPrincipal();
		
		return jwt.getClaim("expirado");
	}
	
	public boolean senhaNaoExpirada() {
	
		if(isExpirado()) {
			throw new SenhaExpiradaException("A senha está expirada. Realize a alteração.");
		} else {
			return true;
		}
	}
	
	
}

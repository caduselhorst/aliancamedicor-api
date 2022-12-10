package br.com.aliancamedicor.dev.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {
	
	public @interface CBOOcupacoes {
		
		@PreAuthorize("hasAuthority('SCOPE_READ') and hasAuthority('1-PERMITE_CONSULTAR_CBO_OCUPACOES') "
				+ "and @aliancaMedicorSecurity.senhaNaoExpirada()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar { }
		
	}
		
	public @interface Pessoas {
		
		@PreAuthorize("isAuthenticated() and @aliancaMedicorSecurity.senhaNaoExpirada()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultar { }
		
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and hasAuthority('1-PERMITE_GERENCIAR_PESSOA') "
				+ "and @aliancaMedicorSecurity.senhaNaoExpirada()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciar { }
		
		
	}
	
	public @interface Usuarios {
		
		@PreAuthorize("isAuthenticated()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeAlterarSenha { }
		
		@PreAuthorize("hasAuthority('SCOPE_WRITE') and isAuthenticated() and hasAuthority('1-PERMITE_GERENCIAR_USUARIOS') "
				+ "and @aliancaMedicorSecurity.senhaNaoExpirada()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciarUsuario { }
		
		@PreAuthorize("hasAuthority('SCOPE_READ') and isAuthenticated() and hasAuthority('1-PERMITE_CONSULTAR_USUARIOS') "
				+ "and @aliancaMedicorSecurity.senhaNaoExpirada()")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarUsuario { }
		
	}
	
	public @interface Perfis {
		
		@PreAuthorize("isAuthenticated() and @aliancaMedicorSecurity.senhaNaoExpirada() and "
				+ "hasAuthority('SCOPE_READ') and "
				+ "hasAuthority('1-PERMITE_CONSULTAR_PERFIS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarPerfis {}
		
		@PreAuthorize("isAuthenticated() and @aliancaMedicorSecurity.senhaNaoExpirada() and "
				+ "hasAuthority('SCOPE_WRITE') and "
				+ "hasAuthority('1-PERMITE_GERENCIAR_PERFIS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciarPerfis{}
	}
	
	public @interface Sistemas {
		
		@PreAuthorize("isAuthenticated() and @aliancaMedicorSecurity.senhaNaoExpirada() and "
				+ "hasAuthority('SCOPE_READ') and "
				+ "hasAuthority('1-PERMITE_CONSULTAR_SISTEMAS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeConsultarSistemas {}
		
		@PreAuthorize("isAuthenticated() and @aliancaMedicorSecurity.senhaNaoExpirada() and "
				+ "hasAuthority('SCOPE_WRITE') and "
				+ "hasAuthority('1-PERMITE_GERENCIAR_SISTEMAS')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciarSistemas {}
		
	}

}

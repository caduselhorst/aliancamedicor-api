package br.com.aliancamedicor.dev.domain.service;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aliancamedicor.dev.domain.exception.NegocioException;
import br.com.aliancamedicor.dev.domain.exception.PerfilNaoEncontradoException;
import br.com.aliancamedicor.dev.domain.exception.UsuarioNaoEncontradoException;
import br.com.aliancamedicor.dev.domain.model.Perfil;
import br.com.aliancamedicor.dev.domain.model.Pessoa;
import br.com.aliancamedicor.dev.domain.model.Usuario;
import br.com.aliancamedicor.dev.domain.repository.PerfilRepository;
import br.com.aliancamedicor.dev.domain.repository.UsuarioRepository;
/**
 * Classe responsável por gerenciar as instãncias persistidas de {@link br.com.aliancamedicor.dev.domain.model.Usuario}
 * 
 * @author carlos
 *
 */
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRespository;
	@Autowired
	private PasswordEncoder passwordEnconder;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private PerfilRepository perfilRepository;
	
	private static final String SENHA_PADRAO_USUARIO="alianca123";
	
	/**
	 * Busca um usuário persistido pelo seu identificador 
	 *   
	 * @param usuarioId Id do usuário
	 * @return Instância persistida de um usuário
	 * @throws br.com.aliancamedicor.dev.domain.exception.UsuarioNaoEncontradoException
	 */
	public Usuario buscarUsuario(Long usuarioId) {
		return usuarioRespository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}
	
	/**
	 * Busca um perfil persistido pelo seu identificador
	 * 
	 * @param perfilId Id do perfil
	 * @return Instância persistida de Perfil
	 * @throws br.com.aliancamedicor.dev.domain.exception.PermissaoNaoEncontradaException
	 */
	public Perfil buscarPerfil(Long perfilId) {
		return perfilRepository.findById(perfilId)
				.orElseThrow(() -> new PerfilNaoEncontradoException(perfilId));
	}
	
	/**
	 * Método que realiza a alteração da senha de um usuário.
	 * Lança br.com.aliancamedicor.dev.domain.exception.UsuarioNaoEncontradoException
	 * caso não encontre o usuário
	 * <p>
	 * Esse método realiza a verificação de força da senha:
	 * <ul>
	 *  <li>8 a 20 caracteres</li>
	 *  <li>letras</li>
	 *  <li>números</li>
	 *  <li>caracteres especiais  ! @ # $% & *() - + = ^.</li>
	 * </ul>
	 * 
	 * @param usuarioId Identificador do usuário
	 * @param senhaAtual Senha atual do usuário
	 * @param novaSenha Nova senha
	 * @throws br.com.aliancamedicor.dev.domain.exception.UsuarioNaoEncontradoException
	 * @throws br.com.aliancamedicor.dev.domain.exception.NegocioException
	 */
	@Transactional
	public void alteraSenha(Long usuarioId, String senhaAtual, String novaSenha) {
		
		if(!senhaForte(novaSenha)) {  
			throw new NegocioException("A senha informada deve entre 8 e 20 caracteres, letras, números e caracteres especiais");
		}
		
		Usuario usuario = buscarUsuario(usuarioId);
		
		if(!passwordEnconder.matches(senhaAtual, usuario.getSenha())) {
			throw new NegocioException("A senha atual informada não corresponde com a senha do usuário");
		}
		
		
		usuario.setSenha(passwordEnconder.encode(novaSenha));
		usuario.setExpirado(false);
		
		usuarioRespository.save(usuario);
		
	}
	
	/**
	 * Cria um usuário na base geral e associa a uma pessoa. Lança a exceção de execução PessoaNaoEncontradaException
	 * caso não encontre uma correspondente persistida.
	 * 
	 * @param pessoaId Id da pessoa
	 * @return Intãncia do usuário criado
	 * @throws br.com.aliancamedicor.dev.domain.exception.PessoaNaoEncontradaException
	 * @throws br.com.aliancamedicor.dev.domain.exception.NegocioException
	 */
	@Transactional
	public Usuario criaUsuario(Long pessoaId) {
		
		Pessoa pessoa = pessoaService.buscar(pessoaId);
		pessoa.getUsuario();
		
		if(pessoa.getUsuario() != null) {
			throw new NegocioException("Já existe um usuário associado a essa pessoa");
		}
		
		Usuario usuario = new Usuario();
		
		usuario.setSenha(passwordEnconder.encode(SENHA_PADRAO_USUARIO));
		usuario.setExpirado(true);
		usuario.setPessoa(pessoa);
		
		usuarioRespository.save(usuario);
		
		pessoa.setUsuario(usuario);
		
		return usuario;
	}
	
	/**
	 * Lista os perfis do usuário requisitado
	 * 
	 * @param usuarioId Identificador do usuário
	 * @return {@link java.util.Set} de perfis de usuário
	 */
	public Set<Perfil> listaPerfis(Long usuarioId) {
		Usuario u = buscarUsuario(usuarioId);
		
		return u.getPerfis();
	}
	
	/**
	 * Realiza a associação de um perfil a um usuário
	 * 
	 * @param usuarioId Identificador do usuário
	 * @param perfilId Identificador do perfil
	 * @throws br.com.aliancamedicor.dev.domain.exception.UsuarioNaoEncontradoException
	 */
	@Transactional
	public void associarPerfil(Long usuarioId, Long perfilId) {
		Usuario usuario = buscarUsuario(usuarioId);
		Perfil perfil = buscarPerfil(perfilId);
		
		usuario.associaPerfil(perfil);
	}
	
	/**
	 * Realiza a desassociação de um perfil a um usuário
	 * 
	 * @param usuarioId Identificador do usuário
	 * @param perfilId Identificador do perfil
	 * @throws br.com.aliancamedicor.dev.domain.exception.UsuarioNaoEncontradoException
	 */
	@Transactional
	public void desassociarPerfil(Long usuarioId, Long perfilId) {
		Usuario usuario = buscarUsuario(usuarioId);
		Perfil perfil = buscarPerfil(perfilId);
		
		usuario.desassociaPerfil(perfil);
	}
	
	
	private boolean senhaForte(String senha) {
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);
		
		return matcher.matches();
		
	}

}

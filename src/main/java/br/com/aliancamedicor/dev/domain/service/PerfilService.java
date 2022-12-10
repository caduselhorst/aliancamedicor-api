package br.com.aliancamedicor.dev.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aliancamedicor.dev.api.model.input.PerfilInput;
import br.com.aliancamedicor.dev.domain.exception.PerfilNaoEncontradoException;
import br.com.aliancamedicor.dev.domain.exception.PermissaoNaoEncontradaException;
import br.com.aliancamedicor.dev.domain.model.Perfil;
import br.com.aliancamedicor.dev.domain.model.Permissao;
import br.com.aliancamedicor.dev.domain.model.Sistema;
import br.com.aliancamedicor.dev.domain.repository.PerfilRepository;
import br.com.aliancamedicor.dev.domain.repository.PermissaoRepository;

/**
 * Classe responsável por realizar o gerenciamento das entidades de Perfil
 * 
 * @author carlos
 *
 */
@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private SistemaService sistemaService;
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	/**
	 * Busca um perfil pelo seu identificador.
	 * 
	 * @param perfilId Id do perfil
	 * @return Instância persistida do perfil correpondente
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.PerfilNaoEncontradoException
	 */
	public Perfil buscar(Long perfilId) {
		return perfilRepository.findById(perfilId)
				.orElseThrow(() -> new PerfilNaoEncontradoException(perfilId));
	}
	
	/**
	 * Lista os perfis cadastrados;
	 * 
	 * @return
	 */
	public List<Perfil> listar() {
		return perfilRepository.findAll();
	}
	
	/**
	 * Cria e persiste uma instância de Perfil. Lança uma exceção de execução caso não encontre uma instância de sistema, informada no objeto de input
	 * 
	 * @param input Modelo de representação de input de perfil
	 * @return Instância persistida de perfil
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.SistemaNaoEncontradoException
	 */
	@Transactional
	public Perfil gravaPerfil(PerfilInput input) {
		
		Sistema sistema = sistemaService.buscar(input.getSistema().getId());
		
		Perfil perfil = new Perfil();
		perfil.setNome(input.getNome());
		perfil.setSistema(sistema);
		
		return perfilRepository.save(perfil);
	}
	
	/**
	 * Altera uma instância persistida de Perfil. Lança um exceção de execução caso não uma instância persistida de Perfil ou Sistema
	 * 
	 * @param perfilId Identificador do perfil
	 * @param input Represenação de input de perfil
	 * @return Instância de perfil alterada e persistida
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.PerfilNaoEncontradoException
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.SistemaNaoEncontradoException
	 */
	@Transactional
	public Perfil alteraPerfil(Long perfilId, PerfilInput input) {
		
		Sistema sistema = sistemaService.buscar(input.getSistema().getId());
		Perfil perfil = buscar(perfilId);
		
		perfil.setNome(input.getNome());
		perfil.setSistema(sistema);
		
		return perfil;
		
	}
	
	/**
	 * Associa uma permissão ao Perfil. Lança uma exceção de execução caso não encontre um Perfil ou uma Permissao pesistida
	 * 
	 * @param perfilId Identificador do perfil
	 * @param permissaoId Identificador da permissao
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.PerfilNaoEncontradoException
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.PermissaoNaoEncontradaException
	 */
	@Transactional
	public void associaPermissao(Long perfilId, Long permissaoId) {
		
		Perfil perfil = buscar(perfilId);
		perfil.associaPermissao(buscaPermissao(permissaoId));
		
	}
	
	/**
	 * Desassocia uma permissão do Perfil. Lança uma exceção de execução caso não encontre um Perfil ou uma Permissao pesistida
	 * 
	 * @param perfilId Identificador do perfil
	 * @param permissaoId Identificador da permissao
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.PerfilNaoEncontradoException
	 * @throws br.com.aliancamedicor.dev.domain.model.exception.PermissaoNaoEncontradaException
	 */
	@Transactional
	public void desassociaPermissao(Long perfilId, Long permissaoId) {
		
		Perfil perfil = buscar(perfilId);
		perfil.desassociaPermissao(buscaPermissao(permissaoId));
		
	}
	
	
	private Permissao buscaPermissao(Long permissaoId) {
		return permissaoRepository.findById(permissaoId)
				.orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
	}
	
}

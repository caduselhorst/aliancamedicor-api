package br.com.aliancamedicor.dev.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aliancamedicor.dev.api.assembler.SistemaInputDisassembler;
import br.com.aliancamedicor.dev.api.model.input.SistemaInput;
import br.com.aliancamedicor.dev.domain.exception.SistemaNaoEncontradoException;
import br.com.aliancamedicor.dev.domain.model.Pessoa;
import br.com.aliancamedicor.dev.domain.model.Sistema;
import br.com.aliancamedicor.dev.domain.repository.SistemaRepository;

/**
 * Classe responsável por realizar as operações CRUD da entidade 
 * {@link br.com.aliancamedicor.dev.domain.model.Sistema}
 * 
 * @author carlos
 *
 */
@Service
public class SistemaService {
	
	@Autowired
	private SistemaRepository sistemaRepository;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private SistemaInputDisassembler sistemaInputDisassembler;

	
	/**
	 * Busca uma instância de Sistema persistida pelo identificador do sistema.
	 * 
	 * @param sistemaId Identificador do sistema
	 * @return A instância persistida de sistema
	 * @throws br.com.aliancamedicor.dev.domain.exception.SistemaNaoEncontradoException
	 */
	public Sistema buscar(Long sistemaId) {
		return sistemaRepository.findById(sistemaId)
				.orElseThrow(() -> new SistemaNaoEncontradoException(sistemaId));
	}
	
	/**
	 * Lista todas as instâncias de Sistema persistidas
	 * @return Lista de Sitemas persistidos
	 */
	public List<Sistema> listar() {
		//return sistemaRepository.findAll();
		return sistemaRepository.findAll();
	}
	
	
	/**
	 * Persiste uma instância de sistema
	 * 
	 * @param sistema Instância do sistema
	 * @return Instância persistida
	 */
	@Transactional
	private Sistema grava(Sistema sistema) {
		return sistemaRepository.save(sistema);
	}
	
	
	/**
	 * Realiza o disassembler do input de dados de sistema (modelo de representação) em uma entidade (modelo de dominio) e persiste
	 * @param sistemaInput Modelo de representação de imput de Sistema
	 * @return instância de sistema (modelo de domínio) persistido
	 */
	@Transactional
	public Sistema cria(SistemaInput sistemaInput) {
		Sistema sistema = sistemaInputDisassembler.toDomainModel(sistemaInput);
		sistema = grava(sistema);
		
		return sistema;
	}
	
	/**
	 * Realiza o disassembler do input de dados de sistema (modelo de representação) em uma entidade (modelo de dominio) e persiste os dados alterados
	 * @param sistemaInput Modelo de representação de imput de Sistema
	 * @return instância de sistema (modelo de domínio) persistido
	 * @throws br.com.aliancamedicor.dev.domain.exception.SistemaNaoEncontradoException
	 */
	@Transactional
	public Sistema altera(Long sistemaId, SistemaInput sistemaInput) {
		Sistema sistema = buscar(sistemaId);
		sistemaInputDisassembler.toDomainModel(sistemaInput, sistema);
		return sistema;
	}
	
	/**
	 * Associa uma instância de pessoa a uma instância de Sistema
	 * 
	 * @param sistemaId Identificador do Sistema
	 * @param pessoaId Identificador da Pessoa
	 * @throws br.com.aliancamedicor.dev.domain.exception.SistemaNaoEncontradoException
	 * @throws br.com.aliancamedicor.dev.domain.exception.PessoaNaoEncontradaException
	 */
	@Transactional
	public void associaPessoa(Long sistemaId, Long pessoaId) {
		Sistema sistema = buscar(sistemaId);
		Pessoa pessoa = pessoaService.buscar(pessoaId);
		
		sistema.associaPessoa(pessoa);
	}
	
	/**
	 * Desassocia uma instância de pessoa de uma instância de Sistema
	 * 
	 * @param sistemaId Identificador do Sistema
	 * @param pessoaId Identificador da Pessoa
	 * @throws br.com.aliancamedicor.dev.domain.exception.SistemaNaoEncontradoException
	 * @throws br.com.aliancamedicor.dev.domain.exception.PessoaNaoEncontradaException
	 */
	@Transactional
	public void desassociaPessoa(Long sistemaId, Long pessoaId) {
		Sistema sistema = buscar(sistemaId);
		Pessoa pessoa = pessoaService.buscar(pessoaId);
		
		sistema.desassociaPessoa(pessoa);
	}

}

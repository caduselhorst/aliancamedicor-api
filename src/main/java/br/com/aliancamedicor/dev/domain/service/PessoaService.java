package br.com.aliancamedicor.dev.domain.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aliancamedicor.dev.api.assembler.EnderecoInputDisassembler;
import br.com.aliancamedicor.dev.api.assembler.PessoaInputDisassembler;
import br.com.aliancamedicor.dev.api.assembler.RedeSocialInputDisassembler;
import br.com.aliancamedicor.dev.api.model.input.PessoaInput;
import br.com.aliancamedicor.dev.domain.exception.EntidadeEmUsoException;
import br.com.aliancamedicor.dev.domain.exception.NegocioException;
import br.com.aliancamedicor.dev.domain.exception.PessoaNaoEncontradaException;
import br.com.aliancamedicor.dev.domain.model.CBOOcupacao;
import br.com.aliancamedicor.dev.domain.model.Pessoa;
import br.com.aliancamedicor.dev.domain.model.PessoaLog;
import br.com.aliancamedicor.dev.domain.model.Profissao;
import br.com.aliancamedicor.dev.domain.model.RedeSocial;
import br.com.aliancamedicor.dev.domain.model.TipoPessoa;
import br.com.aliancamedicor.dev.domain.repository.CBOOcupacaoRepository;
import br.com.aliancamedicor.dev.domain.repository.PessoaLogRepository;
import br.com.aliancamedicor.dev.domain.repository.PessoaRepository;
import br.com.aliancamedicor.dev.domain.repository.RedeSocialRepository;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

/**
 * Classe responsável por realizar as operações CRUD para a entidade {@link br.com.aliancamedicor.dev.domain.model.Sistema}
 * 
 * @author carlos
 *
 */
@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private CBOOcupacaoRepository cboOcupacaoRepository;
	@Autowired
	private RedeSocialRepository redeSocialRepository;
	@Autowired
	private PessoaLogRepository pessoaLogRepository;
		
	@Autowired
	private PessoaInputDisassembler pessoaInputDisassembler;
	@Autowired
	private EnderecoInputDisassembler enderecoInpuDisassembler;
	@Autowired
	private RedeSocialInputDisassembler redeSocialInputDisassembler;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Pessoa buscar(Long pessoaId) {
		
		return pessoaRepository.findById(pessoaId)
				.orElseThrow(() -> new PessoaNaoEncontradaException(String.format("Pessoa com código %d não foi encontrada", pessoaId)));
		
	}
	
	private boolean validaDocumentoPessoa(Pessoa pessoa) {
		
		if(pessoa.getTipoPessoa().equals(TipoPessoa.CPF)) {
			// validação do CPF
			CPFValidator validator = new CPFValidator(false);
			if(!validator.invalidMessagesFor(pessoa.getCpfCnpj()).isEmpty()) {
				throw new NegocioException("O documento informado não é um CPF bem formado");
			}
		} else {
			// validação do CNPJ
			CNPJValidator validator = new CNPJValidator(false);
			if(!validator.invalidMessagesFor(pessoa.getCpfCnpj()).isEmpty()) {
				throw new NegocioException("O documento informado não é um CNPJ bem formado");
			}
		}
		
		return true;
	}
	
	
	@Transactional
	public Pessoa gravaPessoa(PessoaInput pessoaInput, Pessoa pessoa) {
		
		try {
			pessoaInputDisassembler.toDomainModel(pessoaInput, pessoa);
			
			validaDocumentoPessoa(pessoa);
			
			RedeSocial redeSocial;
			
			if(pessoaInput.getRedeSocial() != null) {
				
				if(pessoa.getRedeSocial() != null) {
					
					redeSocial = pessoa.getRedeSocial();
					redeSocialInputDisassembler.toDomainModel(pessoaInput.getRedeSocial(), redeSocial);
					
					redeSocialRepository.save(redeSocial);
					
				} else {
					redeSocial = redeSocialInputDisassembler.toDomainModel(pessoaInput.getRedeSocial());
					
					redeSocial = redeSocialRepository.save(redeSocial);
					redeSocialRepository.flush();
					
					pessoa.setRedeSocial(redeSocial);
				}
				
					
			}
			
			if(pessoa.getEnderecos() == null) {
				pessoa.setEnderecos(new ArrayList<>());			
			}
			
			if(pessoa.getProfissoes() == null) {
				pessoa.setProfissoes(new ArrayList<>());
			}
			
			
			pessoa.getEnderecos().add(enderecoInpuDisassembler.toDomainModel(pessoaInput.getEndereco()));
			
			CBOOcupacao ocupacao = cboOcupacaoRepository.getById(pessoaInput.getProfissao().getCodOcupacao());
			
			Profissao profissao = new Profissao();
			profissao.setOcupacao(ocupacao);
			
			pessoa.getProfissoes().add(profissao);
			
			validarContatos(pessoa);
			validarEnderecos(pessoa);
			validarProfissoes(pessoa);
			
			pessoa = pessoaRepository.save(pessoa);
			pessoaRepository.flush();
							
			return pessoa;
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Documento informado já cadastrado");
		}
		
	}
	
	@Transactional
	public Pessoa alteraPessoa(Long pessoaId, PessoaInput input) {
		
		Pessoa pessoa = buscar(pessoaId);
		
		PessoaLog pessoaLog = modelMapper.map(pessoa, PessoaLog.class);
		pessoaLogRepository.save(pessoaLog);
		
		return gravaPessoa(input, pessoa);
		
	}
	
	private void validarContatos(Pessoa pessoa) {
		pessoa.getContatos().forEach(contato -> {
			contato.setPessoa(pessoa);
		});
	}
	
	private void validarEnderecos(Pessoa pessoa ) {
		pessoa.getEnderecos().forEach(endereco -> {
			endereco.setPessoa(pessoa);
		});
	}
	
	private void validarProfissoes(Pessoa pessoa) {
		pessoa.getProfissoes().forEach(profissao -> {
			profissao.setPessoa(pessoa);
		});
	}

	
}

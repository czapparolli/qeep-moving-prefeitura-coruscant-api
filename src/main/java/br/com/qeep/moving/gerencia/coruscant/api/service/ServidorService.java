package br.com.qeep.moving.gerencia.coruscant.api.service;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
import br.com.qeep.moving.gerencia.coruscant.api.exception.ErroDeNegocioException;
import br.com.qeep.moving.gerencia.coruscant.api.repository.SecretariaRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ServidorRepository;
import br.com.qeep.moving.gerencia.coruscant.api.*;
import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaServidorDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.ResponseDTO;

@Service
public class ServidorService {

	@Autowired
	ServidorRepository servidorRepository;
	@Autowired
	SecretariaRepository secretariaRepository;
	
	public Servidor criaServidor(long idSecretaria, CriaServidorDTO criaServidor) throws ErroDeNegocioException {
		
		Optional<Secretaria> secretariaOpt = secretariaRepository.findById(idSecretaria);
		
		if (secretariaOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao criar servidor: Secretaria não existe.");
		}
		
		Secretaria secretaria = secretariaOpt.get();
		
		double orcamentoAtual = secretaria.getOrcamentoFolha();
		double salarioServidor = criaServidor.getSalario();
		
		if (orcamentoAtual < salarioServidor) {
			throw new ErroDeNegocioException("Erro ao criar servidor: Não há orçamento para contratar o servidor.");
		}
		
		Servidor servidor = criaServidor.toEntity();
		servidor.setSecretaria(secretaria);

		secretaria.setOrcamentoFolha(orcamentoAtual - salarioServidor);
		secretariaRepository.save(secretaria);
		
		return servidorRepository.save(servidor);
	}
	
	public List<Servidor> listaServidores(long idSecretaria) {
		
		return servidorRepository.findAllBySecretariaIdSecretaria(idSecretaria);
		
	}
	
	public Servidor consultaServidor(long idSecretaria, long idServidor) throws ErroDeNegocioException {
		
		Optional<Servidor> servidorOpt = servidorRepository.findByIdServidorAndSecretariaIdSecretaria(idServidor, idSecretaria);
		
		if (servidorOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao consultar servidor: Servidor não encontrado.");
		}
		
		return servidorOpt.get();
	}
	
	public ResponseDTO removeServidor(long idSecretaria, long idServidor) throws ErroDeNegocioException {
		
		Optional<Servidor> servidorOpt = servidorRepository.findByIdServidorAndSecretariaIdSecretaria(idServidor, idSecretaria);
		
		if (servidorOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao remover servidor: Servidor não encontrado.");
		}
		
		Optional<Secretaria> secretariaOpt = secretariaRepository.findById(idSecretaria);
		
		if (secretariaOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao remover servidor: Secretaria não encontrada.");
		}
		
		Secretaria secretaria = secretariaOpt.get();
		secretaria.setOrcamentoFolha(secretaria.getOrcamentoFolha() + servidorOpt.get().getSalario());
		
		secretariaRepository.save(secretaria);
		servidorRepository.deleteById(idServidor);
		
		
		return new ResponseDTO("Servidor foi removido com sucesso!");
	}
}
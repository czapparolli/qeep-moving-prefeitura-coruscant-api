package br.com.qeep.moving.gerencia.coruscant.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qeep.moving.gerencia.coruscant.api.dto.AumentoDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaSecretariaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.ResponseDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.SecretariaCriadaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.exception.ErroDeNegocioException;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ProjetoRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.SecretariaRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ServidorRepository;

@Service
public class SecretariaService {

	@Autowired
	SecretariaRepository secretariaRepository;

	@Autowired
	ProjetoRepository projetoRepository;
	
	@Autowired
	ServidorRepository servidorRepository;

	
	public SecretariaCriadaDTO criaSecretaria(CriaSecretariaDTO criaSecretaria) throws ErroDeNegocioException {
		
		if (secretariaRepository.findFirstByPasta(criaSecretaria.getPasta()) != null) {
			throw new ErroDeNegocioException("Erro ao criar uma secretaria: Já existe uma secretaria com essa pasta!");
		}
		
		Secretaria secretaria = secretariaRepository.save(criaSecretaria.toEntity());
		
		return new SecretariaCriadaDTO(secretaria.getIdSecretaria(), secretaria.getNome(), 
				"Secretaria de " + secretaria.getPasta().getValor() + " criada com sucesso!" );
	}
	
	public List<Secretaria> listarSecretarias() {
		return (List<Secretaria>) secretariaRepository.findAll();
	}
	
	public Secretaria consultaSecretaria(Long idSecretaria) throws ErroDeNegocioException {
		
		if (!secretariaRepository.existsById(idSecretaria)) {
			throw new ErroDeNegocioException("A secretaria não existe!");
		}
		
		return secretariaRepository.findById(idSecretaria).get();
	}
	
	public ResponseDTO removeSecretaria(Long idSecretaria) throws ErroDeNegocioException {
		
		if (!secretariaRepository.existsById(idSecretaria)) {
			throw new ErroDeNegocioException("A secretaria não existe!");
		}
		
		secretariaRepository.deleteById(idSecretaria);
		
		return new ResponseDTO("A secretaria foi removida com sucesso!");
	}
	
	public ResponseDTO folhaDePagamento(Long idSecretaria) {
		
		Double somaFolha = servidorRepository.calculaFolhaPagamento(idSecretaria);
		
		return new ResponseDTO("Hoje a folha de pagamento da prefeitura somada tem o valor de R$ " + somaFolha);
	}
	
	public ResponseDTO custoProjetos(Long idSecretaria) {
		Double custoProjeto = (double) projetoRepository.calculaSomaProjetos(idSecretaria);
		
		return new ResponseDTO("A soma dos custos de projeto dessa secretaria é R$ " + custoProjeto);
	}
	
	public ResponseDTO aporteProjeto(Long idSecretaria, AumentoDTO aumentoDto) throws ErroDeNegocioException {
		
		Optional<Secretaria> secretariaOpt = secretariaRepository.findById(idSecretaria);
		
		if (secretariaOpt.isEmpty()) {
			throw new ErroDeNegocioException("A secretaria não existe!");
		}
		
		Secretaria secretaria = secretariaOpt.get();
		
		secretaria.setOrcamentoProjeto(secretaria.getOrcamentoProjeto() + aumentoDto.getValorAumento());
		
		return new ResponseDTO("Aporte realizado com sucesso!");
	}
	
}
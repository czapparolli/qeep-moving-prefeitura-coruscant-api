package br.com.qeep.moving.gerencia.coruscant.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaSecretariaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.SecretariaCriadaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ProjetoRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.SecretariaRepository;

@Service
public class SecretariaService {

	@Autowired
	SecretariaRepository secretariaRepository;

	@Autowired
	ProjetoRepository projetoRepository;

	public Secretaria cadastraSecretaria(Secretaria secretaria) {

		if (secretariaRepository.existsById(secretaria.getIdSecretaria())) {
			return null;
		}

		return secretariaRepository.save(secretaria);
	}

	public List<Secretaria> listaSecretarias() {
		return (List<Secretaria>) secretariaRepository.findAll();
	}

	public Optional<Secretaria> consultaSecretariaPeloId(long idSecretaria) {
		return secretariaRepository.findById(idSecretaria);
	}

	public boolean deletaSecretariaPeloId(long idSecretaria) {
		secretariaRepository.deleteById(idSecretaria);
		return true;

	}

	public float folhaPagamento(long idSecretaria) {

		return secretariaRepository.calculaSalario();

	}

	

}

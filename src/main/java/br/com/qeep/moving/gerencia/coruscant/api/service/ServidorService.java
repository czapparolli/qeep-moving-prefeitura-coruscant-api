package br.com.qeep.moving.gerencia.coruscant.api.service;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
import br.com.qeep.moving.gerencia.coruscant.api.repository.SecretariaRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ServidorRepository;
import br.com.qeep.moving.gerencia.coruscant.api.*;

@Service
public class ServidorService {

	@Autowired
	ServidorRepository servidorRepository;
	@Autowired
	SecretariaRepository secretariaRepository;

	public Servidor cadastraServidor(@Valid Servidor servidor, Secretaria secretaria) {

		if (servidorRepository.existsById(servidor.getIdServidor())) {
			return null;
		}

		secretaria.getIdSecretaria();
		servidor.setSecretaria(secretaria);
		return servidorRepository.save(servidor);
	}

	public List<Servidor> listaServidores() {
		return (List<Servidor>) servidorRepository.findAll();
	}

	public Optional<Servidor> consultaServidorPorId(long idServidor) {
		return servidorRepository.findById(idServidor);
	}

}

package br.com.qeep.moving.gerencia.coruscant.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaServidorDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.ResponseDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
import br.com.qeep.moving.gerencia.coruscant.api.exception.ErroDeNegocioException;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ProjetoRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ServidorRepository;
import br.com.qeep.moving.gerencia.coruscant.api.service.SecretariaService;
import br.com.qeep.moving.gerencia.coruscant.api.service.ServidorService;

@RestController
@RequestMapping(path = "/secretarias/{idSecretaria}/servidores")

public class ServidorController {

	@Autowired
	ServidorService servidorService;
	@Autowired
	ServidorRepository servidorRepository;

	@PostMapping
	public Servidor cadastraServidor(@PathVariable long idSecretaria, @Valid @RequestBody CriaServidorDTO servidor)
			throws ErroDeNegocioException {
		return servidorService.criaServidor(idSecretaria, servidor);
	}

	@GetMapping
	public List<Servidor> listarServidores(@PathVariable long idSecretaria) {
		return servidorService.listaServidores(idSecretaria);
	}

	@GetMapping(path = "/{idServidor}")
	public Servidor consultaServidor(@PathVariable long idSecretaria, @PathVariable long idServidor)
			throws ErroDeNegocioException {
		return servidorService.consultaServidor(idSecretaria, idServidor);
	}

	@DeleteMapping(path = "/{idServidor}")
	public ResponseDTO removeServidor(@PathVariable long idSecretaria, @PathVariable long idServidor)
			throws ErroDeNegocioException {
		return servidorService.removeServidor(idSecretaria, idServidor);
	}
}

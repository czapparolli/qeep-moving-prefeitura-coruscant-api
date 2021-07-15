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

import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
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
	public Servidor cadastraServidor(@Valid @RequestBody Servidor servidor, Secretaria secretaria) {
		return servidorService.cadastraServidor(servidor, secretaria);
	}
	
	//@GetMapping
	
	 // public List<Servidor> listaServidores(@PathVariable long idSecretaria){
	  //return servidorRepository.findAllById(idSecretaria); }
	 
	
	@GetMapping(path = "{/idServidor}")
	public Optional<Servidor> consultaServidorPorId(@PathVariable long idSecretaria, @PathVariable long idServidor){
		return servidorService.consultaServidorPorId(idServidor);
	}
	
	@DeleteMapping(path = "{/idServidor}")
	public void removeServidor (@PathVariable long idSecretaria, @PathVariable long idServidor) {
	}
	
}

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

import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.service.SecretariaService;

@RestController
@RequestMapping("/secretarias")

public class SecretariaController {
	
	@Autowired
	SecretariaService secretariaService;
	
	@PostMapping
	public Secretaria cadastraSecretaria(@Valid @RequestBody Secretaria secretaria) {
		return secretariaService.cadastraSecretaria(secretaria);
	}
	
	@GetMapping
	public List<Secretaria> listaSecretarias() {
		return secretariaService.listaSecretarias();
	}
	
	@GetMapping(path = "/{idSecretaria}")
	public Optional<Secretaria> BuscarSecretariaPeloId(@PathVariable long idSecretaria) {
		return secretariaService.consultaSecretaria(idSecretaria);
	}
	
}

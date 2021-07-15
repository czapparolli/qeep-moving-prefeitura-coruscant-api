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
import br.com.qeep.moving.gerencia.coruscant.api.service.ProjetoService;
import br.com.qeep.moving.gerencia.coruscant.api.service.SecretariaService;
import br.com.qeep.moving.gerencia.coruscant.api.service.ServidorService;

@RestController
@RequestMapping(path = "/secretarias/{idSecretaria}/projetos")

public class ProjetoController {
	
	@Autowired
	ProjetoService projetoService;
	
	@PostMapping
	public Projeto cadastraProjeto(@Valid @RequestBody Projeto projeto, Secretaria secretaria /*usar um DTO*/) {
		return projetoService.cadastraProjeto(projeto, secretaria);
	}
	
	@GetMapping
	public List<Projeto> listaProjetosPorSecretaria(@PathVariable long idSecretaria){
		return projetoService.listaProjetosPorSecretaria(idSecretaria);
	}
	
	
	@GetMapping(path = "{/idProjeto}")
	public List<Projeto> consultaProjetoPorId (@PathVariable long idSecretaria, @PathVariable long idProjeto) {
		return projetoService.consultaProjeto();
	}
	
	@GetMapping(path = "/concluidos")
	public List<Projeto> listaProjetosConcluidos (@PathVariable long idSecretaria) {
		return projetoService.listaProjetoConcluido();
	}
	
	@GetMapping(path = "/execucao")
	public List<Projeto> listaProjetosEmExecucao (@PathVariable long idSecretaria) {
		return projetoService.listaProjetoEmExecucao();
	}
	
	@GetMapping(path = "/conclusao-mes{mes}")
	public void listaPrevisao(@PathVariable long idSecretaria, @PathVariable int mes){
	}
	
	@PutMapping(path = "/{idProjeto}")
	public void finalizaProjeto(@PathVariable long idSecretaria, @PathVariable long idProjeto){
	/*Tratar Boolean Default*/
	}
}

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

import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaProjetoDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
import br.com.qeep.moving.gerencia.coruscant.api.exception.ErroDeNegocioException;
import br.com.qeep.moving.gerencia.coruscant.api.service.ProjetoService;
import br.com.qeep.moving.gerencia.coruscant.api.service.SecretariaService;
import br.com.qeep.moving.gerencia.coruscant.api.service.ServidorService;

@RestController
@RequestMapping(path = "/secretarias/{idSecretaria}/projetos")

public class ProjetoController {
	@Autowired
	ProjetoService projetoService;
	
	@PostMapping
	public Projeto criaProjeto(@PathVariable long idSecretaria, @Valid @RequestBody CriaProjetoDTO projeto) throws ErroDeNegocioException {
		return projetoService.criaProjeto(idSecretaria, projeto);
	}
	
	@GetMapping
	public List<Projeto> listarProjetos(@PathVariable long idSecretaria) {
		return projetoService.listarProjetos(idSecretaria);
	}
	
	@GetMapping(path = "/{idProjeto}")
	public Projeto consultaProjeto(@PathVariable long idSecretaria, @PathVariable long idProjeto) throws ErroDeNegocioException {
		return projetoService.consultaProjeto(idSecretaria, idProjeto);
	}
	
	@GetMapping(path = "/concluidos")
	public List<Projeto> listarProjetosConcluidos(@PathVariable long idSecretaria) {
		return projetoService.listarProjetosConcluidos(idSecretaria);
	}
	
	@GetMapping(path = "/execucao") 
	public List<Projeto> listarProjetosEmExecucao(@PathVariable long idSecretaria) {
		return projetoService.listarProjetosEmExecucao(idSecretaria);
	}
	
	@GetMapping(path = "/conclusao-mes/{mes}")
	public List<Projeto> listarPrevisao(@PathVariable long idSecretaria, @PathVariable int mes) {
		return projetoService.listarProjetosComPrevisao(idSecretaria, mes);
	}
	
	@PutMapping(path = "/{idProjeto}")
	public Projeto concluirProjeto(@PathVariable long idSecretaria, @PathVariable long idProjeto) throws ErroDeNegocioException {
		return projetoService.concluirProjeto(idSecretaria, idProjeto);
	}
	
}
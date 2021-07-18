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

import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaSecretariaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.dto.SecretariaCriadaDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.exception.ErroDeNegocioException;
import br.com.qeep.moving.gerencia.coruscant.api.service.SecretariaService;
import br.com.qeep.moving.gerencia.coruscant.api.service.ProjetoService;

@RestController
@RequestMapping("/secretarias")

public class SecretariaController {

	@Autowired
	SecretariaService secretariaService;

	@Autowired
	ProjetoService projetoService;

	@PostMapping
	public SecretariaCriadaDTO criaSecretaria(@Valid @RequestBody CriaSecretariaDTO criaSecretaria /*receberia o DTO*/ ) throws ErroDeNegocioException {
		return secretariaService.criaSecretaria(criaSecretaria);
	}
	
	@GetMapping
	public List<Secretaria> listarSecretarias() {
		return secretariaService.listarSecretarias();
	}
	
	@GetMapping(path = "/{idSecretaria}")
	public Secretaria consultaSecretaria (@PathVariable long idSecretaria) {
		// classe de servico
		return null;
	}
	
	@DeleteMapping( path ="/{idSecretaria}")
	public void removeSecretaria(@PathVariable long idSecretaria) {
		
	}
	
	@GetMapping(path = "/{idSecretaria}/folha-pagamento")
	public Double calculaFolhaPagamento(@PathVariable long idSecretaria) {
		return null;
	}
	
	@GetMapping(path = "/{idSecretaria}/custo-projeto")
	public Double calculaCustoProjeto(@PathVariable long idSecretaria) {
		return null;
	}
	
	@PutMapping(path = "/{idSecretaria}/aporte-projetos")
	public String realizaAporte(@PathVariable long idSecretaria, @Valid @RequestBody Projeto aumentoDto) {
		return null;
	}

	/*
	 * @PutMapping(path = "/{idSecretaria}/aporte-projetos/{aumento}") public double
	 * realizaAporte(@PathVariable long idSecretaria, @PathVariable double
	 * aumento, @Valid @RequestBody AumentoDTO aumentoDTO) { return
	 * projetoService.aporteProjeto(idSecretaria, aumento); }
	 */

}

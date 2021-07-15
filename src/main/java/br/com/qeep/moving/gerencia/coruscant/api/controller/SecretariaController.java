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
import br.com.qeep.moving.gerencia.coruscant.api.service.ProjetoService;

@RestController
@RequestMapping("/secretarias")

public class SecretariaController {

	@Autowired
	SecretariaService secretariaService;

	@Autowired
	ProjetoService projetoService;

	@PostMapping
	public Secretaria cadastraSecretaria(@Valid @RequestBody Secretaria secretaria /* FazerDTO */) {
		return secretariaService.cadastraSecretaria(secretaria);
	}

	@GetMapping
	public List<Secretaria> listaSecretarias() {
		return secretariaService.listaSecretarias();
	}

	@GetMapping(path = "/{idSecretaria}")
	public Optional<Secretaria> consultaSecretariaPeloId(@PathVariable long idSecretaria) {
		return secretariaService.consultaSecretariaPeloId(idSecretaria);
	}

	@DeleteMapping(path = "/{idSecretaria}")
	public boolean deletaSecretariaPeloId(@PathVariable long idSecretaria) {
		return secretariaService.deletaSecretariaPeloId(idSecretaria);

	}

	@GetMapping(path = "/{idSecretaria}/folha-pagamento")
	public double folhaPagamentoPorProjeto(@PathVariable long idSecretaria) {
		return secretariaService.folhaPagamento(idSecretaria);
	}

	@GetMapping(path = "/{idSecretaria}/custo-projeto")
	public double calculaCustoPorProjeto(@PathVariable long idSecretaria) {
		return projetoService.calculaCustoPorProjeto(idSecretaria);
	}

	/*
	 * @PutMapping(path = "/{idSecretaria}/aporte-projetos/{aumento}") public double
	 * realizaAporte(@PathVariable long idSecretaria, @PathVariable double
	 * aumento, @Valid @RequestBody AumentoDTO aumentoDTO) { return
	 * projetoService.aporteProjeto(idSecretaria, aumento); }
	 */

}

package br.com.qeep.moving.gerencia.coruscant.api.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ProjetoRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.SecretariaRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ServidorRepository;

@Service
public class ProjetoService {
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	public Projeto cadastraProjeto(@Valid Projeto projeto, Secretaria secretaria) {
		
		if (projetoRepository.existsById(projeto.getIdProjeto())) {
			return null;
		}
		secretaria.getIdSecretaria();
		projeto.setSecretaria(secretaria);
		return projetoRepository.save(projeto);
	}

	public List<Projeto> listaProjetosPorSecretaria(long idSecretaria) {
		return projetoRepository.findAllBySecretariaIdSecretaria(idSecretaria);
	}

	public List<Projeto> consultaProjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Projeto> listaProjetoConcluido() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Projeto> listaProjetoEmExecucao() {
		// TODO Auto-generated method stub
		return null;
	}

	public double calculaCustoPorProjeto(long idSecretaria) {
		return projetoRepository.calculaCustoPorProjeto(idSecretaria);
	}

	/*
	 * public double aporteProjeto(long idSecretaria, double aumento) { return
	 * projetoRepository.aporteProjeto(idSecretaria, aumento); }
	 */
}

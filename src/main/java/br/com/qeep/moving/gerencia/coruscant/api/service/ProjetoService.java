package br.com.qeep.moving.gerencia.coruscant.api.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import br.com.qeep.moving.gerencia.coruscant.api.dto.CriaProjetoDTO;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.entity.Servidor;
import br.com.qeep.moving.gerencia.coruscant.api.exception.ErroDeNegocioException;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ProjetoRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.SecretariaRepository;
import br.com.qeep.moving.gerencia.coruscant.api.repository.ServidorRepository;

@Service
public class ProjetoService {
	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	SecretariaRepository secretariaRepository;

	public Projeto criaProjeto(long idSecretaria, CriaProjetoDTO criaProjetoDto) throws ErroDeNegocioException {

		if (criaProjetoDto.getDataPrevistaConclusao().isBefore(LocalDate.now())) {
			throw new ErroDeNegocioException(
					"Erro ao criar um projeto: Data de previsão deve ser depois da data de hoje.");
		}

		Optional<Secretaria> secretariaOpt = secretariaRepository.findById(idSecretaria);

		if (secretariaOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao criar um projeto: Secretaria inexistente.");
		}

		Secretaria secretaria = secretariaOpt.get();

		double orcamentoAtual = secretaria.getOrcamentoProjeto();
		double custoProjeto = criaProjetoDto.getCusto();

		if (custoProjeto > orcamentoAtual) {
			throw new ErroDeNegocioException(
					"Erro ao criar um projeto: Orçamento é insuficiente, solicite um aporte!");
		}

		Projeto projeto = criaProjetoDto.toEntity();

		secretaria.setOrcamentoProjeto(orcamentoAtual - custoProjeto);
		projeto.setSecretaria(secretaria);

		secretariaRepository.save(secretaria);
		return projetoRepository.save(projeto);
	}

	public List<Projeto> listarProjetos(long idSecretaria) {

		return projetoRepository.findAllBySecretariaIdSecretaria(idSecretaria);

	}

	public Projeto consultaProjeto(long idSecretaria, long idProjeto) throws ErroDeNegocioException {

		Optional<Projeto> projetoOpt = projetoRepository.findBySecretariaIdSecretariaAndIdProjeto(idSecretaria, idProjeto);

		if (projetoOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao consultar um projeto: O projeto não existe.");
		}

		return projetoOpt.get();
	}

	public List<Projeto> listarProjetosConcluidos(long idSecretaria) {

		return projetoRepository.findAllBySecretariaIdSecretariaAndConcluido(idSecretaria, true);

	}

	public List<Projeto> listarProjetosEmExecucao(long idSecretaria) {

		return projetoRepository.findAllBySecretariaIdSecretariaAndConcluido(idSecretaria, false);

	}

	public List<Projeto> listarProjetosComPrevisao(long idSecretaria, int mes) {

		
//		return projetoRepo.findAllMes(idSecretaria, mes);
		int anoAtual = LocalDate.now().getYear();

		LocalDate dataInicio = LocalDate.of(anoAtual, mes, 1);
		LocalDate dataFim = LocalDate.of(anoAtual, mes, dataInicio.lengthOfMonth());

		return projetoRepository.findAllBySecretariaIdSecretariaAndDataPrevistaConclusaoBetweenAndConcluido(idSecretaria, dataInicio,
				dataFim, false);
	}

	public Projeto concluirProjeto(long idSecretaria, long idProjeto) throws ErroDeNegocioException {

		java.util.Optional<Projeto> projetoOpt = projetoRepository.findBySecretariaIdSecretariaAndIdProjeto(idSecretaria, idProjeto);

		if (projetoOpt.isEmpty()) {
			throw new ErroDeNegocioException("Erro ao concluir um projeto: O projeto não existe.");
		}

		Projeto projeto = projetoOpt.get();

		if (projeto.isConcluido()) {
			throw new ErroDeNegocioException("Erro ao concluir um projeto: O projeto já foi concluído.");
		}

		projeto.setConcluido(true);
		projeto.setDataConclusao(LocalDate.now());

		return projetoRepository.save(projeto);
	}
}
package br.com.qeep.moving.gerencia.coruscant.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Secretaria;
import br.com.qeep.moving.gerencia.coruscant.api.enums.Pasta;

public class CriaSecretariaDTO {

	@NotBlank
	private String nome;
	
	@NotBlank
	private Pasta pasta;
	
	@NotNull
	private double orcamentoFolha;
	
	@NotNull
	private double orcamentoProjeto;

	private CriaSecretariaDTO(@NotBlank String nome, @NotBlank Pasta pasta, @NotNull double orcamentoFolha,
			@NotNull double orcamentoProjeto) {
		super();
		this.nome = nome;
		this.pasta = pasta;
		this.orcamentoFolha = orcamentoFolha;
		this.orcamentoProjeto = orcamentoProjeto;
	}
	
	//public Secretaria toEntity() {
		//return new Secretaria(this.getNome(), this.getPasta(), this.getOrcamentoFolha(), this.getOrcamentoProjeto());
	//}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public double getOrcamentoFolha() {
		return orcamentoFolha;
	}

	public void setOrcamentoFolha(double orcamentoFolha) {
		this.orcamentoFolha = orcamentoFolha;
	}

	public double getOrcamentoProjeto() {
		return orcamentoProjeto;
	}

	public void setOrcamentoProjeto(double orcamentoProjeto) {
		this.orcamentoProjeto = orcamentoProjeto;
	}
	
		
	
}

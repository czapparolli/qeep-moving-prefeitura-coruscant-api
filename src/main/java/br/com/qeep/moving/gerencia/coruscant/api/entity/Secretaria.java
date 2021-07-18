package br.com.qeep.moving.gerencia.coruscant.api.entity;

import br.com.qeep.moving.gerencia.coruscant.api.enums.*;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Secretaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_secretaria")
	private long idSecretaria;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@Enumerated(EnumType.STRING)
	private Pasta pasta;

	@Column(name = "orcamento_folha", nullable = false)
	private double orcamentoFolha;

	@Column(name = "orcamento_projeto", nullable = false)
	private double orcamentoProjeto;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "secretaria", fetch = FetchType.EAGER)
	private List<Projeto> projetos;
	@JsonManagedReference
	@OneToMany(mappedBy = "secretaria")
	private List<Servidor> servidores;

	private Secretaria(long idSecretaria, String nome, Pasta pasta, float orcamentoFolha, float orcamentoProjeto,
			List<Projeto> projetos, List<Servidor> servidores) {
		super();
		this.idSecretaria = idSecretaria;
		this.nome = nome;
		this.pasta = pasta;
		this.orcamentoFolha = orcamentoFolha;
		this.orcamentoProjeto = orcamentoProjeto;
		this.projetos = projetos;
		this.servidores = servidores;
	}

	public Secretaria(String nome, Pasta pasta, double orcamentoFolha, double orcamentoProjeto) {
		this.nome = nome;
		this.pasta = pasta;
		this.orcamentoFolha = orcamentoFolha;
		this.orcamentoProjeto = orcamentoProjeto;
	}

	public long getIdSecretaria() {
		return idSecretaria;
	}

	public void setIdSecretaria(long idSecretaria) {
		this.idSecretaria = idSecretaria;
	}

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

	public void setOrcamentoProjeto(double d) {
		this.orcamentoProjeto = d;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Servidor> getServidores() {
		return servidores;
	}

	public void setServidores(List<Servidor> servidores) {
		servidores = servidores;
	}

}

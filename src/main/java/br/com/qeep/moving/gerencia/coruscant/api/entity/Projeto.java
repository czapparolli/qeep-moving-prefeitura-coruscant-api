package br.com.qeep.moving.gerencia.coruscant.api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_projeto")
	private long idProjeto;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	private float custo;
	
	//@JsonFormat(pattern = "dd/MM/aaaa")
	@Column(name = "data_prevista_conclusao", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataPrevistaConclusao;
	
	@Column(name = "data_conclusao")
	private LocalDate dataConclusao;

	private boolean concluido;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "secretaria_fk", referencedColumnName = "id_secretaria")
	private Secretaria secretaria;

	private Projeto(long idProjeto, String nome, float custo, LocalDate dataPrevistaConclusao, LocalDate dataConclusao,
			boolean concluido, Secretaria secretaria) {
		super();
		this.idProjeto = idProjeto;
		this.nome = nome;
		this.custo = custo;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataConclusao = dataConclusao;
		this.concluido = concluido;
		this.secretaria = secretaria;
	}
	
	public Projeto () {
		
	}
	
	public long getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public LocalDate getDataPrevistaConclusao() {
		return dataPrevistaConclusao;
	}

	public void setDataPrevistaConclusao(LocalDate dataPrevistaConclusao) {
		this.dataPrevistaConclusao = dataPrevistaConclusao;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	
	
	
	
}

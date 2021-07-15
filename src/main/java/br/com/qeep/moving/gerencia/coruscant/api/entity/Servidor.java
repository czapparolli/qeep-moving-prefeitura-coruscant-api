	package br.com.qeep.moving.gerencia.coruscant.api.entity;

import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servidor")
	private long idServidor;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(unique = true)
	private String cpf;

	@Column(nullable = false)
	private float salario;

	@Column(nullable = false)
	private String cargo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "secretaria_fk",referencedColumnName = "id_secretaria")
	private Secretaria secretaria;

	private Servidor(long idServidor, String nome, String cpf, float salario, String cargo, Secretaria secretaria) {
		super();
		this.idServidor = idServidor;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.cargo = cargo;
		this.secretaria = secretaria;
	}
	
	public Servidor () {
		
	}

	public long getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(long idServidor) {
		this.idServidor = idServidor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	
	
	
	
}

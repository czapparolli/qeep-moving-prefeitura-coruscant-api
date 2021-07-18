package br.com.qeep.moving.gerencia.coruscant.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.qeep.moving.gerencia.coruscant.api.entity.Projeto;


public class CriaProjetoDTO {

	@NotBlank
	private String nome;

	@NotNull
	@Min(value = 1)
	private double custo;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataPrevistaConclusao;

	public CriaProjetoDTO(@NotBlank String nome, @NotNull @Min(1) double custo,
			@NotNull LocalDate dataPrevistaConclusao) {
		super();
		this.nome = nome;
		this.custo = custo;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
	}
	
	public Projeto toEntity() {
		Projeto projeto = new Projeto();
		BeanUtils.copyProperties(this, projeto);
		
		return projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public LocalDate getDataPrevistaConclusao() {
		return dataPrevistaConclusao;
	}

	public void setDataPrevistaConclusao(LocalDate dataPrevistaConclusao) {
		this.dataPrevistaConclusao = dataPrevistaConclusao;
	}
	
}
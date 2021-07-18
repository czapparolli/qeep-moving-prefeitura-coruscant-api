package br.com.qeep.moving.gerencia.coruscant.api.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AumentoDTO {

	@NotNull
	@Min(value = 1)
	@Max(value = 50000)
	private double valorAumento;

	public AumentoDTO(double valorAumento) {
		super();
		this.valorAumento = valorAumento;
	}

	public double getValorAumento() {
		return valorAumento;
	}

	public void setValorAumento(double valorAumento) {
		this.valorAumento = valorAumento;
	}
	
}

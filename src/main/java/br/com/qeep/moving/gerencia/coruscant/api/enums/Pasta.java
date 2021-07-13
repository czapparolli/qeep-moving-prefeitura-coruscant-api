package br.com.qeep.moving.gerencia.coruscant.api.enums;

public enum Pasta {	
	
	SAUDE ("SAUDE"), EDUCACAO("EDUCACAO"), SEGURANCA("SEGURANCA");
	
	private String valor;

	private Pasta(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
}	

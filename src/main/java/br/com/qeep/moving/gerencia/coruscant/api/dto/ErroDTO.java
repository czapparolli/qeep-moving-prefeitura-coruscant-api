package br.com.qeep.moving.gerencia.coruscant.api.dto;

public class ErroDTO {

	private String mensagemDeErro;

	public ErroDTO(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}

	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

	public void setMensagemDeErro(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}

}
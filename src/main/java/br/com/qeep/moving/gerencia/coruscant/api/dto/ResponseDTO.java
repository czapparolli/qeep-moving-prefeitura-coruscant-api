package br.com.qeep.moving.gerencia.coruscant.api.dto;

public class ResponseDTO {

	private String resposta;

	public ResponseDTO(String resposta) {
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
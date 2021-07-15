package br.com.qeep.moving.gerencia.coruscant.api.exception;

public class ErroDeNegocioException extends Exception {
	
	private static final long serialVersionUID = 4929529810224174835L;
	
	public ErroDeNegocioException(String message) {
        super(message);
    }
	
}

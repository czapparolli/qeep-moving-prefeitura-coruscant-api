package br.com.qeep.moving.gerencia.coruscant.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.qeep.moving.gerencia.coruscant.api.dto.ErroDTO;

//@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final int POSICAO_ERRO = 0;
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler({ErroDeNegocioException.class})
	public ErroDTO handlerErroDeNegocio(ErroDeNegocioException e) {
		return new ErroDTO(e.getMessage());
	}
	
	
}

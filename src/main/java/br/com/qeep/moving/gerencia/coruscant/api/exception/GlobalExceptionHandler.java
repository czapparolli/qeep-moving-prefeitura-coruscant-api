package br.com.qeep.moving.gerencia.coruscant.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.qeep.moving.gerencia.coruscant.api.dto.ErroDTO;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final int POSICAO_ERRO = 0;

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler({ErroDeNegocioException.class})
	public @ResponseBody ErroDTO handleErroDeNegocio(ErroDeNegocioException e) {
		return new ErroDTO(e.getMessage());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public @ResponseBody List<ErroDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		List<ErroDTO> resposta = new ArrayList<ErroDTO>();

		for (ObjectError erro : e.getBindingResult().getAllErrors()) {

			String erroInteiro = erro.getCodes()[POSICAO_ERRO];
			String nomeCampo = erroInteiro.substring(erroInteiro.lastIndexOf(".") + 1, erroInteiro.length());
			
			resposta.add(new ErroDTO(nomeCampo + " " + erro.getDefaultMessage()));
		}
		
		return resposta;
	}
	
}
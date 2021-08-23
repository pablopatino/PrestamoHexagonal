package com.example.bibliotecaHexa.demo.infrastructura.controlador.error;


import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionNotFound;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionTipoUsuarioNoIdentico;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;

@ControllerAdvice
public class ControladorException {
	
	private static final ConcurrentHashMap<String, Integer> CODIGO_ESTADO = new ConcurrentHashMap<>();
	

	public ControladorException() {
		CODIGO_ESTADO.put(ExcepcionNotFound.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
		CODIGO_ESTADO.put(ExcepcionValorObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGO_ESTADO.put(ExcepcionTipoUsuarioNoIdentico.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}

//	@ExceptionHandler(ExcepcionValorObligatorio.class)
//	public ResponseEntity<?> valorObligatorio(Exception exception){
//		HashMap<String, Object> error = new HashMap<>();
//		error.put("mensaje", exception.getMessage());
//		return new ResponseEntity<Map<String, Object>>(error, HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler(ExcepcionNotFound.class)
//	public ResponseEntity<?> notFound(Exception exception){
//		HashMap<String, Object> error = new HashMap<>();
//		error.put("mensaje", exception.getMessage());
//		return new ResponseEntity<Map<String, Object>>(error, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> allExceptions(Exception exception){
		ResponseEntity<Error> resultado;
		
		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGO_ESTADO.get(excepcionNombre);
		
		if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
            Error error = new Error(excepcionNombre, "Internal server Error");
            
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
		
		return resultado;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void constraitValidation(HttpServletResponse response) throws IOException{
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	

}

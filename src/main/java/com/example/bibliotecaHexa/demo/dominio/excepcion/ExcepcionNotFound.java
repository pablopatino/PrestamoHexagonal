package com.example.bibliotecaHexa.demo.dominio.excepcion;

public class ExcepcionNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNotFound() {
		
	}

	public ExcepcionNotFound(String message) {
		super(message);
	}

}

package com.example.bibliotecaHexa.demo.dominio.excepcion;

public class ExcepcionValorObligatorio extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionValorObligatorio () {
	}

	public ExcepcionValorObligatorio(String mensaje) {
		super(mensaje);
	}
	
}

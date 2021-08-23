package com.example.bibliotecaHexa.demo.dominio.excepcion;

public class ExcepcionTipoUsuarioNoIdentico extends RuntimeException {

	public ExcepcionTipoUsuarioNoIdentico() {
	}

	public ExcepcionTipoUsuarioNoIdentico(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}

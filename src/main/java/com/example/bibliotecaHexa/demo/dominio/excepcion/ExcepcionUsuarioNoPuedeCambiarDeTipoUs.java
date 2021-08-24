package com.example.bibliotecaHexa.demo.dominio.excepcion;

public class ExcepcionUsuarioNoPuedeCambiarDeTipoUs extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionUsuarioNoPuedeCambiarDeTipoUs () {
	}

	public ExcepcionUsuarioNoPuedeCambiarDeTipoUs(String mensaje) {
		super(mensaje);
	}
	
}

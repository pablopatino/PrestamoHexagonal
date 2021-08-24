package com.example.bibliotecaHexa.demo.dominio.dto;

import java.io.Serializable;

public class MensajeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public MensajeDTO(String mensaje) {
		this.mensaje = mensaje;
	}

}

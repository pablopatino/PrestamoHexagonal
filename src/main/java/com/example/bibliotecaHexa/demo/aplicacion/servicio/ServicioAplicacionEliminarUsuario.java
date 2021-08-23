package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.servicio.ServicioGuardarUsuario;

@Component
public class ServicioAplicacionEliminarUsuario {

	private final ServicioGuardarUsuario servicioGuardarUsuario;

	public ServicioAplicacionEliminarUsuario(ServicioGuardarUsuario servicioGuardarUsuario) {
		this.servicioGuardarUsuario = servicioGuardarUsuario;
	}

	public void ejecutar(String id) {
		this.servicioGuardarUsuario.eliminarUsuarioYPrestamos(id);
	}

}

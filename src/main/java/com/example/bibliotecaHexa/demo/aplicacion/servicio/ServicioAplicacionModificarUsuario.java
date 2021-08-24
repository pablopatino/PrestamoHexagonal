package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;
import com.example.bibliotecaHexa.demo.dominio.servicio.ServicioGuardarUsuario;

@Component
public class ServicioAplicacionModificarUsuario {

	private final ServicioGuardarUsuario servicioGuardarUsuario;

	public ServicioAplicacionModificarUsuario(ServicioGuardarUsuario servicioGuardarUsuario) {
		this.servicioGuardarUsuario = servicioGuardarUsuario;
	}
	
	public ResponseEntity<?> ejecutar(Usuario usuario){
		return this.servicioGuardarUsuario.modificarUsuario(usuario);
	}
	
	
}

package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;
import com.example.bibliotecaHexa.demo.dominio.servicio.ServicioGuardarUsuario;

@Component
public class ServicioaplicacionGuardarUsuario {

	private final ServicioGuardarUsuario servicioGuardarPrestamo;

	public ServicioaplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarPrestamo) {
		this.servicioGuardarPrestamo = servicioGuardarPrestamo;
	}
	
	public ResponseEntity<?> ejecutar(Usuario usuario){
		return this.servicioGuardarPrestamo.crearPrestamo(usuario);
	}
	
	public ResponseEntity<?> ejecutar2(Long id){
		return this.servicioGuardarPrestamo.mirarDto(id);
	}
	
	
}

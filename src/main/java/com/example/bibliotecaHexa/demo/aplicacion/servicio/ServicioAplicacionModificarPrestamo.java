package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.servicio.ServicioModificarUsuario;

@Component
public class ServicioAplicacionModificarPrestamo {

	private final ServicioModificarUsuario servicioModificarUsuario;

	public ServicioAplicacionModificarPrestamo(ServicioModificarUsuario servicioModificarUsuario) {
		this.servicioModificarUsuario = servicioModificarUsuario;
	}
	
	public ResponseEntity<?> ejecutar(Prestamo prestamo, String id) {
		return this.servicioModificarUsuario.modificarPrestamo(prestamo, id);
	}
	
}

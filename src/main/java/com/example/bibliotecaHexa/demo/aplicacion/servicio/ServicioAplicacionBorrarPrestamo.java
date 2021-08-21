package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.servicio.ServicioEliminarPrestamo;

@Component
public class ServicioAplicacionBorrarPrestamo {

	private final ServicioEliminarPrestamo servicioEliminarPrestamo;

	public ServicioAplicacionBorrarPrestamo(ServicioEliminarPrestamo servicioEliminarPrestamo) {
		this.servicioEliminarPrestamo = servicioEliminarPrestamo;
	}
	
	public void ejecutar(String idUsuario) {
		this.servicioEliminarPrestamo.eliminarPrestamo(idUsuario);
	}
	
}

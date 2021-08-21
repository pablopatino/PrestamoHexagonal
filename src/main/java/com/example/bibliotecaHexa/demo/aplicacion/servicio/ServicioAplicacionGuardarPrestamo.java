package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.servicio.ServicioGuardarPrestamo;

@Component
public class ServicioAplicacionGuardarPrestamo {
	
	private final ServicioGuardarPrestamo servicioGuardarPrestamo;

	public ServicioAplicacionGuardarPrestamo(ServicioGuardarPrestamo servicioGuardarPrestamo) {
		this.servicioGuardarPrestamo = servicioGuardarPrestamo;
	}
	
	public ResponseEntity<?> ejecutar(Prestamo prestamo) {
		return this.servicioGuardarPrestamo.crearPrestamo(prestamo);
	}
	
}

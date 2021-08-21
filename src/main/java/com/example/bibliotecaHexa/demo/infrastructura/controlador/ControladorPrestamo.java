package com.example.bibliotecaHexa.demo.infrastructura.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioAplicacionBorrarPrestamo;
import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioAplicacionBuscarUsuarioPorId;
import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioAplicacionGuardarPrestamo;
import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioAplicacionModificarPrestamo;
import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;

@RestController
@RequestMapping
public class ControladorPrestamo {

	private final ServicioAplicacionGuardarPrestamo servicioAplicacionGuardarPrestamo;
	private final ServicioAplicacionBuscarUsuarioPorId aplicacionBuscarUsuarioPorId;
	private final ServicioAplicacionModificarPrestamo servicioAplicacionModificarPrestamo;
	private final ServicioAplicacionBorrarPrestamo servicioAplicacionBorrarPrestamo;


	public ControladorPrestamo(ServicioAplicacionGuardarPrestamo servicioAplicacionGuardarPrestamo,
			ServicioAplicacionBuscarUsuarioPorId aplicacionBuscarUsuarioPorId,
			ServicioAplicacionModificarPrestamo servicioAplicacionModificarPrestamo,
			ServicioAplicacionBorrarPrestamo servicioAplicacionBorrarPrestamo) {
		super();
		this.servicioAplicacionGuardarPrestamo = servicioAplicacionGuardarPrestamo;
		this.aplicacionBuscarUsuarioPorId = aplicacionBuscarUsuarioPorId;
		this.servicioAplicacionModificarPrestamo = servicioAplicacionModificarPrestamo;
		this.servicioAplicacionBorrarPrestamo = servicioAplicacionBorrarPrestamo;
	}

	@PostMapping("/prestamo/")
	public ResponseEntity<?> crearPrestamo(@RequestBody Prestamo prestamo) {
		return this.servicioAplicacionGuardarPrestamo.ejecutar(prestamo);
	}

	@GetMapping("/prestamo/{id-prestamo}")
	public Prestamo buscarPrestamo(@PathVariable(name = "id-prestamo") int id) {
		return this.aplicacionBuscarUsuarioPorId.ejecutar(id);
	}

	@PutMapping("/prestamo/{idUsuario}")
	public ResponseEntity<?> modificarPrestamo(@RequestBody Prestamo prestamo, @PathVariable String idUsuario) {
		return this.servicioAplicacionModificarPrestamo.ejecutar(prestamo, idUsuario);
	}
	
	@DeleteMapping("/prestamo/{idUsuario}")
	public void eliminarPrestamo(@PathVariable(required = true) String idUsuario) {
		this.servicioAplicacionBorrarPrestamo.ejecutar(idUsuario);
	}
}

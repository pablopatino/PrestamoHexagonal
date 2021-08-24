package com.example.bibliotecaHexa.demo.infrastructura.controlador;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioAplicacionEliminarUsuario;
import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioAplicacionModificarUsuario;
import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioaplicacionGuardarUsuario;
import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;

@RestController
@Validated
@RequestMapping("/usuario")
public class ControladorUsuario {

	private final ServicioaplicacionGuardarUsuario servicioaplicacionGuardarUsuario;
	private final ServicioAplicacionEliminarUsuario servicioAplicacionEliminarUsuario;
	private final ServicioAplicacionModificarUsuario servicioAplicacionModificarUsuario;

	public ControladorUsuario(ServicioaplicacionGuardarUsuario servicioaplicacionGuardarUsuario,
			ServicioAplicacionEliminarUsuario servicioAplicacionEliminarUsuario,
			ServicioAplicacionModificarUsuario servicioAplicacionModificarUsuario) {
		this.servicioaplicacionGuardarUsuario = servicioaplicacionGuardarUsuario;
		this.servicioAplicacionEliminarUsuario = servicioAplicacionEliminarUsuario;
		this.servicioAplicacionModificarUsuario = servicioAplicacionModificarUsuario;
	}

	@PostMapping("")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
		return this.servicioaplicacionGuardarUsuario.ejecutar(usuario);
	}

	@GetMapping("/{id-prestamo}")
	public ResponseEntity<?> buscarPrestamo(@PathVariable(name = "id-prestamo") Long id) {
		return this.servicioaplicacionGuardarUsuario.ejecutar2(id);
	}

	@DeleteMapping("/{idUsuario}")
	public void eliminarUsuario(@PathVariable(required = true) String idUsuario) {
		this.servicioAplicacionEliminarUsuario.ejecutar(idUsuario);
	}

	@PutMapping("/{idUsuario}")
	public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario) {
		return this.servicioAplicacionModificarUsuario.ejecutar(usuario);
	}

}

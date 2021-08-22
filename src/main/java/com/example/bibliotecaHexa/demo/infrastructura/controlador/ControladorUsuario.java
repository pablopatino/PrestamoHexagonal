package com.example.bibliotecaHexa.demo.infrastructura.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaHexa.demo.aplicacion.servicio.ServicioaplicacionGuardarUsuario;
import com.example.bibliotecaHexa.demo.dominio.dto.PrestamoDTO;
import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
	
	private final ServicioaplicacionGuardarUsuario servicioaplicacionGuardarUsuario;

	public ControladorUsuario(ServicioaplicacionGuardarUsuario servicioaplicacionGuardarUsuario) {
		this.servicioaplicacionGuardarUsuario = servicioaplicacionGuardarUsuario;
	}

	@PostMapping("")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		return this.servicioaplicacionGuardarUsuario.ejecutar(usuario);
	}
	
	@GetMapping("/{id-prestamo}")
	public ResponseEntity<?> buscarPrestamo(@PathVariable(name = "id-prestamo") Long id) {
		return this.servicioaplicacionGuardarUsuario.ejecutar2(id);
	}
	
	
}

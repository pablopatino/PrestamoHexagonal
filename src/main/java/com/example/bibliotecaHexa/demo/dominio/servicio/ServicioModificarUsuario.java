package com.example.bibliotecaHexa.demo.dominio.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionNotFound;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;
import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioPrestamo;

@Service
public class ServicioModificarUsuario {

	private final RepositorioPrestamo repositorioPrestamo;

	public ServicioModificarUsuario(RepositorioPrestamo repositorioPrestamo) {
		this.repositorioPrestamo = repositorioPrestamo;
	}
	
	public ResponseEntity<?> modificarPrestamo(Prestamo prestamo, String id) {
		validarCamposDelPrestamo(prestamo);
		Prestamo prestamoBaseDeDatos = validarBaseDeDatos(id);
		prestamoBaseDeDatos.setTipoUsuario(prestamo.getTipoUsuario());
		this.repositorioPrestamo.save(prestamoBaseDeDatos);
		return ResponseEntity.status(HttpStatus.OK).body("Usuario Modificado Correctamente");
	}
	
	private void validarCamposDelPrestamo(Prestamo prestamo){
		int tipoUsuario = prestamo.getTipoUsuario();
		if (prestamo.getIdentificacionUsuario() == null || tipoUsuario <= 0 || tipoUsuario >= 4) {
			throw new ExcepcionValorObligatorio("Los Campos son obligatorios");
		}		
	}
	
	private Prestamo validarBaseDeDatos(String id) {
		Prestamo prestamoBaseDeDatos = this.repositorioPrestamo.buscarPrestamoPorIdentificacion(id);
		if (prestamoBaseDeDatos == null) {
			throw new ExcepcionNotFound("Usuario no se encuentra");
		}
		return prestamoBaseDeDatos;
		
	}
	
}

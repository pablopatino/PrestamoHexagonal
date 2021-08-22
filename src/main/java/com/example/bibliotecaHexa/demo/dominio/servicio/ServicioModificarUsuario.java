package com.example.bibliotecaHexa.demo.dominio.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bibliotecaHexa.demo.dominio.dto.PrestamoDTO;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionNotFound;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioPrestamo;

@Service
public class ServicioModificarUsuario {
	
	private static final String USUARIO_MODIFICADO_CORRECTAMENTE = "Usuario Modificado Correctamente";
	private static final String CAMPOS_OBLIGATORIOS = "Los Campos son obligatorios";
	private static final String USUARIO_NO_ENCONTRADO = "Usuario no se encuentra";

	private final RepositorioPrestamo repositorioPrestamo;

	public ServicioModificarUsuario(RepositorioPrestamo repositorioPrestamo) {
		this.repositorioPrestamo = repositorioPrestamo;
	}
	
//	public ResponseEntity<?> modificarPrestamo(PrestamoDTO prestamo, String id) {
//		validarCamposDelPrestamo(prestamo);
//		PrestamoDTO prestamoBaseDeDatos = validarBaseDeDatos(id);
//		prestamoBaseDeDatos.setTipoUsuario(prestamo.getTipoUsuario());
//		this.repositorioPrestamo.save(prestamoBaseDeDatos);
//		return ResponseEntity.status(HttpStatus.OK).body(USUARIO_MODIFICADO_CORRECTAMENTE);
//	}
//	
//	private void validarCamposDelPrestamo(PrestamoDTO prestamo){
//		int tipoUsuario = prestamo.getTipoUsuario();
//		if (prestamo.getIdentificacionUsuario() == null || tipoUsuario <= 0 || tipoUsuario >= 4) {
//			throw new ExcepcionValorObligatorio(CAMPOS_OBLIGATORIOS);
//		}		
//	}
//	
//	private PrestamoDTO validarBaseDeDatos(String id) {
//		PrestamoDTO prestamoBaseDeDatos = this.repositorioPrestamo.buscarPrestamoPorIdentificacion(id);
//		if (prestamoBaseDeDatos == null) {
//			throw new ExcepcionNotFound(USUARIO_NO_ENCONTRADO);
//		}
//		return prestamoBaseDeDatos;
//		
//	}
	
}

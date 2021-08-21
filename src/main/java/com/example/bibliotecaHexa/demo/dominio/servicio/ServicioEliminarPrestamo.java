package com.example.bibliotecaHexa.demo.dominio.servicio;

import org.springframework.stereotype.Service;

import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;
import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioPrestamo;

@Service
public class ServicioEliminarPrestamo {

	private final RepositorioPrestamo repositorioPrestamo;

	public ServicioEliminarPrestamo(RepositorioPrestamo repositorioPrestamo) {
		this.repositorioPrestamo = repositorioPrestamo;
	}
	
	
	public void eliminarPrestamo(String idUsuario) {
		Prestamo Pb = verificarUsuario(idUsuario);
		this.repositorioPrestamo.delete(Pb);
	}
	
	private Prestamo verificarUsuario(String idUsuario) {
		Prestamo idUsuarioBaseDeDatos = this.repositorioPrestamo.buscarPrestamoPorIdentificacion(idUsuario);
		if (idUsuarioBaseDeDatos == null) {
			throw new ExcepcionValorObligatorio("Usuario no se encuentra");
		}
		return idUsuarioBaseDeDatos;
	}
	
}

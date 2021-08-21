package com.example.bibliotecaHexa.demo.aplicacion.servicio;

import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioPrestamo;

@Component
public class ServicioAplicacionBuscarUsuarioPorId {

	private final RepositorioPrestamo repositorioPrestamo;

	public ServicioAplicacionBuscarUsuarioPorId(RepositorioPrestamo repositorioPrestamo) {
		this.repositorioPrestamo = repositorioPrestamo;
	}
	
	public Prestamo ejecutar(int identificacionUsuario){
		return this.repositorioPrestamo.buscarporId(identificacionUsuario);
	}
	
	
}

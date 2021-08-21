package com.example.bibliotecaHexa.demo.dominio.puerto.repositorio;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;

public interface RepositorioPrestamo extends CrudRepository<Prestamo, String> {

	@Query("SELECT p FROM Prestamo p WHERE p.identificacionUsuario = ?1")
	public Prestamo buscarPrestamoPorIdentificacion(String identificacionUsuario);
	
	
	@Query("SELECT p FROM Prestamo p WHERE p.id = ?1")
	public Prestamo buscarporId(int id);
	
	@Modifying
	@Query("DELETE FROM Prestamo p WHERE p.identificacionUsuario = :identificadorUsuario")
	public void eliminarPrestamoPorIdentificadorUsuario(String identificadorUsuario);
}

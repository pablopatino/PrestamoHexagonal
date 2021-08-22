package com.example.bibliotecaHexa.demo.dominio.puerto.repositorio;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;




public interface RepositorioPrestamo extends CrudRepository<Prestamo, Long> {

	@Query("SELECT p FROM Prestamo p WHERE p.usuario.identificacionUsuario = :identificacionUsuario")
	public Prestamo buscarPrestamoPorIdentificacion(String identificacionUsuario);
//	
//	
//	@Query("SELECT p FROM PrestamoDTO p WHERE p.id = ?1")
//	public Usuario buscarporId(int id);
//	
//	@Modifying
//	@Query("DELETE FROM PrestamoDTO p WHERE p.identificacionUsuario = :identificadorUsuario")
//	public void eliminarPrestamoPorIdentificadorUsuario(String identificadorUsuario);
}

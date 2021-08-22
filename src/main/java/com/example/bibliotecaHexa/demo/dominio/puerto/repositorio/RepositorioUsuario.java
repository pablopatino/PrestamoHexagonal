package com.example.bibliotecaHexa.demo.dominio.puerto.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, String>{

}

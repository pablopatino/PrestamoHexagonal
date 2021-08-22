package com.example.bibliotecaHexa.demo.dominio.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.bibliotecaHexa.demo.dominio.dto.PrestamoDTO;
import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;

@Component
public class Mapper {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public PrestamoDTO maptoEntity(Usuario usuario, Prestamo prestamo) {
		
		PrestamoDTO prestamoDTO = modelMapper().map(usuario, PrestamoDTO.class);
		prestamoDTO.setIsbn(usuario.getIsbn());
		prestamoDTO.setIdentificacionUsuario(usuario.getIdentificacionUsuario());
		prestamoDTO.setFechaDevolucion(prestamo.getFechaMaximaDevolucion());
		prestamoDTO.setId(prestamo.getId());
		prestamoDTO.setTipoUsuario(usuario.getTipoUs());
		
		return prestamoDTO;
	}
}

package com.example.bibliotecaHexa.demo.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bibliotecaHexa.demo.dominio.dto.PrestamoDTO;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionNotFound;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionTipoUsuarioNoIdentico;
import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;
import com.example.bibliotecaHexa.demo.dominio.mapper.Mapper;
import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.modelo.Usuario;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioPrestamo;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioUsuario;

@Service
public class ServicioGuardarUsuario {

	private final RepositorioUsuario repositorioUsuario;
	private final RepositorioPrestamo repositorioPrestamo;
	private final Mapper mapper;

	private final static String NOT_FOUND = "No encontrado";
	private final static String TIPO_USUARIO_REP = "Usuario ya esta registrado con otro TipoUsuario";

	public ServicioGuardarUsuario(RepositorioUsuario repositorioUsuario, RepositorioPrestamo repositorioPrestamo,
			Mapper mapper) {
		this.repositorioUsuario = repositorioUsuario;
		this.repositorioPrestamo = repositorioPrestamo;
		this.mapper = mapper;
	}

	public ResponseEntity<?> crearPrestamo(Usuario usuario) {
		Map<String, Object> resp = new HashMap<>();
		Prestamo prestamo = new Prestamo();

		validarSiUsuarioYaEstaRegistrado(usuario);
		validarSiUsuarioTieneLibroPrestado(usuario);

		prestamo.setFechaMaximaDevolucion(total(usuario.getTipoUs()));
		prestamo.setUsuario(usuario);

		this.repositorioUsuario.save(usuario);
		this.repositorioPrestamo.save(prestamo);

		resp.put("id", prestamo.getId());
		resp.put("fechaMaximaDevolucion", prestamo.getFechaMaximaDevolucion());
		

		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);

	}

	public ResponseEntity<?> devolverPrestamoDto(Long id) {
		return validarPrestamoYUsuario(id);
	}
	
	public void eliminarUsuarioYPrestamos(String id) {
		validarUsuario(id);
		this.repositorioUsuario.deleteById(id);
		
	}
	
	private void validarUsuario(String id) {
		Usuario usuario = this.repositorioUsuario.findById(id).orElse(null);
		if (usuario == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		}
	}
	

	private void validarSiUsuarioYaEstaRegistrado(Usuario usuario) {
		int tipoUsuario = usuario.getTipoUs();
		Usuario usuarioBd = this.repositorioUsuario.findById(usuario.getIdentificacionUsuario()).orElse(null);
		if (usuarioBd == null) {
		
		} else {
			if (tipoUsuario != usuarioBd.getTipoUs()) {
				throw new ExcepcionTipoUsuarioNoIdentico(TIPO_USUARIO_REP);
			}
		}
	}

	private ResponseEntity<?> validarPrestamoYUsuario(Long id) {
		Prestamo prestamoBaseDeDatos = this.repositorioPrestamo.findById(id).orElse(null);
		if (prestamoBaseDeDatos == null) {
			throw new ExcepcionNotFound(NOT_FOUND);
		} else {
			Usuario usuario = this.repositorioUsuario
					.findById(prestamoBaseDeDatos.getUsuario().getIdentificacionUsuario()).orElse(null);
			PrestamoDTO prestamoDTO = this.mapper.maptoEntity(usuario, prestamoBaseDeDatos);
			return ResponseEntity.status(HttpStatus.OK).body(prestamoDTO);

		}
	}

	private void validarSiUsuarioTieneLibroPrestado(Usuario usuario) {
		int invitado = 3;
		if (usuario.getTipoUs() == invitado) {
			Prestamo prestamoBaseDeDatos = this.repositorioPrestamo
					.buscarPrestamoPorIdentificacion(usuario.getIdentificacionUsuario());
			if (prestamoBaseDeDatos != null) {
				throw new ExcepcionValorObligatorio("Usuario ya contiene libro");
			}
		}
	}

	private int calcularIncrementoDias(int tipoUsuario) {
		int usuarioEmpleado = 1;
		int usuarioOtro = 2;
		int usuarioInvitado = 3;
		if (tipoUsuario == usuarioEmpleado) {
			return 10;
		}
		if (tipoUsuario == usuarioOtro) {
			return 8;
		}
		if (tipoUsuario == usuarioInvitado) {
			return 7;
		}
		return 0;
	}

	private LocalDate calcularDiasDeFinDeSemana(LocalDate date, int dias) {
		LocalDate result = date;
		int diasagregados = 0;
		while (diasagregados < dias) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++diasagregados;
			}
		}
		return result;
	}

	private String total(int tipoUsuario) {
		int dias = calcularIncrementoDias(tipoUsuario);
		LocalDate date = calcularDiasDeFinDeSemana(LocalDate.now(), dias);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechatexto = formato.format(date);
		return fechatexto;
	}
}

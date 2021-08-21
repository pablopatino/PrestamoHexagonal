package com.example.bibliotecaHexa.demo.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;
import com.example.bibliotecaHexa.demo.dominio.modelo.Prestamo;
import com.example.bibliotecaHexa.demo.dominio.puerto.repositorio.RepositorioPrestamo;

@Service
public class ServicioGuardarPrestamo {

	private final RepositorioPrestamo repositorioPrestamo;

	public ServicioGuardarPrestamo(RepositorioPrestamo repositorioPrestamo) {
		this.repositorioPrestamo = repositorioPrestamo;
	}
	
	public ResponseEntity<?> crearPrestamo(Prestamo prestamo) {
		Map<String, Object> resp = new HashMap<>();
		
		
		validarSiUsuarioTieneLibroPrestado(prestamo);
		prestamo.setFechaDevolucion(total(prestamo.getTipoUsuario()));
		this.repositorioPrestamo.save(prestamo);
		
		resp.put("id", prestamo.getId());
		resp.put("fechaMaximaDevolucion", prestamo.getFechaDevolucion());
		
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
		
	}
	
	private void validarSiUsuarioTieneLibroPrestado(Prestamo prestamo) {
		int invitado = 3;
		if (prestamo.getTipoUsuario() == invitado) {
			Prestamo o = this.repositorioPrestamo.buscarPrestamoPorIdentificacion(prestamo.getIdentificacionUsuario());
			if (o != null) {
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

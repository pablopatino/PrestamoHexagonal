package com.example.bibliotecaHexa.demo.dominio.modelo;

import com.example.bibliotecaHexa.demo.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidarCamposVacios {

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null || valor.toString().isEmpty()) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

	public static void validarObligatorioInt(int valor, String mensaje) {
		if (valor <= 0 || valor >= 4) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

}

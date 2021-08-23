package com.example.bibliotecaHexa.demo.dominio.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.bibliotecaHexa.demo.dominio.modelo.ValidarCamposVacios.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private final static String IDENTIFICACION_OBLIGADO = "La identificacion es obligatorio";
	private final static String ISBN_OBLIGADO = "Isbn es obligatorio";
	private final static String TIPOUSUARIO_OBLIGADO = "El tipo del usuario es obligatorio";

	@Id
	private String identificacionUsuario;
	private String isbn;
	private int tipoUs;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Prestamo> prestamos;

	public Usuario() {
		this.prestamos = new ArrayList<>();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public int getTipoUs() {
		return tipoUs;
	}

	public void setTipoUs(int tipoUs) {
		this.tipoUs = tipoUs;
	}

	public Usuario(String identificacionUsuario, String isbn, int tipoUs) {

		validarObligatorio(identificacionUsuario, IDENTIFICACION_OBLIGADO);
		validarObligatorio(isbn, ISBN_OBLIGADO);
		validarObligatorioInt(tipoUs, TIPOUSUARIO_OBLIGADO);

		this.identificacionUsuario = identificacionUsuario;
		this.isbn = isbn;
		this.tipoUs = tipoUs;
		this.prestamos = new ArrayList<>();
	}

	private static final long serialVersionUID = 1L;

}

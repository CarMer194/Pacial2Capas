package com.uca.capas.examen.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cLibro;
	
	@Size(max=500)
	@Column(name="s_titulo")
	private String sTitutlo;
	
	@Size(max=150)
	@Column(name="s_autor")
	private String sAutor;
	
	@Column(name="f_ingreso")
	private Date fIngreso;
	
	@Column(name="b_estado")
	private Boolean bEstado;
	
	@Column(name="s_isbn")
	@Size(max=10)
	private String isbn;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;

	public Libro() {
		super();
	}

	
	public Libro(Integer cLibro, @Size(max = 500) String sTitutlo, @Size(max = 150) String sAutor, Date fIngreso,
			Boolean bEstado, @Size(max = 10) String isbn, Categoria cCategoria) {
		super();
		this.cLibro = cLibro;
		this.sTitutlo = sTitutlo;
		this.sAutor = sAutor;
		this.fIngreso = fIngreso;
		this.bEstado = bEstado;
		this.isbn = isbn;
		this.categoria = cCategoria;
	}


	public Integer getcLibro() {
		return cLibro;
	}

	public void setcLibro(Integer cLibro) {
		this.cLibro = cLibro;
	}

	public String getsTitutlo() {
		return sTitutlo;
	}

	public void setsTitutlo(String sTitutlo) {
		this.sTitutlo = sTitutlo;
	}

	public String getsAutor() {
		return sAutor;
	}

	public void setsAutor(String sAutor) {
		this.sAutor = sAutor;
	}

	public Date getfIngreso() {
		return fIngreso;
	}

	public void setfIngreso(Date fIngreso) {
		this.fIngreso = fIngreso;
	}

	public Boolean getbEstado() {
		return bEstado;
	}

	public void setbEstado(Boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String estadoDelegate() {
		if(this.bEstado) {
			return "Activo";
		}else {
			return "Inactivo";
		}
	}
	
	
}

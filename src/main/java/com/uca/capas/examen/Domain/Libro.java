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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Integer cCategoria;

	public Libro() {
		super();
	}

	public Libro(Integer cLibro, @Size(max = 500) String sTitutlo, @Size(max = 150) String sAutor, Date fIngreso,
			Boolean bEstado, Integer cCategoria) {
		super();
		this.cLibro = cLibro;
		this.sTitutlo = sTitutlo;
		this.sAutor = sAutor;
		this.fIngreso = fIngreso;
		this.bEstado = bEstado;
		this.cCategoria = cCategoria;
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

	public Integer getcCategoria() {
		return cCategoria;
	}

	public void setcCategoria(Integer cCategoria) {
		this.cCategoria = cCategoria;
	}
	
	
}

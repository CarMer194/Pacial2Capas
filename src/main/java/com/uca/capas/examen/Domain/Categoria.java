package com.uca.capas.examen.Domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(schema="public",name="cat_categoria")
public class Categoria {
	
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ccategoria;
	
	@NotNull
	@Column(name="s_categoria")
	@Size(max=50,message="El campo nombre no puede exceder de 50 caracteres")
	private String scategoria;
	
	@OneToMany(mappedBy="cat_categoria",fetch=FetchType.EAGER)
	private List<Libro> libros;

	public Categoria() {
		super();
	}

	

	public Categoria(Integer ccategoria,
			@Size(max = 50, message = "El campo nombre no puede exceder de 50 caracteres") String scategoria,
			List<Libro> libros) {
		super();
		this.ccategoria = ccategoria;
		this.scategoria = scategoria;
		this.libros = libros;
	}



	public Integer getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}

	public String getScategoria() {
		return scategoria;
	}

	public void setScategoria(String scategoria) {
		this.scategoria = scategoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	

}

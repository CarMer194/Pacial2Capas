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
	private Integer categoria;
	
	@NotNull
	@Column(name="s_categoria")
	@Size(max=50,message="El campo nombre no puede exceder de 50 caracteres")
	private String scategoria;
	
	@OneToMany(mappedBy="categoria",fetch=FetchType.EAGER)
	private List<Libro> libros;

	public Categoria() {
		super();
	}

	public Categoria(Integer categoria,
			@Size(max = 50, message = "El campo nombre no puede exceder de 50 caracteres") String scategoria,
			List<Libro> libros) {
		super();
		this.categoria = categoria;
		this.scategoria = scategoria;
		this.libros = libros;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
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

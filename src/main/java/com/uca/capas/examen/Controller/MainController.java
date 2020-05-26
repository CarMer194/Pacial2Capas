package com.uca.capas.examen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.examen.DAO.CategoriaDAO;
import com.uca.capas.examen.DAO.LibroDAO;
import com.uca.capas.examen.Domain.Categoria;
import com.uca.capas.examen.Domain.Libro;

@Controller
public class MainController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private LibroDAO libroDAO;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model=new ModelAndView();
		List<Libro> libros=libroDAO.findAll();
		List<Categoria> categorias=categoriaDAO.findAll();
		model.setViewName("index");
		return model;
	}
}

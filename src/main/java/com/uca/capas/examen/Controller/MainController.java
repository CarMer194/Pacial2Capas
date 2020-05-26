package com.uca.capas.examen.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		List<Categoria> categorias=categoriaDAO.findAll();
		List<Libro> libros=libroDAO.findAll();
		model.addObject("categorias",categorias);
		model.addObject("libros",libros);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping("/inserLibro")
	public ModelAndView inserLibro() {
		ModelAndView model=new ModelAndView();
		List<Categoria> categorias=categoriaDAO.findAll();
		model.addObject("libro",new Libro());
		model.addObject("categorias",categorias);
		model.setViewName("ingresoLibro");

		return model;
	}
	@RequestMapping("/inserCat")
	public ModelAndView inserCat() {
		ModelAndView model=new ModelAndView();
		model.addObject("categoria",new Categoria());
		model.setViewName("ingresoCat");
		return model;
	}
	
	@RequestMapping("/guardarLib")
	public ModelAndView saveLib(@ModelAttribute @Valid Libro libro, BindingResult resultset) {
		ModelAndView model=new ModelAndView();
		if(resultset.hasErrors()) {
			model.setViewName("inserLibro");
		}else {
			Date date=Calendar.getInstance().getTime();
			libro.setfIngreso(date);
			libroDAO.insertarLibro(libro);
			model.addObject("cadena","Libro ingresado con exito");
			model.setViewName("index");
		}
		return model;
	}
	@RequestMapping("/guardarCat")
	public ModelAndView saveCat(@ModelAttribute @Valid Categoria cat, BindingResult resultset) {
		ModelAndView model=new ModelAndView();
		if(resultset.hasErrors()) {
			model.setViewName("ingresoCat");
		}else {
			categoriaDAO.insertarLibro(cat);
			model.addObject("cadena","Categoria ingresada con exito");
			model.setViewName("index");
		}
		return model;
	}
	@RequestMapping("/mostrarLista")
	public ModelAndView lista() {
		ModelAndView model=new ModelAndView();
		List<Libro> libros= libroDAO.findAll();
		model.addObject("libros", libros);
		model.setViewName("listado");
		return model;
	}
}

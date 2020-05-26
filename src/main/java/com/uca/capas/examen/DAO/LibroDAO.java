package com.uca.capas.examen.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen.Domain.Libro;


public interface LibroDAO {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public Libro findOne(Integer code) throws DataAccessException;
	
	@Transactional
	public void insertarLibro(Libro libro) throws DataAccessException;
}

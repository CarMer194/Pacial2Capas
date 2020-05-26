package com.uca.capas.examen.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen.Domain.Categoria;

public interface CategoriaDAO {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public Categoria fineOne(Integer code) throws DataAccessException;
	
	@Transactional
	public void insertarLibro(Categoria categoria) throws DataAccessException;
	
}

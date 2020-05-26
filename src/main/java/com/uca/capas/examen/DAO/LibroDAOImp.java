package com.uca.capas.examen.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.examen.Domain.Libro;

@Repository
public class LibroDAOImp implements LibroDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb=new StringBuffer();
		sb.append("select * from cat_libro");
		Query query= entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> libros=query.getResultList();

		return libros;
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		Libro libro=entityManager.find(Libro.class, code);
		return libro;
	}
	
	@Transactional
	@Override
	public void insertarLibro(Libro libro) throws DataAccessException {
		try {
			if(libro.getcLibro()==null) {
				entityManager.persist(libro);
			}else {
				entityManager.merge(libro);
				entityManager.flush();
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	

}

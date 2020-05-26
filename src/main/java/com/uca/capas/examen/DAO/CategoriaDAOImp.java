package com.uca.capas.examen.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.examen.Domain.Categoria;

@Repository
public class CategoriaDAOImp implements CategoriaDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb=new StringBuffer();
		sb.append("select * from cat_categoria");
		Query query= entityManager.createNativeQuery(sb.toString(),Categoria.class);
		List<Categoria> categorias=query.getResultList();

		return categorias;
	}

	@Override
	public Categoria fineOne(Integer code) throws DataAccessException {
		Categoria categoria=entityManager.find(Categoria.class, code);
		return null;
	}

	@Override
	public void insertarLibro(Categoria categoria) throws DataAccessException {
		try {
			if(categoria.getCategoria()==null) {
				entityManager.persist(categoria);
			}else {
				entityManager.merge(categoria);
				entityManager.flush();
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

}

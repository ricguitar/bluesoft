package com.vote.no.filme.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.vote.no.filme.domain.Filme;

public class FilmeService {
	
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Filme> getFilmes(){
		@SuppressWarnings("unchecked")
		List<Filme> filmes = (List<Filme>)em.createQuery("Select f from Filme f").getResultList();
		return filmes;
	}
}

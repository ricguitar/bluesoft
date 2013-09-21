package com.vote.no.filme.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.vote.no.filme.domain.Usuario;

public class UserService {
	
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void recordUser(Usuario u){
		em.persist(u);
	}
}

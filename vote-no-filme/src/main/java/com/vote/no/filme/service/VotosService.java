package com.vote.no.filme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import com.vote.no.filme.domain.Filme;
import com.vote.no.filme.domain.Usuario;
import com.vote.no.filme.domain.Votos;

public class VotosService {
	
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void updateVotos (List<Filme> filmes, Usuario usuario){
		em.clear();
		for (Filme f : filmes){
			Votos voto = f.getVotos().get(0);
			voto.setUsuario(usuario);
			em.persist(voto);
		}
	}
}

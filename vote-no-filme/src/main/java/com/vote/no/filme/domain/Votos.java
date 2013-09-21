package com.vote.no.filme.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Votos
 *
 */
@Entity
public class Votos implements Serializable {

	private static final long serialVersionUID = 1549633182927359061L;
	
	private int votos;
	
	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="FILMEID", referencedColumnName="ID")
	private Filme filme;

	@Id
	@ManyToOne
	@PrimaryKeyJoinColumn(name="USUARIOID", referencedColumnName="ID")
	private Usuario usuario;

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

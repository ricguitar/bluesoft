package com.vote.no.filme.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Filme
 *
 */
@Entity
public class Filme implements Serializable, Comparable<Filme> {

	private static final long serialVersionUID = 7058177425114408074L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	private String name;
	
	@Column(unique=true)
	private String image;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="filme", cascade = CascadeType.ALL)
	private List<Votos> votos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Votos> getVotos() {
		return votos;
	}
	public void setVotos(List<Votos> votos) {
		this.votos = votos;
	}
	
	public int compareTo(Filme o) {
		int votos_self = 0, votos_other = 0;
		for (Votos v : this.getVotos())
			votos_self += v.getVotos();
		for (Votos v : o.getVotos())
			votos_other += v.getVotos();
		return (votos_other - votos_self);
	}
}

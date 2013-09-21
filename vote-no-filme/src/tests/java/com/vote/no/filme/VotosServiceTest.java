package com.vote.no.filme;

import static org.mockito.Mockito.mock;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vote.no.filme.domain.Filme;
import com.vote.no.filme.domain.Usuario;
import com.vote.no.filme.service.VotosService;

public class VotosServiceTest {

	private VotosService votosServ;
	private Usuario usuario;
	private List<Filme> filmes;
	
	@Before
	public void init(){
		votosServ = mock(VotosService.class);
		usuario = mock(Usuario.class);
		filmes =  new LinkedList<Filme>();
		for(int k = 0; k < 5; ++k)
			filmes.add(mock(Filme.class));
	}
	
	@Test
	public void ShouldReturnAValidListOfFilmes() {
		votosServ.updateVotos(filmes, usuario);
	}

}

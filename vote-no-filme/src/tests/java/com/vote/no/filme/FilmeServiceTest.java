package com.vote.no.filme;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.vote.no.filme.service.FilmeService;

public class FilmeServiceTest {

	private FilmeService filmeServ;

	@Before
	public void init(){
		filmeServ = mock(FilmeService.class);
	}
	
	@Test
	public void ShouldReturnAValidListOfFilmes() {
		//when(filmeServ.getFilmes()).thenReturn(anyListOf(Filme.class));
		when(filmeServ.getFilmes()).thenReturn(null);
	}

}

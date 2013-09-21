package com.vote.no.filme;

import static  org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletConfig;

import com.vote.no.filme.logic.SaveUserAndVotes;
import com.vote.no.filme.service.FilmeService;
import com.vote.no.filme.service.Services;
import com.vote.no.filme.service.UserService;
import com.vote.no.filme.service.VotosService;

public class SaveUserAndVotesTest {

	private SaveUserAndVotes save;
	private MockHttpServletRequest request = new MockHttpServletRequest();
	private MockHttpServletResponse response = new MockHttpServletResponse();
	private MockHttpSession session = new MockHttpSession();
	private Services services;
	private UserService userServ;
	private VotosService votosServ;
	private FilmeService filmeServ;
	private String email;
	private String name;
	
	@Before
	public void init (){
		save = new SaveUserAndVotes();
		userServ = mock(UserService.class);
		votosServ = mock(VotosService.class);
		filmeServ = mock(FilmeService.class);
		services = new Services();
		services.setUserServ(userServ);
		services.setVotosServ(votosServ);
		services.setFilmeServ(filmeServ);
		session.setAttribute("services", services);
		request.setSession(session);
		name = "Test";
		email = "test@test.com";
		request.setAttribute("name", name);
		request.setAttribute("email", email);
	}
	
	@Test
	public void ShouldSaveNewwUserAndItsVotes() throws ServletException, IOException{
		save.init(new MockServletConfig());
		save.service(request, response);
	}
}

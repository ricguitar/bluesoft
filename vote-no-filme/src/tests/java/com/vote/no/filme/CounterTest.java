package com.vote.no.filme;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletConfig;

import com.vote.no.filme.logic.Counter;

public class CounterTest {

	private Counter counter;
	private MockHttpServletRequest request = new MockHttpServletRequest();
	private MockHttpServletResponse response = new MockHttpServletResponse();
	private MockHttpSession session = new MockHttpSession();
	
	@Before
	public void init (){
		counter = mock(Counter.class);
		request.setSession(session);
	}
	
	@Test
	public void ShouldAddOneMoreVoteToFilme1() throws ServletException, IOException{
		request.setParameter("filme", "1");
		counter.init(new MockServletConfig());
		counter.service(request, response);
	}
	
	@Test
	public void ShouldAddOneMoreVoteToFilme2() throws ServletException, IOException{
		request.setParameter("filme", "2");
		counter.init(new MockServletConfig());
		counter.service(request, response);
	}

}

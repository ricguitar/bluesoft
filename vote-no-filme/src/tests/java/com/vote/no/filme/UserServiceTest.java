package com.vote.no.filme;

import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import com.vote.no.filme.domain.Usuario;
import com.vote.no.filme.service.UserService;

public class UserServiceTest {

	private UserService userServ;
	private Usuario usuario;
	
	
	@Before
	public void init(){
		userServ = mock(UserService.class);
		usuario = mock(Usuario.class);
	}
	
	@Test
	public void ShouldRecordANewUser() {
		userServ.recordUser(usuario);
	}
}

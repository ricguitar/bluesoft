package com.vote.no.filme.logic;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vote.no.filme.domain.Filme;
import com.vote.no.filme.domain.Usuario;
import com.vote.no.filme.service.Services;

/**
 * Servlet implementation class SaveUserAndVotes
 */

public class SaveUserAndVotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Services services = (Services)(request.getSession().getAttribute("services"));
		List<Filme> filmes = (List<Filme>)(request.getSession().getAttribute("filmes"));
		Usuario newUser = new Usuario();
		
		newUser.setName(request.getParameter("name"));
		newUser.setEmail(request.getParameter("email"));
		services.getUserServ().recordUser(newUser);
		
		services.getVotosServ().updateVotos(filmes, newUser);
		
		List<Filme> movies = services.getFilmeServ().getFilmes();
		Collections.sort(movies);
		request.getSession().setAttribute("movies", movies);
		
		getServletContext().getRequestDispatcher("/end.jsp").forward(request, response);
	}

}

package com.vote.no.filme.logic;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vote.no.filme.domain.Filme;
import com.vote.no.filme.domain.Votos;
import com.vote.no.filme.service.Services;

/**
 * Servlet implementation class Counter
 */

public class Counter extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private AbstractApplicationContext ap;
	private Services services;
	private List<Filme> filmes;
	private Filme filme1;
	private Filme filme2;
	private int f1;
	private int f2;

	private ServletContext contexto;

	public void setServices(Services services) {
		this.services = services;
	}

	public void init(ServletConfig config) throws ServletException{
		super.init(config); 
		contexto = config.getServletContext();
		ap = new ClassPathXmlApplicationContext("applicationContext.xml");
		services = (Services) ap.getBean("services");
		filmes = services.getFilmeServ().getFilmes();
		if (filmes.size() == 0){
			return;
		}
		for (Filme f : filmes){
			f.getVotos().clear();
			Votos voto = new Votos();
			voto.setFilme(f);
			voto.setVotos(0);
			f.getVotos().add(voto);
		}
		filme1 = filmes.get(0);
		f1 = 0;
		filme2 = filmes.get(1);
		f2 = 1;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param;
		int filme, votes;
		
		if (filmes.size() == 0){
			contexto.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		param = request.getParameter("filme");
		
		if (param == null){
			request.setAttribute("filme1", filmes.get(f1));
			request.setAttribute("filme2", filmes.get(f2));
		}
		else{
			filme = Integer.parseInt(param);
			if (filme == 1){
				votes = filme1.getVotos().get(0).getVotos();
				++votes;
				filme1.getVotos().get(0).setVotos(votes);
			}
			else{
				votes = filme2.getVotos().get(0).getVotos();
				++votes;
				filme2.getVotos().get(0).setVotos(votes);
			}
					
			if (f2 == filmes.size() - 1){
				if (f1 < filmes.size() - 2){
					filme1 = filmes.get(++f1);
					f2 = f1 + 1;
					filme2 = filmes.get(f2);
				}
				else{
					Collections.sort(filmes);
					request.getSession().setAttribute("filmes", filmes);
					request.getSession().setAttribute("services", services);
					contexto.getRequestDispatcher("/form.jsp").forward(request, response);
					return;
				}
			}
			else{
				filme2 = filmes.get(++f2);
			}
			request.setAttribute("filme1", filme1);
			request.setAttribute("filme2", filme2);
		}
		contexto.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	 public void destroy() {
		 super.destroy();
		 ap.close();
	 }
}

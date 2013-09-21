<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.vote.no.filme.domain.Votos"%>
<%@page import="java.util.List"%>
<%@page import="com.vote.no.filme.domain.Filme"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
	<%
	List<Filme> filmes = (List<Filme>)(request.getSession().getAttribute("filmes"));
	List<Filme> movies = (List<Filme>)(request.getSession().getAttribute("movies"));
	%>
	<h1>Resultado da Votação</h1>
	<table cellspacing="100">
		<tr>
		<td>
		<table cellspacing="50">
			<tr><td><h3>Ranking Pessoal</h3></td><td><h3>Total</h3></td></tr>
			<%for (Filme f : filmes) {%>
			<tr>
				<td><%=f.getName()%></td><td align="center"><%=f.getVotos().get(0).getVotos()%></td>
			</tr>
			<%}%>
		</table>
		</td>
		<td>
		<table cellspacing="50">
			<tr><td><h3>Ranking Geral</h3></td><td><h3>Total</h3></td></tr>
			<%for (Filme f : movies) {
				int totalVotos = 0;
				for(Votos v : f.getVotos())
					totalVotos += v.getVotos();
			%>
			<tr>
				<td><%=f.getName()%></td><td align="center"><%=totalVotos%></td>
			</tr>
			<%}%>
		</table>
		</td>
		</tr>
	</table>
</body>
</html>
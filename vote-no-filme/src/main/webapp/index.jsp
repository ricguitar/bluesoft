<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.vote.no.filme.domain.Filme"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Vote no Filme</title>
</head>
<body>
	<%
	Filme filme1, filme2;
	filme1 = (Filme)(request.getAttribute("filme1"));
	filme2 = (Filme)(request.getAttribute("filme2"));
	if (filme1 == null || filme2 == null){
		getServletContext().getRequestDispatcher("/counter").forward(request, response);
		return;
	}
	String img1 = filme1.getImage();
	String img2 = filme2.getImage();
	%>
	<h1>Click no melhor filme</h1>
	<table cellspacing="50">
		<tr>
			<td><a href="counter?filme=1"><img src="<%=img1%>" height="500" width="350"/></a></td><td><a href="counter?filme=2"><img src="<%=img2%>"  height="500" width="350"/></a></td>
		</tr>
	</table>
</body>
</html>
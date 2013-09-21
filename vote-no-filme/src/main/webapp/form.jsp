<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.vote.no.filme.domain.Filme"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Registre seus votos</title>
<script language="JavaScript">
function verificaCampos(nome, email)
{
	if (name.value == "" || email.value == "")
	{
		document.forms[0].action="";
		alert("Campos nome e email são obrigatórios!");
	}
	else
	{
		document.forms[0].action="save";
	}
}
</script>
</head>
<body>
<h1>Digite seu nome e email:</h1>
<form method="post" onsubmit="verificaCampos(name, email)">
<table>
<tr>
<td><label>Nome</label></td><td><input type="text" name="name"/></td>
</tr>
<tr>
<td><label>Email</label></td><td><input type="text" name="email"/></td>
</tr>
<tr>
<td><input type="submit" value="Submit"/></td><td></td>
</tr>
</table>
</form>
</body>
</html>
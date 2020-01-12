<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@page import="isamm.yassine.metier.Etudiants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>

<%
	ArrayList<Etudiants> list = (ArrayList<Etudiants>) request.getAttribute("list");
	Etudiants etudiant = (Etudiants) request.getAttribute("etudiant");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
		if (etudiant==null) {
	%>
<title>Affichage des étudiants</title>
<%
		}else{
	%>
<title>Details d'un étudiant</title>
<%
		}
	%>
<link href="<c:url value='menu.css' />" rel="stylesheet" type="text/css"></link>
<link href="<c:url value='style.css' />" rel="stylesheet"
	type="text/css"></link>

</head>
<body>


	<ul id="menu">
		<li><a href="#">Identification</a>
			<ul class="hidden">
				<li><a href="identification.html">Login</a></li>
			</ul></li>
		<li><a href="insertionEtudiant.html">insertionEtudiant</a></li>
		<li><a href="recherche.html">Recherche</a></li>
	</ul>


	<%
		if (etudiant==null) {
	%>

	<h2>Affichage des étudiants</h2>
	<div class="table-wrapper">
		<table class="fl-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>MOYENNE GÉNÉRALE</th>
					<th>Matiéres</th>
					<th>SUPPRIMER</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<%
						Etudiants e = (Etudiants) list.get(i);
					%>

					<td><%=e.getID()%></td>
					<td><%=e.getNom()%></td>
					<td><%=e.getPrenom()%></td>
					<%
						if (e.getMoyenne_generale() >= 10) {
					%>
					<!-- <td bgcolor="#00FF00"> -->
					<td style="font-weight: bold"><font color="#00FF00"><%=e.getMoyenne_generale()%></font></td>
					<%
						} else {
					%>
					<td style="font-weight: bold"><font color="#FF0000"><%=e.getMoyenne_generale()%></font></td>
					<%
						}
					%>
					<td><%=Arrays.toString(e.getMatieres())%></td>
					<td><a class="del" href="SuppressionEtudiant?id=<%=e.getID()%>"> delete</a></td>
					
				</tr>
				<%
					}
				%>
			
			<tbody>
		</table>
	</div>
	<%
			}else{
		%>
	<h2>
		Details de l étudiant
		<%=etudiant.getNom()%></h2>
	<div class="table-wrapper">
		<table class="fl-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>MOYENNE GÉNÉRALE</th>
					<th>Matiéres</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=etudiant.getID()%></td>
					<td><%=etudiant.getNom()%></td>
					<td><%=etudiant.getPrenom()%></td>
					<td><%=etudiant.getMoyenne_generale()%></td>
					<td><%=Arrays.toString(etudiant.getMatieres())%></td>
					
				</tr>
			<tbody>
		</table>
	</div>
	<%
		}
	%>
</body>
</html>
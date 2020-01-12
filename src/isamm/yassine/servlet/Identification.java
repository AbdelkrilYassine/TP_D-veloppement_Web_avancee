package isamm.yassine.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isamm.yassine.metier.Etudiants;
import isamm.yassine.metier.GestionEtudiants;
import isamm.yassine.metier.Test;

@WebServlet("/Identification")
public class Identification extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String L = request.getParameter("login");
		String P = request.getParameter("password");
		String[] mat = { "Physique", "Informatique" , "Math"};	
		
		Etudiants admin =new Etudiants((long) 666,"admin","admin",20,mat);
		GestionEtudiants.addEtudiant(admin);

		// &&
		// Test.testStringWithAlphaAndNumbers(L)&&Test.testStringWithAlphaAndNumbers(P)
		if (L.equals(P)) {
			List<Etudiants> list = GestionEtudiants.getAllEtudiants();
			request.setAttribute("list", list);
			request.getRequestDispatcher("Affichage.jsp").forward(request, response);

		} else {

			request.getRequestDispatcher("echec.html").forward(request, response);

		}

	}
}
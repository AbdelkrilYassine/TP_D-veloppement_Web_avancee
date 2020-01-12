package isamm.yassine.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isamm.yassine.metier.Etudiants;
import isamm.yassine.metier.GestionEtudiants;

@WebServlet("/SuppressionEtudiant")
public class SuppressionEtudiant extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inID = request.getParameter("id");
		long id = Long.parseLong(inID);
		GestionEtudiants.deleteEtudiant(id);
		ArrayList<Etudiants> list = GestionEtudiants.getAllEtudiants();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Affichage.jsp").forward(request, response);

	}
}

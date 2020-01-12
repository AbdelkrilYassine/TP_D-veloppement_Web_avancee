package isamm.yassine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isamm.yassine.metier.Etudiants;
import isamm.yassine.metier.GestionEtudiants;
import isamm.yassine.metier.Test;

@WebServlet("/RechercheEtudiant")
public class RechercheEtudiant extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String I = request.getParameter("ID");
		if (Test.testLong(I) && I.length() < 8 && Long.parseLong(I)>0 ) {
			
			if(GestionEtudiants.getAllEtudiants().isEmpty()) {
				out.print("Il ya aucun Etudiant inscrits");
			}else {

				Etudiants e = GestionEtudiants.getEtudiant(Long.parseLong(I));
				if (e != null ) {
					request.setAttribute("etudiant", e);
					request.getRequestDispatcher("Affichage.jsp").forward(request, response);
				} else {
					out.print("Votre Identifiant saisie n existe pas ");

					}

		}
		}else {
			out.print("Votre Identifiant doit etre un nombre de taille max 8 ");

		}

	}
}
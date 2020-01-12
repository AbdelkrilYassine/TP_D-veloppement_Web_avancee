package isamm.yassine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isamm.yassine.metier.Etudiants;
import isamm.yassine.metier.GestionEtudiants;
import isamm.yassine.metier.Test;

@WebServlet("/InsertionEtudiant")
public class InsertionEtudiant extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String I = request.getParameter("ID");
		String N = request.getParameter("NOM");
		String P = request.getParameter("PRENOM");
		String M = request.getParameter("MOY");
		String[] mat = request.getParameterValues("list");

		if (Test.testLong(I) && Long.parseLong(I) > 0 && I.length() < 8) {
			if (Test.testStringWithAlpha(N) && N.length() >= 3) {
				if (Test.testStringWithAlpha(P) && P.length() >= 3) {
					if (Test.testFloat(M)) {
						if (mat != null && mat.length == 3) {
							Etudiants etud = new Etudiants();
							etud.setID(Long.parseLong(I));
							etud.setMoyenne_generale(Float.parseFloat(M));
							etud.setNom(N);
							etud.setPrenom(P);
							etud.setMatieres(mat);

							GestionEtudiants.addEtudiant(etud);
							ArrayList<Etudiants> list = GestionEtudiants.getAllEtudiants();
							request.setAttribute("list", list);
							request.getRequestDispatcher("Affichage.jsp").forward(request, response);
						} else {
							out.print("Vous devez choisir 3 matiéres ");

						}
					} else {
						out.print("Votre moyenne génerale doit etre un nombre entre 0 et 20 ");
					}
				} else {
					out.print("Votre Prenom doit contenir que des lettres et de taille au moins 3 ");

				}
			} else {
				out.print("Votre Nom doit contenir que des lettres et de taille au moins 3 ");

			}
		} else {
			out.print("Votre Identifiant doit etre un nombre de taille max 8 ");
		}

		out.close();

	}
}
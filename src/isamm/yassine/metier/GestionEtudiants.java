package isamm.yassine.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GestionEtudiants {
	private static final Map<Long, Etudiants> etudMap = new HashMap<Long, Etudiants>();

	public static Etudiants getEtudiant(Long etudId) {
		return etudMap.get(etudId);
	}

	public static void addEtudiant(Etudiants etudiant) {

		etudMap.put(etudiant.getID(), etudiant);

	}

	public static void deleteEtudiant(Long etudId) {
		etudMap.remove(etudId);
	}


	public static ArrayList<Etudiants> getAllEtudiants() {
		Collection<Etudiants> c = etudMap.values();
		ArrayList<Etudiants> list = new ArrayList<Etudiants>();
		list.addAll(c);
		return list;
	}
}
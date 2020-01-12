package isamm.yassine.metier;

public class Etudiants {
	private Long ID;
	private String nom;
	private String prenom;
	private float moyenne_generale;
	private String[] matieres;
	public Etudiants(Long iD, String nom, String prenom, float moyenne_generale,String[] mat) {
		super();
		ID = iD;
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne_generale = moyenne_generale;
		this.matieres=mat;
	}

	public String[] getMatieres() {
		return matieres;
	}

	public void setMatieres(String[] matieres) {
		this.matieres = matieres;
	}

	public Long getID() {
		return ID;
	}

	public Etudiants() {
		super();
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getMoyenne_generale() {
		return moyenne_generale;
	}

	public void setMoyenne_generale(float moyenne_generale) {
		this.moyenne_generale = moyenne_generale;
	}

}

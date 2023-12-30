package metier.liu.projet2024;

public class Auteur {
	//donnée
	public int IdAuteur;
	public String Nom;
	public String Adresse;
	public String Region;
	
	public Auteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auteur(int idAuteur, String nom, String prenom, String adresse, String region) {
		super();
		IdAuteur = idAuteur;
		Nom = nom;

		Adresse = adresse;
		Region = region;
	}

	public int getIdAuteur() {
		return IdAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		IdAuteur = idAuteur;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}



	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}
	
	
	
	
	
	

}

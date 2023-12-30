package metier.liu.projet2024;

public class Bibliotheque {
	//
	public int IdBibliotheque;
	public String Emplacement;

	//
	public Bibliotheque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bibliotheque(int idBibliotheque, String emplacement) {
		super();
		IdBibliotheque = idBibliotheque;
		Emplacement = emplacement;
	}

	// getters et setters
	public int getIdBibliotheque() {
		return IdBibliotheque;
	}

	public void setIdBibliotheque(int idBibliotheque) {
		IdBibliotheque = idBibliotheque;
	}

	public String getEmplacement() {
		return Emplacement;
	}

	public void setEmplacement(String emplacement) {
		Emplacement = emplacement;
	}

	public int getidBibliotheque() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Affichage

	@Override
	public String toString() {
		return "Bibliotheque [IdBibliotheque=" + IdBibliotheque + ", Emplacement=" + Emplacement + "]";
	}

}

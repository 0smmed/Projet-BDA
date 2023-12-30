package metier.liu.projet2024;

public class Livre {
	public int ISBN;
	public String Titre;
	public int IdAuteur;
	
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livre(int iSBN, String titre, int idAuteur) {
		super();
		ISBN = iSBN;
		Titre = titre;
		IdAuteur = idAuteur;
	}
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public int getIdAuteur() {
		return IdAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		IdAuteur = idAuteur;
	}
	
	
	


}

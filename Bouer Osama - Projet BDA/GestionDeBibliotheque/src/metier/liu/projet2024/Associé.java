package metier.liu.projet2024;

public class Associé {
	public int idBibliotheque;
	public int IdAuteur;
	
	
	
	
	
	
	public Associé() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Associé(int idBibliotheque, int idAuteur) {
		super();
		this.idBibliotheque = idBibliotheque;
		IdAuteur = idAuteur;
	}




	public int getidBibliotheque() {
		return idBibliotheque;
	}
	public void setNomBiblio(String nomBiblio) {
		idBibliotheque = idBibliotheque;
	}
	public int getIdAuteur() {
		return IdAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		IdAuteur = idAuteur;
	}
	
	

}

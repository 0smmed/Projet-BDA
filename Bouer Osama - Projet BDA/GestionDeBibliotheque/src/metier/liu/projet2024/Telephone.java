package metier.liu.projet2024;

public class Telephone {
	public int NumeroTel;
	public String Type;
	public int idAuteur;
	public Telephone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Telephone(int numeroTel, String type, int idAuteur) {
		super();
		NumeroTel = numeroTel;
		Type = type;
		this.idAuteur = idAuteur;
	}
	public int getNumeroTel() {
		return NumeroTel;
	}
	public void setNumeroTel(int numeroTel) {
		NumeroTel = numeroTel;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}
	
	

}

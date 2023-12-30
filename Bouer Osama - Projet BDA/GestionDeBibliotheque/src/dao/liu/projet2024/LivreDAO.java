package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.liu.projet2024.*;
import metier.liu.projet2024.Associé;
import metier.liu.projet2024.Livre;

public class LivreDAO implements dao<Livre> {
	//Connection
	private Connection conn;

	// Initialisation de la variable de connexion dans le constructeur
	public LivreDAO() throws SQLException {
		// Initialisation de la connexion 
		conn = DbConnection.getInstance().getConnection();
	}

	// Récupération d'un livre par son ID
	@Override
	public Livre get(long id) {
		Livre livre = null;
		// Requête SQL pour récupérer un livre par son ISBN
		String requete = "SELECT * FROM Livre WHERE ISBN = " + (int) id;
		System.out.println(requete);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requete);
			if (rs.next()) {
				// Récupération des données du livre
				int ISBN = rs.getInt("ISBN");
				String titre = rs.getString("titre");
				int idAuteur = rs.getInt("idAuteur");
				// Création d'un objet Livre avec les données récupérées
				livre = new Livre(ISBN, titre, idAuteur);
				System.out.println(livre.toString());
				System.out.println();
			} else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... élément introuvable");
			e.printStackTrace();
		}
		return livre;
	}

	// Récupéreration de tous les livres
	@Override
	public List<Livre> getAll() {
		Livre livre = null;
		ArrayList<Livre> arrayList = new ArrayList<>();
		// Requête SQL pour récupérer tous les livres
		String requete = "SELECT * FROM Livre";
		System.out.println(requete);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requete);
			if (rs.next())
				do {
					// Récupération des données de chaque livre
					int ISBN = rs.getInt("ISBN");
					String titre = rs.getString("titre");
					int idAuteur = rs.getInt("idAuteur");
					// Création d'un objet Livre avec les données récupérées
					livre = new Livre(ISBN, titre, idAuteur);
					arrayList.add(livre);
					System.out.println(livre.toString());
				} while (rs.next());
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... éléments introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	// Méthode pour enregistrer un livre dans la base de données
	@Override
	public void save(Livre t) {
		// Requête SQL pour insérer un nouveau livre
		String requete = "INSERT INTO Livre(ISBN, titre, idAuteur) VALUES(" + t.getISBN() + ", '" + t.getTitre() + "', '"
				+ t.getIdAuteur() + "')";
		System.out.println(requete);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requete);
			if (rs > 0)
				System.out.println("\tLivre enregistré !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement échoué");
			e.printStackTrace();
		}
	}

	// Méthode pour mettre à jour les informations d'un livre
	@Override
	public void update(Livre t, String[] params) {
		// Requête SQL pour mettre à jour un livre
		String requete = "UPDATE Livre SET titre='" + params[0] + "', " + "idAuteur=" + Integer.parseInt(params[1]) + " "
				+ "WHERE ISBN = " + (int) t.getISBN();
		System.out.println(requete);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requete);
			if (rs > 0)
				System.out.println("\tLivre modifié !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification échouée");
			e.printStackTrace();
		}
	}

	// Méthode pour supprimer un livre de la base de données
	@Override
	public void delete(Livre t) {
		// Requête SQL pour supprimer un livre par son ISBN
		String requete = "DELETE FROM Livre WHERE ISBN = " + (int) t.getISBN();
		System.out.println(requete);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requete);
			if (rs > 0)
				System.out.println("\tLivre supprimé !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression échouée");
			e.printStackTrace();
		}
	}

	// Méthode principale pour tester les fonctionnalités du LivreDAO
	public static void main(String[] args) throws SQLException {
		LivreDAO livdao = new LivreDAO();
		Livre liv8 = new Livre(111223, "Voyages à travers le Savoir", 8);
		
		// Get by id;
		livdao.save(liv8);
		livdao.get(111223);
		//livdao.getAll();
		//String[] params = { "Livre Power", "7" };
		//livdao.update(liv8, params);
		//livdao.delete(liv8);
	}


}

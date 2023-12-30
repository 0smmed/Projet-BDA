package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.liu.projet2024.DbConnection;
import metier.liu.projet2024.Associé;
import metier.liu.projet2024.Bibliotheque;
import metier.liu.projet2024.Livre;

public class AssociéDAO implements dao<Associé> {
	private Connection conn;

	public AssociéDAO() throws SQLException {
		conn = DbConnection.getInstance().getConnection();
	}

	public Associé get(int idBibliotheque, int idAuteur) {
		Associé association = null;
		String requet = "SELECT * FROM Associer WHERE idbibliotheque = " + idBibliotheque + " AND idAuteur = "
				+ idAuteur;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				association = new Associé(idBibliotheque, idAuteur);
				System.out.println(association.toString());
				System.out.println();
			} else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return association;
	}

	@Override
	public Associé get(long id) {
		Associé associé = null;
		String requet = "SELECT * FROM Associer  WHERE idAuteur = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int idBibliotheque = rs.getInt("idBibliotheque");
				int idAuteur = rs.getInt("idAuteur");
				associé = new Associé(idBibliotheque, idAuteur);
				System.out.println(associé.toString());
			} else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return associé;
	}

	@Override
	public List<Associé> getAll() {

		Associé associer = null;
		ArrayList<Associé> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Associer";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int idBibliotheque = rs.getInt("idBibliotheque");
					int idAuteur = rs.getInt("IdAuteur");
					associer = new Associé(idBibliotheque, idAuteur);
					arrayList.add(associer);
					System.out.println(associer.toString());
				} while (rs.next());
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public void save(Associé t) {
		String requet = "INSERT INTO Associer(idBibliotheque, idAuteur) VALUES(" + t.getidBibliotheque() + ", '"
				+ t.getIdAuteur() + "')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tAssociation enregistree !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Associé t, String[] params) {

	}

	@Override
	public void delete(Associé t) {
		String requet = "DELETE FROM Associer WHERE idBibliotheque = " + t.getidBibliotheque() + "AND idAuteur = "
				+ t.getIdAuteur();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tAssociation supprimee !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		AssociéDAO assdao = new AssociéDAO();
		Associé ass8 = new Associé(2, 3);
		// assdao.save(ass8);
		// assdao.getAll();
		// assdao.get(2);

	}

}
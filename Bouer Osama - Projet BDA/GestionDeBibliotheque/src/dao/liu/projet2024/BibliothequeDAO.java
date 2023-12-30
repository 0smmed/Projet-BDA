package dao.liu.projet2024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.liu.projet2024.DbConnection;
import metier.liu.projet2024.Bibliotheque;

	//accéder aux données de la table "Bibliotheque" dans la base de données.

	public class BibliothequeDAO implements dao<Bibliotheque> {
		private Connection conn;

    // Constructeur de la classe qui établit la connexion à la base de données.
   
    public BibliothequeDAO() throws SQLException {
        conn = DbConnection.getInstance().getConnection();
    }

    /////////////////////////////////////////////// Sélection par ID //////////////////////////////////////////////
    public Bibliotheque get(long id) {
        Bibliotheque bibliotheque = null;
        String requete = "SELECT * FROM Bibliotheque WHERE idBibliotheque = " + (int) id;
        System.out.println(requete);
        try {
            Statement pstm = conn.createStatement();
            ResultSet rs = pstm.executeQuery(requete);
            if (rs.next()) {
            	
            // Si une bibliothèque est trouvée, récupère les informations et crée un objet Bibliotheque.
                int idBibliotheque = rs.getInt("idBibliotheque");
                String emplacement = rs.getString("emplacement");
                bibliotheque = new Bibliotheque(idBibliotheque, emplacement);
                System.out.println(bibliotheque.toString());
                System.out.println();
            } else
            	
            // Lance une exception si la bibliothèque n'est pas trouvée.
                throw new SQLException();
        } catch (SQLException e) {
            System.out.println("Erreur SQL... élément introuvable");
            e.printStackTrace();
        }
        return bibliotheque;
    }

    /////////////////////////////////////////////// Sélection * ///////////////////////////////////////////////
    @Override
    public List<Bibliotheque> getAll() {
        Bibliotheque bibliotheque = null;
        ArrayList<Bibliotheque> arrayList = new ArrayList<>();
        String requete = "SELECT * FROM Bibliotheque";
        System.out.println(requete);
        try {
            Statement pstm = conn.createStatement();
            ResultSet rs = pstm.executeQuery(requete);
            if (rs.next())
            	
            // Si au moins une bibliothèque est trouvée, récupère les informations et crée des objets Bibliotheque.
                do {
                    int idBibliotheque = rs.getInt("idBibliotheque");
                    String emplacement = rs.getString("emplacement");
                    bibliotheque = new Bibliotheque(idBibliotheque, emplacement);
                    arrayList.add(bibliotheque);
                    System.out.println(bibliotheque.toString());
                } while (rs.next());
            else
            	
            // Lance une exception si aucune bibliothèque n'est trouvée.
                throw new SQLException();
        } catch (SQLException e) {
            System.out.println("Erreur SQL... éléments introuvables");
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override
    public void save(Bibliotheque t) {
        String requete = "INSERT INTO Bibliotheque(idBibliotheque, emplacement) VALUES(" + t.getIdBibliotheque() + ", '"
                + t.getEmplacement() + "')";
        System.out.println(requete);
        try {
            Statement pstm = conn.createStatement();
            int rs = pstm.executeUpdate(requete);
            if (rs > 0)
                System.out.println("\tBibliothèque enregistrée !\n");
            else
                throw new SQLException();
        } catch (SQLException e) {
            System.out.println("Erreur SQL... enregistrement échoué");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Bibliotheque t, String[] params) {
        String requete = "UPDATE Bibliotheque SET " + "emplacement='" + params[1] + "' " + "WHERE idBibliotheque = "
                + (int) t.getIdBibliotheque();
        System.out.println(requete);
        try {
            Statement pstm = conn.createStatement();
            int rs = pstm.executeUpdate(requete);
            if (rs > 0)
                System.out.println("\tBibliothèque modifiée !\n");
            else
                throw new SQLException();
        } catch (SQLException e) {
            System.out.println("Erreur SQL... modification échouée");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Bibliotheque t) {
        String requete = "DELETE FROM Bibliotheque WHERE idBibliotheque = " + (int) t.getIdBibliotheque();
        System.out.println(requete);
        try {
            Statement pstm = conn.createStatement();
            int rs = pstm.executeUpdate(requete);
            if (rs > 0)
                System.out.println("\tBibliothèque supprimée !\n");
            else
                throw new SQLException();
        } catch (SQLException e) {
            System.out.println("Erreur SQL... suppression échouée");
            e.printStackTrace();
        }
    }

    //test des opérations CRUD de la classe BibliothequeDAO.
    
    public static void main(String[] args) throws SQLException {
        BibliothequeDAO bibliodao = new BibliothequeDAO();
        Bibliotheque bib11 = new Bibliotheque(12, "Bibliothèque de village, Boghe");
        bibliodao.save(bib11);
    }
}

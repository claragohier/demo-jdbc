package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) throws Exception {

		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("jdbc.db.url");
		Class.forName(properties.getString("jdbc.driver"));
		String user = properties.getString("jdbc.db.login");
		String pwd = properties.getString("jdbc.db.password");
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			System.out.println("Connexion établie");
			
			System.out.println("Suppression...");
			String sql = "SELECT * FROM FOURNISSEUR";
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

			while(rs.next()) {
				System.out.println("id: " + rs.getInt("ID"));
				System.out.println("nom: " + rs.getString("NOM"));
				fournisseurs.add(new Fournisseur(rs.getInt("ID"), rs.getString("NOM")));
			}
			
			for(Fournisseur fournisseur : fournisseurs) {
				System.out.println("fournisseur nom : " + fournisseur.getNom());
			}
			
			conn.close();
			System.out.println("Connexion fermée !");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}

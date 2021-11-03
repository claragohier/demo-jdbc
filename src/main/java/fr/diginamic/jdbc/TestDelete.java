package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

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
			String sql = "DELETE FROM FOURNISSEUR WHERE NOM = 'La Maison des Peintures'";
			stmt.executeUpdate(sql);
			
			conn.close();
			System.out.println("Connexion fermée !");
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}

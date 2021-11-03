package fr.diginamic;

import java.sql.*;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws Exception {

		ResourceBundle properties = ResourceBundle.getBundle("database");
		String url = properties.getString("jdbc.db.url");
		Class.forName(properties.getString("jdbc.driver"));
		String user = properties.getString("jdbc.db.login");
		String pwd = properties.getString("jdbc.db.password");
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			conn.createStatement();
			System.out.println("Connexion établie");
			conn.close();
			System.out.println("Connexion fermée !");
		} catch (Exception e) {
			System.err.println("Connexion échouée");
		}
		
	}
	
}

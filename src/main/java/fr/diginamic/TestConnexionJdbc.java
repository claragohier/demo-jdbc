package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnexionJdbc {

	public static void main(String[] args) {

		String database="compta";
		String url="jdbc:mysql://localhost:3306/" + database;
		String user="root";
		String pwd="root";
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(url, user, pwd);
		    System.out.println("Connexion réussie");
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Connexion échouée");
		    System.exit(0);
		}	
	}
	
}

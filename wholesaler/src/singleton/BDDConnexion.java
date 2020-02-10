package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConnexion {
	private String url = "jdbc:mysql://localhost:3306/wholesaler?autoReconnect=true&useSSL=false";
	private String user = "root";
	private String password = "";
	private static Connection conn;
	private static BDDConnexion single = new BDDConnexion();
	
	
	private BDDConnexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Chargé avec succès");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("Connexion effectuée avec succès");
			//state =  conn.createStatement();
			//stateInsert = conn.createStatement();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Veuillez modifier le driver de connexion à votre base de données");
		}
		catch (SQLException e1) {
			System.out.println("L'utilisateur et/ou le mot de passe ne sont pas correct. Veuillez réessayer");
		
		
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	public static Connection getInstance(){
		if (single==null)
		{
			single = new BDDConnexion();
		}
		return conn;
	}

}

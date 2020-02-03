package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;
import model.Article;

public class ArticleDAO extends DAO<Article>{

	public ArticleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO articles nom VALUES  (" + obj.getNom() + ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public boolean delete(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM eleve e WHERE e.id = ?");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE eleve SET id = " + obj.getId() + " ,nom = " + obj.getNom() + " ,Prenom = " + obj.getPrenom()  );
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Article find(int id) {
		Eleve eleve = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM Eleve e WHERE e.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				eleve = new Eleve(id, result.getString("nom"), result.getString("prenom"));
				
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération de Eleve avec l ídentifiant :  " + id);
		}
		return eleve;
	}
	}

}

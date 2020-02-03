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
			PreparedStatement state = conn.prepareStatement(" INSERT INTO articles VALUES  (" + obj.getName() +","  + obj.isAvailable()+"," + obj.getStock() + ","+  obj.getDescription()+   ")");
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
			PreparedStatement state = conn.prepareStatement(" DELETE FROM articles a WHERE a.id = ?");
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
			PreparedStatement state = conn.prepareStatement(" UPDATE articles SET id = " + obj.getId() + " ,name = " + obj.getName() + ",available = " + obj.isAvailable()  +",stock = "  + obj.getStock()+ ", descrption = " + obj.getDescription()  );
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
		Article article = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM articles a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				article = new Article(id, result.getString("name"), result.getBoolean("available"), result.getInt("stock"), result.getString("description"));
				
			}
		} catch (SQLException e) {
			System.out.println("Probleme de r�cup�ration de article avec l �dentifiant :  " + id);
		}
		return article;
	}
}



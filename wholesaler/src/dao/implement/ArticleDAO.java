package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.DAO;
import model.Article;

public class ArticleDAO extends DAO<Article>{

	public ArticleDAO(Connection conn) {
		super(conn);
	}
	
		
	@Override
	public boolean create(Article obj) {
		int newId =0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement("SELECT MAX(id) from articles");
			ResultSet resultSelect = stateSelect.executeQuery();
			if (resultSelect.next() == true) {
				newId =resultSelect.getInt(1) + 1;
				System.out.println( "Le nouveau article aura l'ID : " + newId);
				obj.setId(newId);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO articles (id,name,available,stock,description) VALUES  ("+ 
						obj.getId()+",'"+ obj.getName() +"',"  + obj.isAvailable()+"," + obj.getStock() + ",'"+   obj.getDescription()+ "')");
				stateSelect.close();
				resultSelect.close();
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO articles (id,name,available,stock,description) VALUES  ("+ 
				obj.getId()+",'"+ obj.getName() +"',"  + obj.isAvailable()+"," + obj.getStock() + ",'"+   obj.getDescription()+ "')");
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
/* 
	@Override
	public boolean create(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO articles (name,available,stock,description) VALUES  ("+ "'"+ obj.getName() +"',"  + obj.isAvailable()+"," + obj.getStock() + ",'"+   obj.getDescription()+ "')");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
	*/ 
	
	@Override
	public boolean delete(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE articles a SET a.available = false  WHERE a.id = ?");
			state.setInt(1, obj.getId());
			int etat  = state.executeUpdate();
			System.out.println("L'article " + obj.getStock() + " a été supprimé ");
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
/*
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
*/
	@Override
	public boolean update(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE articles   SET " + " name = '" + obj.getName() + 
			"' ,available = " + obj.isAvailable()  +",stock = "  + obj.getStock()+ ", description = '" + obj.getDescription() + "' WHERE id = ?"  );
			state.setInt(1, obj.getId());
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
			System.out.println("Probleme de récupération de article avec l'identifiant :  " + id);
		}
		return article;
	}

	@Override
	public ArrayList<Article> findAll() {	
		Article article = null;
		ArrayList<Article> articles =null;
		try {
		articles = new ArrayList<Article>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM articles");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			
		  while (result.next()) {
			  article = new Article(result.getInt("id"), result.getString("name"), result.getBoolean("available"), result.getInt("stock"), result.getString("description"));
			  articles.add(article);
		  }  
		  System.out.println("L'arraylist articles est créé");
		}
		else {
			System.out.println("Table article  is empty");
		}
	} catch (SQLException e) {
		System.out.println("Problème avec la récupération de la DB " + e);
		
	}
	return articles;
	}
	

}



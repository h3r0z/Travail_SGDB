package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.DAO;
import model.Article;

public class ArticleDAO extends DAO<Article>{

	private ArrayList<Article> articles;

	public ArticleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Article obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO articles (name,available,stock,description) VALUES  (" + obj.getName() +","  + obj.isAvailable()+"," + obj.getStock() + ","+  obj.getDescription()+   ")");
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
			PreparedStatement state = conn.prepareStatement(" UPDATE articles  (id,name,available,stock,description) SET id = " + obj.getId() + " ,name = " + obj.getName() + 
			",available = " + obj.isAvailable()  +",stock = "  + obj.getStock()+ ", description = " + obj.getDescription() + ")"  );
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
			System.out.println("Probleme de récupération de article avec l ídentifiant :  " + id);
		}
		return article;
	}

	@Override
	public ArrayList<Article> findAll() {	
		Article article = null;
		try {
		articles = new ArrayList<Article>();
		articles =null;
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM articles");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
		  do {
			  article = new Article(result.getInt("id"), result.getString("name"), result.getBoolean("available"), result.getInt("stock"), result.getString("description"));
			  articles.add(article);
		  }while(result.next());
		}
		else {
			System.out.println("Table articles  is empty");
		}
	} catch (SQLException e) {
		System.out.println("Problème avec la récupération de la DB " + e);
		
	}
	return articles;
	}
	

}



package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.DAO;
import model.HistoryArticle;
public class HistoryArticleDAO extends DAO<HistoryArticle>{

	public HistoryArticleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(HistoryArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO  histo _art (id,article_id,date,price,vat_id) VALUES  ("   + obj.getId() +"," +obj.getArticle_id()+"," + 
			obj.getDateHistory() + ","+ obj.getPrice() + ","+  obj.getVatId() +   ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(HistoryArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM histo_art a WHERE a.id = ?");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(HistoryArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE  histo _art (id,article_id,date,price,vat_id) VALUES  (" + obj.getId() +"," +obj.getArticle_id()+"," + 
					obj.getDateHistory() + ","+ obj.getPrice() + ","+  obj.getVatId() +   ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public HistoryArticle find(int id) {
		HistoryArticle historyArticle = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM histo_art a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				historyArticle = new HistoryArticle(result.getInt("id"),result.getInt("article_id"),result.getDate("date"), result.getDouble("price"),result.getInt("vat_id"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération historyArticle  avec l identifiant :  " + id);
		}
		return historyArticle;
	}
	

	@Override
	public ArrayList<HistoryArticle> findAll() {
		HistoryArticle historyArticle = null;
		ArrayList<HistoryArticle> historyArticles = null;
		try {
		historyArticles = new ArrayList<HistoryArticle>();
		historyArticles = null;
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM histo_art");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			  do {
				  historyArticle =  new HistoryArticle(result.getInt("id"),result.getInt("article_id"),result.getDate("date"), result.getDouble("price"),result.getInt("vat_id"));
				  historyArticles.add(historyArticle);
			  }while(result.next());
		}		
			else {
				System.out.println("Table HistoryArticle  est vide");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return historyArticles;
	}

}

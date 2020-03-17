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
		int newId=0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement("SELECT MAX(id) from histo_art");
			ResultSet resultSelect = stateSelect.executeQuery();
			if(resultSelect.next() ==true) {
				newId = resultSelect.getInt(1)+1;
				System.out.println("Le dernier index de la table histo art "   + (newId-1) );

				obj.setId(newId);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  histo_art (id,article_id,date,price,vat_id) VALUES  ("   + obj.getId() +"," +obj.getArticle_id()+",'" + 
												obj.getDateHistory() + "',"+ obj.getPrice()+ ","+  obj.getVatId() +   ")");
				stateSelect.close();
				resultSelect.close();
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("L'historique de l'article  avec l'id :  " + obj.getId() + " avec l'id de l'article :   " + obj.getArticle_id() + " prix : "  +obj.getPrice() + "€ a bien été créer");
				return true;
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  histo_art (id,article_id,date,price,vat_id) VALUES  ("   + obj.getId() +"," +obj.getArticle_id()+",'" + 
						obj.getDateHistory() + "',"+ obj.getPrice() + ","+  obj.getVatId() +   ")");
				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("L'historique de l'article  avec l'id :  " + obj.getId() + " avec l'id de l'article :   " + obj.getArticle_id() + " prix : "  +obj.getPrice() + "€ a bien été créer");
				return true;
			}
		}catch(SQLException e ) {
			System.out.println(e.getMessage());
			return false;
		}
	}
/*
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
	*/

	@Override
	public boolean delete(HistoryArticle obj) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateDisable = conn.prepareStatement(" SET foreign_key_checks = 0" );
			int etat = stateDisable.executeUpdate();
			stateDisable.close();
			PreparedStatement state = conn.prepareStatement(" DELETE FROM histo_art a WHERE a.id = ?");
			state.setInt(1, obj.getId());
			etat  = state.executeUpdate();
			PreparedStatement stateInit = conn.prepareStatement("SET foreign_key_checks = 1" );
			etat = stateInit.executeUpdate();
			stateInit.close();
			conn.commit();
			conn.setAutoCommit(true);
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
			PreparedStatement state = conn.prepareStatement(" UPDATE  histo_art SET article_id = " +obj.getArticle_id()+",date='" + 
					obj.getDateHistory() + "',price ="+ obj.getPrice() + ", vat_id = "+  obj.getVatId() + " WHERE id = " + obj.getId() );
			int etat  = state.executeUpdate();
			System.out.println("L'historique de l'article a bien été modifié " + obj.getId() + " " + obj.getPrice());
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
				historyArticle = new HistoryArticle(result.getInt("id"),result.getInt("article_id"),result.getString("date"), result.getDouble("price"),result.getInt("vat_id"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération historyArticle  avec l identifiant :  " + id);
		}catch(Exception e) {
			System.out.print("Une erreur avec l'index de la table histo Art ");
		}
		return historyArticle;
	}
	

	@Override
	public ArrayList<HistoryArticle> findAll() {
		HistoryArticle historyArticle = null;
		ArrayList<HistoryArticle> historyArticles = null;
		try {
		historyArticles = new ArrayList<HistoryArticle>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM histo_art");
		ResultSet result = state.executeQuery();
		int cpt=0;
		if (result != null) 
		{
			while(result.next()) {
				  historyArticle =  new HistoryArticle(result.getInt("id"),result.getInt("article_id"),result.getString("date"), result.getDouble("price"),result.getInt("vat_id"));
				  historyArticles.add(historyArticle);
				  cpt++;
			}
			System.out.println(cpt);
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

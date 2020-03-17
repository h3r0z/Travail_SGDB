package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.InvoiceArticle;
public class InvoiceArticleDAO extends DAO<InvoiceArticle> {

	public InvoiceArticleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(InvoiceArticle obj) {
		int newId;
	
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement(" SELECT MAX(id) from inv_art" );
			ResultSet resultSelect  = stateSelect.executeQuery();
			if(resultSelect.next() ==true) {
				newId = resultSelect.getInt(1)+1;
				System.out.println("Le dernier index de la table inv_art  "   + (newId-1) );
				obj.setId(newId);
				stateSelect.close();
				resultSelect.close();
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  inv_art (inv_id,art_id,amount) VALUES  ("   + obj.getInvoiceId() +"," +obj.getArticleId() +"," + obj.getAmount() +   ")");
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("L invoice article  avec l'id :  " + obj.getId() +  " a bien été créer");
				return true;
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  inv_art (inv_id,art_id,amount) VALUES  ("   + obj.getInvoiceId() +"," +obj.getArticleId() +"," + obj.getAmount() +   ")");				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("L'invoice article  avec l'id :  " + obj.getId() +  " a bien été créer");
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean delete(InvoiceArticle obj) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateDisable = conn.prepareStatement(" SET foreign_key_checks = 0" );
			int etat = stateDisable.executeUpdate();
			stateDisable.close();
			PreparedStatement state = conn.prepareStatement(" DELETE FROM inv_art  WHERE id = "+obj.getId());
			etat  = state.executeUpdate();
			state.close();
			PreparedStatement stateInit = conn.prepareStatement("SET foreign_key_checks = 1" );
			etat = stateInit.executeUpdate();
			stateInit.close();
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Le vat  avec l id : " + obj.getId() + " a été supprimé");
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(InvoiceArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE  inv _art SET inv_id = " +  obj.getInvoiceId() +", art_id = " +obj.getArticleId() +", amount = " + obj.getAmount()  + " WHERE id = ? ");
			state.setInt(1, obj.getId());
			int etat  = state.executeUpdate();
			System.out.println("L invoice article avec l id " + obj.getId() + " a bien été modifié");
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public InvoiceArticle find(int id) {
		InvoiceArticle InvoiceArticle = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM inv_art a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				InvoiceArticle = new InvoiceArticle(result.getInt("id"),result.getInt("inv_id"),result.getInt("art_id"),result.getInt("amount"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération de invoice Article  avec l ídentifiant :  " + id);
		}
		return InvoiceArticle;
	}

	@Override
	public ArrayList<InvoiceArticle> findAll() {
		InvoiceArticle invoiceArticle = null;
		ArrayList<InvoiceArticle> invoicesArticles = null;
		try {
			invoicesArticles = new ArrayList<InvoiceArticle>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM inv_art");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			while(result.next()) {
				  invoiceArticle =  new InvoiceArticle(result.getInt("id"),result.getInt("inv_id"),result.getInt("art_id"),result.getInt("amount"));
					invoicesArticles.add(invoiceArticle);
			  }
		}		
			else {
				System.out.println("Table invoice  articles  is empty");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return invoicesArticles;
	}

}

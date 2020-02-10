package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.InvoiceArticle;
public class InvoiceArticleDAO extends DAO<InvoiceArticle> {
	private ArrayList<InvoiceArticle> invoicesArticles;

	public InvoiceArticleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(InvoiceArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO  inv _art (inv_id,art_id,amount) VALUES  ("   + obj.getInvoiceId() +"," +obj.getArticleId() +"," + obj.getAmount() +   ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean delete(InvoiceArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM inv_art a WHERE a.id = ?");
			int etat  = state.executeUpdate();
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
			PreparedStatement state = conn.prepareStatement(" UPDATE  inv _art (id,inv_id,art_id,amount)  VALUES  (" + obj.getId()+","  + obj.getInvoiceId() +"," +obj.getArticleId() +"," + obj.getAmount() +   ")");
			int etat  = state.executeUpdate();
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
		try {
			invoicesArticles = new ArrayList<InvoiceArticle>();
			invoicesArticles =null;
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM inv_art");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			  do {
				  invoiceArticle =  new InvoiceArticle(result.getInt("id"),result.getInt("inv_id"),result.getInt("art_id"),result.getInt("amount"));
					invoicesArticles.add(invoiceArticle);
			  }while(result.next());
		}		
			else {
				System.out.println("Table articles  is empty");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return invoicesArticles;
	}

}

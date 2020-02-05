package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.InvoiceArticle;
public class InventoryArticleDAO extends DAO<InvoiceArticle> {
	private ArrayList<InvoiceArticle> InvoiceArticles;

	public InventoryArticleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(InvoiceArticle obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO  inv _art (inv_id,art_id,amount) VALUES  (" +","  + obj.getInvoiceId() +"," +obj.getArticleId() +"," + obj.getAmount() +   ")");
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(InvoiceArticle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public InvoiceArticle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InvoiceArticle> findAll() {
		return null;
	}

}

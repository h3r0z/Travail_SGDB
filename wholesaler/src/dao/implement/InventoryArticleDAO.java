package dao.implement;
import java.sql.Connection;
import dao.DAO;
import model.InvoiceArticle;
public class InventoryArticleDAO extends DAO<InvoiceArticle> {

	public InventoryArticleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(InvoiceArticle obj) {
		// TODO Auto-generated method stub
		return false;
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

}

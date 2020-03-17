package dao;

import java.sql.Connection;

import dao.implement.ArticleDAO;
import dao.implement.ClientDAO;
import dao.implement.HistoryArticleDAO;
import dao.implement.InvoiceArticleDAO;
import dao.implement.InvoiceDAO;
import dao.implement.UserDAO;
import dao.implement.VatDAO;
import model.Article;
import model.Client;
import model.HistoryArticle;
import model.Invoice;
import model.InvoiceArticle;
import model.User;
import model.Vat;
import singleton.BDDConnexion;

public class DAOFactory {
	protected static final Connection conn = BDDConnexion.getInstance();
	public static DAO<Article> getArticleDAO() {
		return new ArticleDAO(conn);
	}
	public static DAO<Client> getClientDAO() {
		return new ClientDAO(conn);
	}
	
	public static DAO<HistoryArticle> getHistoryArticleDAO() {
		return new HistoryArticleDAO(conn);
	}
	public static DAO<InvoiceArticle> getInvoiceArticleDAO() {
		return new InvoiceArticleDAO(conn);
	}
	public static DAO<Invoice> getInvoiceDAO() {
		return new InvoiceDAO(conn);
	}
	public static DAO<User> getUserDAO() {
		return new UserDAO(conn);
	}
	public static DAO<Vat> getVatDAO() {
		return new VatDAO(conn);
	}

}

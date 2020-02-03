package dao.implement;
import java.sql.Connection;

import dao.DAO;
import model.Article;
public class ArticleDAO extends DAO<Article>{

	public ArticleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Article obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Article find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

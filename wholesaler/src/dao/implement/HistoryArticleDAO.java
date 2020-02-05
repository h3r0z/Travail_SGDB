package dao.implement;
import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HistoryArticle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HistoryArticle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HistoryArticle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HistoryArticle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

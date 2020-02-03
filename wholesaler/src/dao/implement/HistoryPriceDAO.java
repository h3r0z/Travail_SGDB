package dao.implement;
import java.sql.Connection;

import dao.DAO;
import model.HistoryArticle;
public class HistoryPriceDAO extends DAO<HistoryArticle>{

	public HistoryPriceDAO(Connection conn) {
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

}

package dao.implement;
import java.sql.Connection;

import dao.DAO;
import model.HistoryPrice;
public class HistoryPriceDAO extends DAO<HistoryPrice>{

	public HistoryPriceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(HistoryPrice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HistoryPrice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HistoryPrice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HistoryPrice find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

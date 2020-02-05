package dao.implement;
import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import model.Vat;
public class VatDAO extends DAO<Vat>{

	public VatDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Vat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vat obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vat find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package dao.implement;
import model.Invoice;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;

public class InvoiceDAO extends DAO<Invoice>{

	public InvoiceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Invoice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Invoice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Invoice obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Invoice find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Invoice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

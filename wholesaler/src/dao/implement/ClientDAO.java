package dao.implement;

import java.sql.Connection;

import dao.DAO;
import model.Client;
public class ClientDAO extends DAO<Client>{

	public ClientDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client find(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}

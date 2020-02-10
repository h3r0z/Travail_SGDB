package dao.implement;
import model.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;

public class InvoiceDAO extends DAO<Invoice>{

	public InvoiceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Invoice obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO  invoices (id,number,date,client_id) VALUES  ("   + obj.getId() +"," +obj.getNumber() +"," + 
			obj.getDateInvoice() +","+obj.getClientId() +   ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Invoice obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM invoices a WHERE a.id = ?");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Invoice obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE  invoices (id,number,date,client_id) VALUES  (" + obj.getId() +"," +obj.getNumber() +"," + 
					obj.getDateInvoice() +","+obj.getClientId() +   ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Invoice find(int id) {
		Invoice invoice = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM invoices a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				invoice = new Invoice(result.getInt("id"),result.getInt("number"),result.getDate("date"),result.getInt("client_Id"),result.getInt("user_Id"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération invoices   avec l ídentifiant :  " + id);
		}
		return invoice;
	}

	@Override
	public ArrayList<Invoice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

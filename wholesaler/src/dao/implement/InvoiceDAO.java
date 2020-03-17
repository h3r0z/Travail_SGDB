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
		int newId=0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement("SELECT MAX(id) from invoices");
			ResultSet resultSelect = stateSelect.executeQuery();
			if(resultSelect.next() ==true) {
				newId = resultSelect.getInt(1)+1;
				System.out.println("Le dernier index de la table histo art "   + (newId-1) );

				obj.setId(newId);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  invoices (id,number,date,client_id,user_id) VALUES  ("   + obj.getId() +"," +obj.getNumber() +",'" + 
						obj.getDateInvoice() +"',"+obj.getClientId() +"," + obj.getUserId() +   ")");
				stateSelect.close();
				resultSelect.close();
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("la facture  avec l'id :  " + obj.getId() + " a bien été créer");
				return true;
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  invoices (id,number,date,client_id,user_id) VALUES  ("   + obj.getId() +"," +obj.getNumber() +",'" + 
						obj.getDateInvoice() +"',"+obj.getClientId() +"," + obj.getUserId() +   ")");
				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("la facture  avec l'id :  " + obj.getId() + " a bien été créer");				
				return true;
			}
		}catch(SQLException e ) {
			System.out.println(e.getMessage());
			return false;
		}
	}
/*
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
*/
	@Override
	public boolean delete(Invoice obj) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateDisable = conn.prepareStatement(" SET foreign_key_checks = 0" );
			int etat = stateDisable.executeUpdate();
			stateDisable.close();
			PreparedStatement state = conn.prepareStatement(" DELETE FROM invoices  WHERE id = "+obj.getId());
			etat  = state.executeUpdate();
			state.close();
			PreparedStatement stateInit = conn.prepareStatement("SET foreign_key_checks = 1" );
			etat = stateInit.executeUpdate();
			stateInit.close();
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("La facture avec l id : " + obj.getId() + " a été supprimé");
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
			PreparedStatement state = conn.prepareStatement(" UPDATE  invoices SET number = " +obj.getNumber() +",date ='" + 
					obj.getDateInvoice() +"', client_id = "+obj.getClientId() + ", user_id = "+ obj.getUserId() +" WHERE id = " + obj.getId());
			int etat  = state.executeUpdate();
			System.out.println("La facture avec l id : "  + obj.getId() + " a bien été modifié ");
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
				invoice = new Invoice(result.getInt("id"),result.getInt("number"),result.getString("date"),result.getInt("client_Id"),result.getInt("user_Id"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération invoices   avec l'iddentifiant :  " + id);
		}
		return invoice;
	}

	@Override
	public ArrayList<Invoice> findAll() {
		Invoice invoice = null;
		ArrayList<Invoice> invoices = null;
		try {
			invoices = new ArrayList<Invoice>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM invoices");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			while(result.next()) {
				  invoice = new Invoice(result.getInt("id"),result.getInt("number"),result.getString("date"),result.getInt("client_Id"),result.getInt("user_Id"));
				  invoices.add(invoice);
			}
		}		
			else {
				System.out.println("Table invoices  est vide");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return invoices;
	}




}

package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.Client;
public class ClientDAO extends DAO<Client>{
	

	public ClientDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean create(Client obj) {
		int newId=0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement("SELECT MAX(id) from clients");
			ResultSet resultSelect = stateSelect.executeQuery();
			if(resultSelect.next() ==true) {
				newId = resultSelect.getInt(1)+1;
				obj.setId(newId);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO clients (id,lastname,firstname,country,city,zipcode,tel,adress,active)  VALUES  (" +obj.getId() + ",'" +  obj.getLastname() +"','"  + obj.getFirstname()+"','" + obj.getCountry() + "','"+  
						obj.getCity()+  "','"+  obj.getZipCode()+ "','"+  obj.getTel() + "','"+  obj.getAdress()+ "'," + obj.isActive()  +  ")");
				stateSelect.close();
				resultSelect.close();
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("Le client " + obj.getFirstname() + " a été crée ");
				return true;
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO clients (id,lastname,firstname,country,city,zipcode,tel,adress,active)  VALUES  (" +obj.getId() + ",'" +  obj.getLastname() +"','"  + obj.getFirstname()+"','" + obj.getCountry() + "','"+  
						obj.getCity()+  "','"+  obj.getZipCode()+ "','"+  obj.getTel() + "','"+  obj.getAdress()+ "'," + obj.isActive()  +  ")");
				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("Le client " + obj.getFirstname() + " a été crée ");
				return true;
			}
		}catch(SQLException e ) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/*
	@Override
	public boolean create(Client obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO clients (lastname,firstname,country,city,zipcode,tel,adress,active)  VALUES  (" + obj.getLastname() +","  + obj.getFirstname()+"," + obj.getCountry() + ","+  
			obj.getCity()+  ","+  obj.getZipCode()+ ","+  obj.getTel() + ","+  obj.getAdress()+ "," + obj.isActive()  +  ")");
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
	public boolean delete(Client obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE  clients  SET active = false WHERE id = ?");
			state.setInt(1, obj.getId());
			int etat  = state.executeUpdate();
			System.out.println("Le client  avec l id " + obj.getId() + " " +" a été supprimé" );
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
/*
	@Override
	public boolean delete(Client obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM clients a WHERE a.id = ?");
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
	public boolean update(Client obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE clients SET lastname = '" + obj.getLastname() + 
			"',firstname  = '" + obj.getFirstname()  +"',country = '"  + obj.getCountry()+ "',city = '" + obj.getCity()  + 
			"',zipcode = '" + obj.getZipCode() +  "',tel = '" + obj.getTel()+ "',adress = '" + obj.getAdress()  + "',active= " +obj.isActive() +"  WHERE id = " + obj.getId()  );
			int etat  = state.executeUpdate();
			System.out.println("Le client avec l id "  +obj.getId() +  " a été bien modifier");
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Client find(int id) {
		Client client = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM clients c WHERE c.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.next()) {
				client = new Client(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("adress"),
				result.getString("country"),result.getString("zipcode"),result.getString("tel"),result.getString("city"),result.getBoolean("active"));
				return client;
				
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération du client avec l'identifiant :  " + id);
		}
		return client;
	}

	@Override
	public ArrayList<Client> findAll() {
		Client client = null;
		ArrayList<Client> clients = null;
		try {
		clients = new ArrayList<Client>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM clients");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			while(result.next()) {
				client = new Client(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("adress"),
				result.getString("country"),result.getString("zipcode"),result.getString("tel"),result.getString("city"),result.getBoolean("active"));
				clients.add(client);
			}
		}
		else {
			System.out.println("Table Clients  est vide");
		}
	} catch (SQLException e) {
		System.out.println("Problème avec la récupération de la DB " + e);	
	}
	return clients;
	}



}

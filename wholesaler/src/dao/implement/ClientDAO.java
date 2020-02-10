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

	@Override
	public boolean update(Client obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE clients (id,lastname,firstname,country,city,zipcode,tel,adress,active) SET id = " + obj.getId() + " ,lastname = " + obj.getLastname() + 
			",firstname  = " + obj.getFirstname()  +",country = "  + obj.getCountry()+ ",city = " + obj.getCity()  + 
			",zipcode = " + obj.getZipCode() +  ",tel = " + obj.getTel()+ ",adress = " + obj.getAdress()  + ",active=" +obj.isActive() +")"  );
			int etat  = state.executeUpdate();
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
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM clients a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				client = new Client(result.getInt(id),result.getString("lastname"),result.getString("firstname"),result.getString("adress"),
				result.getString("country"),result.getString("zipcode"),result.getString("tel"),result.getString("city"),result.getBoolean("active"));
				
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération du client avec l ídentifiant :  " + id);
		}
		return client;
	}

	@Override
	public ArrayList<Client> findAll() {
		Client client = null;
		ArrayList<Client> clients = null;
		try {
		clients = new ArrayList<Client>();
		clients =null;
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM clients");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
		  do {
			  client = new Client(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("adress"),
			result.getString("country"),result.getString("zipcode"),result.getString("tel"),result.getString("city"),result.getBoolean("active"));
			  clients.add(client);
		  }while(result.next());
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

package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.Client;
public class ClientDAO extends DAO<Client>{
	private ArrayList<Client> clients;

	public ClientDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Client obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO clients VALUES  (" + obj.getLastname() +","  + obj.getFirstname()+"," + obj.getCountry() + ","+  obj.getCity()+  ","+  obj.getZipCode()+ ","+  obj.getTel() + ","+  obj.getAdress()+   ")");
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
			PreparedStatement state = conn.prepareStatement(" UPDATE clients SET id = " + obj.getId() + " ,lastname = " + obj.getLastname() + 
			",firstname  = " + obj.getFirstname()  +",country = "  + obj.getCountry()+ ",city = " + obj.getCity()  + 
			",zipcode = " + obj.getZipCode() +  ",tel = " + obj.getTel()+ ",adress = " + obj.getAdress()  +")"  );
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
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM articles a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				client = new Client(result.getInt(id),result.getString("lastname"),result.getString("firstname"),result.getString("adress"),
				result.getString("country"),result.getString("zipcode"),result.getString("tel"),result.getString("city"));
				
			}
		} catch (SQLException e) {
			System.out.println("Probleme de r�cup�ration de article avec l �dentifiant :  " + id);
		}
		return client;
	}

	@Override
	public ArrayList<Client> findAll() {
		Client client = null;
		try {
		clients = new ArrayList<Client>();
		clients =null;
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM clients");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
		  do {
			  client = new Client(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("adress"),
			result.getString("country"),result.getString("zipcode"),result.getString("tel"),result.getString("city"));
			  clients.add(client);
		  }while(result.next());
		}
		else {
			System.out.println("Table articles  is empty");
		}
	} catch (SQLException e) {
		System.out.println("Probl�me avec la r�cup�ration de la DB " + e);	
	}
	return clients;
	}



}

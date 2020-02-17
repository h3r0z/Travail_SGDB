package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.User;
public class UserDAO extends DAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(User obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO  users (id,lastname,firstname,login,password) VALUES  ("   + obj.getId() +"," +obj.getFirstname() +"," + obj.getLogin() +"," + obj.getPassword() +   ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean delete(User obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE users u (activate) VALUES u.activate = 0 WHERE a.id = ?");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
/*
	@Override
	public boolean delete(User obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM users a WHERE a.id = ?");
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
	public boolean update(User obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE  users(id,lastname,firstname,login,password,activate) VALUES  (" +  obj.getId() +"," +obj.getFirstname() +"," + obj.getLogin() +"," + obj.getPassword() + "," + obj.isActive() +    ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public User find(int id) {
		User user = null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM users a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				user = new User(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("login"),result.getString("password"),result.getBoolean("activate"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération de invoice Article  avec l ídentifiant :  " + id);
		}
		return user;
	}

	@Override
	public ArrayList<User> findAll() {
		User user = null;
		ArrayList<User> users =null;
		try {
			users = new ArrayList<User>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM users");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			  do {
					user = new User(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("login"),result.getString("password"),result.getBoolean("activate"));
					users.add(user);
			  }while(result.next());
		}		
			else {
				System.out.println("Table users  is empty");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return users;
	}

}

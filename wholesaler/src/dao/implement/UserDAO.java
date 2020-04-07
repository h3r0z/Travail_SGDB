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
		int newId;
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement(" SELECT MAX(id) from users" );
			ResultSet resultSelect  = stateSelect.executeQuery();
			if(resultSelect.next() ==true) {
				newId = resultSelect.getInt(1)+1;
				System.out.println("Le dernier index de la user  "   + (newId-1) );
				obj.setId(newId);
				stateSelect.close();
				resultSelect.close();
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  users (id,lastname,firstname,login,password,activate) VALUES  ("   + obj.getId() +",'"+ obj.getLastname() + "','" +obj.getFirstname() +"','" + obj.getLogin() +"','" + obj.getPassword() +"',"+ obj.isActive()  +  ")");
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("L'user  avec l'id :  " + obj.getId() +  " a bien été créer");
				return true;
			
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  users (id,lastname,firstname,login,password,active) VALUES  ("   + obj.getId() +",'"+ obj.getLastname() + "','" +obj.getFirstname() +"','" + obj.getLogin() +"','" + obj.getPassword() +"',"+ obj.isActive()  +  ")");
				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("L'user  avec l'id :  " + obj.getId() +  " a bien été créer");
				return true;
			}
		}catch (SQLException e ) {
			System.out.println("Problème sql lors de la création de l user avec l id : "  + obj.getId());
			return false;
		}
	}
	
/* 
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
	*/
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
			PreparedStatement state = conn.prepareStatement(" UPDATE  users SET lastname = '" +obj.getLastname() +"',firstname = '"+ obj.getFirstname() + "',login = '" + obj.getLogin() +"',password = '" + obj.getPassword() + "',activate = " + obj.isActive() + " WHERE id = ?");
			state.setInt(1,obj.getId());
			int etat  = state.executeUpdate();
			System.out.println("update avec succès avec l id : " + obj.getId() );
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
			System.out.println("Probleme de récupération de invoice Article  avec l'identifiant :  " + id);
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
			while(result.next()) {
					user = new User(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("login"),result.getString("password"),result.getBoolean("activate"));
					users.add(user);
			}
		}		
			else {
				System.out.println("Table users  is empty");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return users;
	}
	public ArrayList<User> findAllWithoutFalse() {
		User user = null;
		ArrayList<User> users =null;
		try {
			users = new ArrayList<User>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM users WHERE activate = 1");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			while(result.next()) {
					user = new User(result.getInt("id"),result.getString("lastname"),result.getString("firstname"),result.getString("login"),result.getString("password"),result.getBoolean("activate"));
					users.add(user);
			}
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

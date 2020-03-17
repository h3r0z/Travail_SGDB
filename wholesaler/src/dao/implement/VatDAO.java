package dao.implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		int newId;
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateSelect = conn.prepareStatement(" SELECT MAX(id) from vat" );
			ResultSet resultSelect  = stateSelect.executeQuery();
			if(resultSelect.next() ==true) {
				newId = resultSelect.getInt(1)+1;
				System.out.println("Le dernier index de la table vat est   "   + (newId-1) );
				obj.setId(newId);
				stateSelect.close();
				resultSelect.close();
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  vat (id,rate) VALUES  (" + obj.getId() + "," + obj.getRate() + ")");				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("Le vat  avec l'id :  " + obj.getId() +  " a bien été créer");
				return true;
			
			}
			else {
				obj.setId(1);
				PreparedStatement stateInsert = conn.prepareStatement(" INSERT INTO  vat (id,rate) VALUES  (" + obj.getId() + "," + obj.getRate() + ")");				
				stateInsert.executeUpdate();
				stateInsert.close();
				conn.commit();
				conn.setAutoCommit(true);
				System.out.println("Le vat   avec l'id :  " + obj.getId() +  " a bien été créer");
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Vat obj) {
		try {
			conn.setAutoCommit(false);
			PreparedStatement stateDisable = conn.prepareStatement(" SET foreign_key_checks = 0" );
			int etat = stateDisable.executeUpdate();
			stateDisable.close();
			PreparedStatement state = conn.prepareStatement(" DELETE FROM vat  WHERE id = "+obj.getId());
			etat  = state.executeUpdate();
			state.close();
			PreparedStatement stateInit = conn.prepareStatement("SET foreign_key_checks = 1" );
			etat = stateInit.executeUpdate();
			stateInit.close();
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Le vat  avec l id : " + obj.getId() + " a été supprimé");
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Vat obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" UPDATE  vat SET rate = "+ obj.getRate() + " WHERE id = ? || rate = ? ");
			state.setInt(1 , obj.getId());
			state.setDouble(2, obj.getRate());
			int etat  = state.executeUpdate();
			System.out.println("Le vat est mise à jour avec l id " + obj.getId());
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Vat find(int id) {
		Vat vat =null;
		try {
			
			PreparedStatement state = conn.prepareStatement(" SELECT * FROM vat a WHERE a.id = ?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			
			if(result.first()) {
				vat = new Vat(result.getInt("id"),result.getDouble("rate"));
			}
		} catch (SQLException e) {
			System.out.println("Probleme de récupération de vat  avec l'identifiant :  " + id);
		}
		return vat;
	}
	@Override
	public ArrayList<Vat> findAll() {
		Vat vat = null;
		ArrayList<Vat> vats = null;
		try {
			vats = new ArrayList<Vat>();
		PreparedStatement state = conn.prepareStatement(" SELECT * FROM vat");
		ResultSet result = state.executeQuery();
		if (result != null) 
		{
			  while(result.next()) {
					vat = new Vat(result.getInt("id"),result.getDouble("rate"));
					vats.add(vat);
			  }
		}		
			else {
				System.out.println("Table vat  is empty");
			}
		
		} catch (SQLException e) {
			System.out.println("Problème avec la récupération de la DB " + e);	
		}
		return vats;
	}

}

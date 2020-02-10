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
		try {
			PreparedStatement state = conn.prepareStatement(" INSERT INTO  vat (id,rate) VALUES  (" + obj.getId() + "," + obj.getRate() + ")");
			int etat  = state.executeUpdate();
			return etat >0? true :false;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Vat obj) {
		try {
			PreparedStatement state = conn.prepareStatement(" DELETE FROM vat a WHERE a.id = ?");
			int etat  = state.executeUpdate();
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
			PreparedStatement state = conn.prepareStatement(" UPDATE  vat(id,rate) VALUES (" + obj.getId() + "," + obj.getRate() + ")");
			int etat  = state.executeUpdate();
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
			System.out.println("Probleme de récupération de invoice Article  avec l ídentifiant :  " + id);
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
			  do {
					vat = new Vat(result.getInt("id"),result.getDouble("rate"));
					vats.add(vat);
			  }while(result.next());
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

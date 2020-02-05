package dao;

import java.sql.Connection;
import java.util.ArrayList;


public abstract class DAO<T> {
	protected Connection conn;
	
	public DAO(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * M�thode de cr�ation 
	 * @param obj : l'objet � cr�e dans BDD
	 * @return boolean;
	 * 
	 *  true : si l'objet a bien �t� cr�e en BDD
	 *  flase : si l'objet ne s'est pas cr��� en BDD
	 */
	
	public abstract boolean create(T obj);
	
	/**
	 * M�thode pour effacer
	 * @param obj : l'objet � supprimer dans la BDD
	 * @return boolean;
	 * 
	 * ture : si l'objet a bien �t� supprime� en BDD
	 * false :si l'objet ne s'est pas supprim� en BDD
	 */
	public abstract boolean delete(T obj);
	
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);
	public abstract ArrayList<T> findAll();

}

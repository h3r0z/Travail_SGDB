package dao;

import java.sql.Connection;
import java.util.ArrayList;


public abstract class DAO<T> {
	protected Connection conn;
	
	public DAO(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Méthode de création 
	 * @param obj : l'objet à crée dans BDD
	 * @return boolean;
	 * 
	 *  true : si l'objet a bien été crée en BDD
	 *  flase : si l'objet ne s'est pas crééé en BDD
	 */
	
	public abstract boolean create(T obj);
	
	/**
	 * Méthode pour effacer
	 * @param obj : l'objet à supprimer dans la BDD
	 * @return boolean;
	 * 
	 * ture : si l'objet a bien été supprimeé en BDD
	 * false :si l'objet ne s'est pas supprimé en BDD
	 */
	public abstract boolean delete(T obj);
	
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);
	public abstract ArrayList<T> findAll();

}

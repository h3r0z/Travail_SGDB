package model;

import java.sql.Date;

public class Invoice {
	private int id;
	private int number;
	private Date dateInvoice;
	private int clientId;
	private int userId;
	public Invoice(int id, int number, Date dateInvoice, int clientId,int userId) {
		super();
		this.id = id;
		this.number = number;
		this.dateInvoice = dateInvoice;
		this.clientId = clientId;
		this.userId = userId;
	}
	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDateInvoice() {
		return dateInvoice;
	}
	public void setDateInvoice(Date dateInvoice) {
		this.dateInvoice = dateInvoice;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
}

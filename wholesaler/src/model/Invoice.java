package model;

import java.sql.Date;

public class Invoice {
	private int id;
	private int number;
	private Date dateInvoice;
	private int clientId;
	public Invoice(int id, int number, Date dateInvoice, int clientId) {
		super();
		this.id = id;
		this.number = number;
		this.dateInvoice = dateInvoice;
		this.clientId = clientId;
	}
	public Invoice() {
		// TODO Auto-generated constructor stub
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

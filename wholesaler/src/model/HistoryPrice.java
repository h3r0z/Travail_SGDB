package model;
import java.sql.Date;
public class HistoryPrice {
	private int id;
	private int article_id;
	private Date dateHisto;
	private int clientId;
	private double price;
	public HistoryPrice() {
		// TODO Auto-generated constructor stub
	}
	
	public HistoryPrice(int id, int article_id, Date dateHisto, int clientId,double price) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.dateHisto = dateHisto;
		this.clientId = clientId;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public Date getDateHisto() {
		return dateHisto;
	}
	public void setDateHisto(Date dateHisto) {
		this.dateHisto = dateHisto;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	

}

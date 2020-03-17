package model;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
public class HistoryArticle {
	private int id;
	private int article_id;
	private String dateHistory;
	private double price;
	private int vatId;
	//private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public HistoryArticle() {
		// TODO Auto-generated constructor stub
	}
	
	public HistoryArticle(int id, int article_id, String dateHistory,double price,int vatId) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.dateHistory = dateHistory;
		this.price = price;
		this.vatId = vatId;
	}
	public HistoryArticle(int article_id, String dateHistory,double price,int vatId) {
		super();
		this.article_id = article_id;
		this.dateHistory = dateHistory;
		this.price = price;
		this.vatId = vatId;
	}



	public String getDateHistory() {
		return dateHistory;
	}

	public void setDateHistory(String dateHistory) {
		this.dateHistory = dateHistory;
	}

	public int getVatId() {
		return vatId;
	}

	public void setVatId(int vatId) {
		this.vatId = vatId;
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

	
	

}

package model;


public class Article {
	private int id;
	private String name;
	private boolean available;
	private int stock;
	private String description;
	public Article(int id, String name, boolean available, int stock, String description) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
		this.stock = stock;
		this.description = description;
	}
	public Article() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}

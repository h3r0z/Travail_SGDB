package model;

public class Vat {
	private int id;
	private double rate;
	
	public Vat(int id, double rate) {
		super();
		this.id = id;
		this.rate = rate;
	}
	public Vat(int id ) {
		super();
		this.id = id;
	}
	public Vat() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}

}

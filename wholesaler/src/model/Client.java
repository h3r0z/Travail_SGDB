package model;

public class Client {
	private int id;
	private String lastname;
	private String firstname;
	private String adress;
	private String country;
	private String zipCode;
	private String tel;
	private String city;
	private boolean active;

	
	public Client(int id, String lastname, String firstname, String adress, String country, String zipCode,
			String tel,String city,boolean active) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.country = country;
		this.zipCode = zipCode;
		this.tel = tel;
		this.city = city;
		this.active = active;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

}

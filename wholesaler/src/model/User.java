package model;

public class User {
	private int id;
	private String lastname;
	private String firstname;
	private String login;
	private String password;
	private boolean active;
	public User(int id, String lastname, String firstname, String login, String password,boolean active) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
		this.active = active;
	}
	public User( String lastname, String firstname, String login, String password,boolean active) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.login = login;
		this.password = password;
		this.active = active;
	}
	public User(int id) {
		super();
		this.id = id;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

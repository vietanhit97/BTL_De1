package entity;

public class Account {
	private int id ;
	private String name ;
	private String email;
	private String password ;
	private String adreess;
	private int role;
	
	public Account() {
		super();
	}

	public Account(int id, String name, String email, String password, String adreess, int role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.adreess = adreess;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdreess() {
		return adreess;
	}

	public void setAdreess(String adreess) {
		this.adreess = adreess;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
}

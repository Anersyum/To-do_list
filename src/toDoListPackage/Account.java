package toDoListPackage;

public class Account {

	private String userName, email, password;
	
	public Account(String userName, String email, String password) {
		
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public String getUserName() {
		
		return userName;
	}

	public String getPassword() {
		
		return password;
	}
}

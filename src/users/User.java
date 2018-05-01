package users;

import java.io.Serializable;

public abstract class User implements Serializable{
	protected String userName;

	public User(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
	
}

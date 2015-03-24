package net.slipp.user;

import net.slipp.db.Database;

public class User {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	private String userId;
	 private String password;
	 private String name;
	 private String email;

	public User(String userId, String pasword, String name, String email) {
		super();
		this.userId = userId;
		this.password = pasword;
		this.name = name;
		this.email = email;
	}
	
	public String getUserId(){
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public boolean matchPassword(String newPassword) {
		return this.password.equals(newPassword);
	}
	
	public static boolean login(String thisisId, String password) throws UserNotFoundException, PasswordMismatchException {
		User user = Database.findByUserId(thisisId);
		
		if(user == null){
			throw new UserNotFoundException();
		}
		if(!user.matchPassword(password)){
			throw new PasswordMismatchException();
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pasword=" + password + ", name="
				+ name + ", email=" + email + "]";
	}

	
}

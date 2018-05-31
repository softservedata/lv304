package com.softserve.edu.regres.data.users;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	ILogin setLastname(String lastname);
}

interface ILogin {
	IPassword setLogin(String login);
}

interface IPassword {
	IRole setPassword(String password);
}

interface IRole {
	IUserBuilder setRole(String role);
}

interface IUserBuilder {
	IUserBuilder setEmail(String email);
	IUserBuilder setAddress(String address);
	IUser build();
}

// Pojo, Bean
public class User implements IFirstname, ILastname,
		ILogin, IPassword, IRole, IUserBuilder, IUser {

	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String role;
	private String email;		// not required
	private String address;		// not required
	
	// 1.
//	public User(String firstname, String lastname,
//			String login, String password, String role,
//			String email, String address) {
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.login = login;
//		this.password = password;
//		this.role = role;
//		this.email = email;
//		this.address = address;
//	}

	// 2.
//	public User() {
//	}
	// 4.
	private User() {
	}

	// 4.
	//public static User get() {
	// 5.
	public static IFirstname get() {
		return new User();
	}
	
	// setters
	
	// 2.
	//public void setFirstname(String firstname) {
	// 3.
	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ILogin setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public IPassword setLogin(String login) {
		this.login = login;
		return this;
	}

	public IRole setPassword(String password) {
		this.password = password;
		return this;
	}

	public IUserBuilder setRole(String role) {
		this.role = role;
		return this;
	}

	public IUserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public IUserBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	
	// 5.
	//public User build() {
	// 6.
	public IUser build() {
		return this;
	}
	
	// getters
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

}

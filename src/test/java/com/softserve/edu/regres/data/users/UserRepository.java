package com.softserve.edu.regres.data.users;

import java.util.List;

public final class UserRepository {
	private static volatile UserRepository instance = null;

	private UserRepository() {
	}

	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}
	
	public IUser userWork() {
		return User.get()
			.setFirstname("firstname7")
			.setLastname("lastname7")
			.setLogin("work")
			.setPassword("qwerty")
			.setRole("role7")
			.setEmail("email7")
			.setAddress("address7")
			.build();
	}
	
	public List<IUser> customers(String filename) {
		//return new Reader().fromExcel(filename);
		return null;
	}

}

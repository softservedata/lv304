package com.softserve.edu.data;

public final class UserRepositoryStatic {

    private UserRepositoryStatic() {
    }
    
    public static IUser getAdmin() {
        return User.get()
              .setFirstname("firstname11_admin")
              .setLastname("lastname11_admin")
              .setLogin("login11_admin")
              .setPassword("password11_admin")
              .setEmail("email11_admin")
              .setAddress("address11_admin")
              .build();
    }
    
    public static IUser getCustomer() {
        return User.get()
              .setFirstname("firstname11_customer")
              .setLastname("lastname11_customer")
              .setLogin("login11_customer")
              .setPassword("password11_customer")
              .setEmail("email11_customer")
              .setAddress("address11_customer")
              .build();
    }

}

package com.softserve.edu.data;

import java.util.List;

import com.softserve.edu.tools.CSVReader;
import com.softserve.edu.tools.ExcelReader;

public final class UserRepository {

    private static volatile UserRepository instance = null;
    
    private UserRepository() {
    }
    
    public static UserRepository get() { // Do not use synchronized
        if (instance == null) {
            synchronized(UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }
    
    public IUser admin() {
        return User.get()
              .setFirstname("firstname11_admin")
              .setLastname("lastname11_admin")
              .setLogin("login11_admin")
              .setPassword("password11_admin")
              .setEmail("email11_admin")
              .setAddress("address11_admin")
              .build();
    }

    public IUser customer() {
        return User.get()
              .setFirstname("firstname11_customer")
              .setLastname("lastname11_customer")
              .setLogin("login11_customer")
              .setPassword("password11_customer")
              .setEmail("email11_customer")
              .setAddress("address11_customer")
              .build();
    }

    public List<IUser> usersFromCSV() {
        return usersFromCSV("users.csv");
    }
    
    public List<IUser> usersFromCSV(String fileName) {
        return User.getByList(new CSVReader(fileName).getAllCells());
    }

    public List<IUser> usersFromExcel() {
        return usersFromExcel("users.xlsx");
    }
    
    public List<IUser> usersFromExcel(String fileName) {
        return User.getByList(new ExcelReader(fileName).getAllCells());
    }

}

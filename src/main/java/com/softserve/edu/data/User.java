package com.softserve.edu.data;

import java.util.ArrayList;
import java.util.List;

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
    IUserBuiled setPassword(String password);
}

interface IUserBuiled {
    IUserBuiled setEmail(String email);

    IUserBuiled setAddress(String address);

    // 5.
    //User build();
    //
    // 6.
    IUser build();
}

// 4.
//public class User {
// 5.
//public class User implements IFirstname, ILastname,
//        ILogin, IPassword, IUserBuiled {
// 6.
public class User implements IFirstname, ILastname,
        ILogin, IPassword, IUserBuiled, IUser {

    // TODO Convert to enum
    private static final int COLUMN_FIRSTNAME = 0;
    private static final int COLUMN_LASTNAME = 1;
    private static final int COLUMN_LOGIN = 2;
    private static final int COLUMN_PASSWORD = 3;
    private static final int COLUMN_EMAIL = 4;
    private static final int COLUMN_ADDRESS = 5;
    //
    private static final String EMAIL_SEPARATOR = "@";
    
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email;
    private String address;

    // 1.
//    public User(String firstname, String lastname, String login, String password, String email, String address) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.login = login;
//        this.password = password;
//        this.email = email;
//        this.address = address;
//    }

    // 2.
    //public User() {
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
    
    // 3. Add Fluent Interface. Return Object
    //public void setFirstname(String firstname) {
    //public User setFirstname(String firstname) {
    // 5.
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

    public IUserBuiled setPassword(String password) {
        this.password = password;
        return this;
    }

    public IUserBuiled setEmail(String email) {
        this.email = email;
        return this;
    }

    public IUserBuiled setAddress(String address) {
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

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // business
    
    @Override
    public String toString() {
        return "\nFirstname " + getFirstname()
            + "\nLastname " + getLastname()
            + "\nLogin " + getLogin()
            + "\nPassword " + getPassword()
            + "\nEmail " + getEmail()
            + "\nAddress " + getAddress();
    }
    
    public static List<IUser> getByList(List<List<String>> rows) {
        List<IUser> result = new ArrayList<>();
        for (List<String> currentRow : rows) {
            if (currentRow.get(COLUMN_EMAIL).contains(EMAIL_SEPARATOR)) {
                IUser user = User.get()
                    .setFirstname(currentRow.get(COLUMN_FIRSTNAME))
                    .setLastname(currentRow.get(COLUMN_LASTNAME))
                    .setLogin(currentRow.get(COLUMN_LOGIN))
                    .setPassword(currentRow.get(COLUMN_PASSWORD))
                    .setEmail(currentRow.get(COLUMN_EMAIL))
                    .setAddress(currentRow.get(COLUMN_ADDRESS))
                    .build();
                result.add(user);
            }
        }
        return result;
    }

}

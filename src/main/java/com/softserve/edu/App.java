package com.softserve.edu;

import java.util.List;

import com.softserve.edu.data.IUser;
import com.softserve.edu.data.UserRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 1. Use Constructor. Too many Parameters
        //User user = new User("firstname", "lastname", "login", "password", "email", "address");
        //System.out.println("user.login = " + user.getLogin());
        //
        // 2. Add Default Constructor. Use Setters
//        User user = new User();
//        user.setFirstname("firstname");
//        user.setLastname("lastname");
//        user.setLogin("login");
//        user.setPassword("password");
//        user.setEmail("email");
//        user.setAddress("address");
//        System.out.println("user.login = " + user.getLogin());
        //
        // 3. Add Fluent Interface
//        User user = new User()
//            .setFirstname("firstname")
//            .setLastname("lastname")
//            .setLogin("login")
//            .setPassword("password")
//            .setEmail("email")
//            .setAddress("address");
//        System.out.println("user.login = " + user.getLogin());
        //
        // 4. Add Static Factory
//        User user = User.get()
//                .setFirstname("firstname")
//                .setLastname("lastname")
//                //.setLogin("login")
//                .setPassword("password")
//                .setEmail("email")
//                .setAddress("address");
//        System.out.println("user.login = " + user.getLogin().toLowerCase());
        //
        // 5. Add Builder
//        User user = User.get()
//                .setFirstname("firstname11")
//                .setLastname("lastname11")
//                .setLogin("login11")
//                .setPassword("password11")
//                .setEmail("email11")
//                .setAddress("address11")
//                .build();
//        System.out.println("user.login = " + user.setLogin("aaa")); // Error
//        System.out.println("user.login = " + user.getLogin());
        //
        // 6. Dependency Inversion
//        IUser user = User.get()
//                .setFirstname("firstname11")
//                .setLastname("lastname11")
//                .setLogin("login11")
//                .setPassword("password11")
//                .setEmail("email11")
//                .setAddress("address11")
//                .build();
//        //System.out.println("user.login = " + ((User)user).setLogin("aaa")); // Error
//        System.out.println("user.login = " + user.getLogin());
        //
        // 7. Move class User to other package
        // Compile Error. No Access to interfaces
        //
        // 8. Add Repository (all method static, Singleton, enum)
        // 9. Add Singleton
        //IUser user = UserRepository.get().admin();
//        IUser user = UserRepositoryStatic.getAdmin();
//        System.out.println("user.login = " + user.getLogin());
        //
        // 10. Read from CSV, Excel
        //List<IUser> users = UserRepository.get().usersFromCSV();
        List<IUser> users = UserRepository.get().usersFromExcel();
        for (IUser currentUser : users) {
            System.out.println(currentUser);
        }
    }
}

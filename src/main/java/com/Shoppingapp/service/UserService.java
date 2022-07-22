/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.service;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.User;
import com.Shoppingapp.repositories.UserRepository;
import com.isimtl.authentication.HashedPassword;
import com.isimtl.authentication.PasswordHasher;
import com.isimtl.authentication.PasswordResult;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author isi
 */
public class UserService {
  private UserRepository repository;
    public UserService() {
        repository = new UserRepository();
    }

    public User addUser(String username,String password,String confirmpassword,String name,String dateofbirth) throws Userexception, ClassNotFoundException, SQLException{
        if (username!=null || username!="") {
            if (repository.checkUsernameExists(username)) {
                throw new Userexception("Username not available");
            }
        }
        if (username==null || username.isEmpty()) { 
            throw new Userexception("Username was empty");
        }
        if (password==null || password.isEmpty()) {
            throw new Userexception("Password was empty");
        }
        if (!confirmpassword.equals(password)) {
            throw new Userexception("Passwords did not match");
        }
        if (name==null || "".equals(name)) {
            throw new Userexception("Name must not be empty");
        }
        if (dateofbirth==null || dateofbirth.isEmpty()) {
            throw new Userexception("Date of Birth must not be empty");
        }
        HashedPassword newHashedPassword; 
        newHashedPassword = PasswordHasher.hashPassword(password);
        byte[] salt = newHashedPassword.getSalt();
        byte[] hashedpassword = newHashedPassword.getHash();
        
        LocalDate dob = LocalDate.parse(dateofbirth);
        if (dob.isAfter(LocalDate.now())) {
           throw new Userexception("Date of birth is a future date");  
        }
        User user = new User(username, salt,hashedpassword,name,dob);
        return repository.addUser(user);
        
    }

//    public User checkLoginAuth(String username, String password) throws Userexception {
//        if (username == null || username.isEmpty()) {
//            throw new Userexception("Username was empty");
//        }
//        if (password == null || password.isEmpty()) {
//            throw new Userexception("Password was empty");
//        }
//        HashedPassword newHashedPassword; 
//        newHashedPassword = PasswordHasher.hashPassword(password);
//        if (userLoginData.containsKey(username)) {
//            if (PasswordHasher.checkPassword(password, userLoginData.get(username)) == PasswordResult.Correct) {
//                return userData.get(username);
//            }
//            else{
//                throw new Userexception("Incorrect Credentials");
//            }
//        }else{
//           throw new Userexception("Incorrect Credentials : Username or Password is incorrect");
//        }
//    }

    public User checkLoginAuth(String username, String password) throws Userexception, ClassNotFoundException, SQLException {
        if (username == null || username.isEmpty()) {
            throw new Userexception("Username was empty");
        }
        if (password == null || password.isEmpty()) {
            throw new Userexception("Password was empty");
        }
        
        if (repository.checkUsernameExists(username)) {
              User user = repository.tryLogin(username);
            HashedPassword finalpassword = new HashedPassword(user.getSalt(), user.getHashedpassword());
            if (PasswordHasher.checkPassword(password,finalpassword).equals(PasswordResult.Correct)) {
                return user;
            }
            else{
                throw new Userexception("Incorrect Credentials !");
            }
            }
        else{
          throw new Userexception("Incorrect Credentials !");
        }    
    }  
}

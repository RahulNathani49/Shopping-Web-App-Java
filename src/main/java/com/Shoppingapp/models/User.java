/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.models;

import com.Shoppingapp.exceptions.Userexception;
import com.isimtl.authentication.HashedPassword;
import java.time.LocalDate;

/**
 *
 * @author isi
 */
public class User {
    private String username;
    private byte[] salt;
    private byte [] hashedpassword;
    private String name;
    private LocalDate dateOfBirth;
    public User(String username,byte[] salt,byte [] hashedpassword, String name, LocalDate dateOfBirth) throws Userexception { 
          if (username==null || username.isEmpty()) { 
            throw new Userexception("Username was empty");
        }
         
        if (name==null || "".equals(name)) {
            throw new Userexception("Name must not be empty");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new Userexception("Date of birth is a future date");  
        }
        this.username = username;
        this.salt = salt;
        this.hashedpassword=hashedpassword;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String username, String name, LocalDate newLocaldateofbirth) {
         
        this.username = username;
        this.name = name;
        this.dateOfBirth = newLocaldateofbirth;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getHashedpassword() {
        return hashedpassword;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    
    public String getName() {
        return name;
    }

    public LocalDate getLocalDateOfBirth() {
        return dateOfBirth;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setLocalDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    @Override
    public String toString() {
        return username; 
    }
    
    
}

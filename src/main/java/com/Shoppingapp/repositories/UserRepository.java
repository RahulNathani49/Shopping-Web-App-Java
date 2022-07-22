/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.repositories;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.User;
import com.isimtl.authentication.HashedPassword;
import com.isimtl.authentication.PasswordHasher;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import sun.security.rsa.RSACore;

/**
 *
 * @author isi
 */
public class UserRepository {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public UserRepository() {
        String databaseName="ShoppingApp";
        connectionUrl="jdbc:mariadb://localhost:3315/"+databaseName;
        username="root";
        password="admin";
    }
    public boolean checkUsernameExists(String username) throws ClassNotFoundException, SQLException {
     Class.forName("org.mariadb.jdbc.Driver");
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "select username from users where username = ?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,username);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
               return true;
           }         
        }
       return false;
    }

    public User addUser(User user) throws ClassNotFoundException, SQLException {
       Class.forName("org.mariadb.jdbc.Driver");
       
       try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "insert into users values(?,?,?,?,?)";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,user.getUsername());
            statement.setBytes(2,user.getSalt());
            statement.setBytes(3,user.getHashedpassword());
            statement.setString(4,user.getName());
            statement.setString(5,user.getLocalDateOfBirth().format(DateTimeFormatter.ISO_DATE));
            int rowsaffected =  statement.executeUpdate();
            if (rowsaffected>0) {
               return user;
           }
        }
        return null;
    }

    public User tryLogin(String username) throws ClassNotFoundException, SQLException, Userexception {
            Class.forName("org.mariadb.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "select username,salt,hashedpassword,name,dateofbirth from users where username = ?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,username);
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next()) {
                return readUser(resultSet);
            }            
                }
            return null;
        }

    private User readUser(ResultSet resultSet) throws SQLException, Userexception {
        String username = resultSet.getString("username");
        byte[] salt = resultSet.getBytes("salt");
        byte[] hashedpassword = resultSet.getBytes("hashedpassword");
        String name = resultSet.getString("name");
        Date dateofbirth = resultSet.getDate("dateofbirth");
        LocalDate newLocaldateofbirth = dateofbirth.toLocalDate();
        return new User(username,salt,hashedpassword,name,newLocaldateofbirth);
    }

}

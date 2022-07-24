/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.repositories;

import com.Shoppingapp.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author isi
 */
public class CartRepository {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public CartRepository() {
        String databaseName="ShoppingApp";
        connectionUrl="jdbc:mariadb://localhost:3315/"+databaseName;
        username="root";
        password="admin";
    }
    public boolean cartExists(String username) throws ClassNotFoundException, SQLException {
       Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "select cartid from usercartmap where username = ?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()) {                  
               return true;
           }
        }
       return false;
    }

    public boolean createCart(String username) throws ClassNotFoundException, SQLException {
       Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "insert into usercartmap(username) values(?)";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,username);
            ResultSet resultSet  = statement.executeQuery();
            while (resultSet.next()) {                  
               return true;
           }
        }
       return false;
    }

    public boolean addProductToCart(int cartid,String productid) throws ClassNotFoundException, SQLException {
       Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "insert into allcarts(cartid,productid,quantity,total) values(?,?,1,(select price from products where productid = ?))";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,cartid);
            statement.setString(2,productid);
            statement.setString(3,productid);
            ResultSet resultSet  = statement.executeQuery();
            while (resultSet.next()) {                  
               return true;
            }
        }
       return false;
    }

    public boolean productExistInCart(int cartid,String productid) throws ClassNotFoundException, SQLException {
       Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "select * from allcarts where cartid=? AND productid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,cartid);
            statement.setString(2,productid);
            ResultSet resultSet  = statement.executeQuery();
            while (resultSet.next()) {                  
               return true;
            }
        }
       return false;
    }   

    public int getCartId(String username) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "select cartid from usercartmap where username = ?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,username);
            ResultSet resultSet  = statement.executeQuery();
            while (resultSet.next()) {                  
               return resultSet.getInt("cartid");
           }
        }
        return 0;
    }
}

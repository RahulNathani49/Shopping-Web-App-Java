/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.repositories;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.Product;
import com.Shoppingapp.models.UserCartItems;
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

    public ArrayList<UserCartItems> fetchCartItems(String username) throws ClassNotFoundException, SQLException, Userexception {
        Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "select * from allcarts where cartid = (select cartid from usercartmap where username = ?)";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setString(1,username);
            ArrayList<UserCartItems> cartItems = new ArrayList<>();
            ResultSet resultSet  = statement.executeQuery();
            while (resultSet.next()) {  
                cartItems.add(readNextItem(resultSet));
           }
            return cartItems;
        }
     
    }
    private UserCartItems readNextItem(ResultSet resultSet) throws SQLException, Userexception, ClassNotFoundException{
       Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
        int cartid = resultSet.getInt("cartid");
        int productid = resultSet.getInt("productid");
        int quantity = resultSet.getInt("quantity");
        double total= resultSet.getDouble("total");
            String query = "select productname,image from products where productid = ?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,productid);
            ResultSet newresultSet  = statement.executeQuery();
            if (newresultSet.next()) {
                String productName = newresultSet.getString("productname");
                String productImage = newresultSet.getString("image");
                return new UserCartItems(productid,cartid,productName , quantity, total,productImage);

           }
        }
        return null;  
    }

    public boolean addQuantity(int cartid, String productid, String quantity) throws ClassNotFoundException, SQLException,Userexception {
        Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "UPDATE allcarts " +
                " SET quantity = ? " +
                " WHERE cartid = ? AND productid=?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,Integer.parseInt(quantity)+1);
            statement.setInt(2,cartid);
            statement.setString(3,productid);

            int rowsaffected  = statement.executeUpdate();
              return rowsaffected>0;
        }
       
    }

    public boolean removeQuantity(int cartid, String productid, String quantity) throws ClassNotFoundException, SQLException {
           Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, this.username, password)){
            String query = "UPDATE allcarts " +
                " SET quantity = ? " +
                " WHERE cartid = ? AND productid=?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,Integer.parseInt(quantity)-1);
            statement.setInt(2,cartid);
            statement.setString(3,productid);

            int rowsaffected  = statement.executeUpdate();
              return rowsaffected>0;
        }
    }

    
}

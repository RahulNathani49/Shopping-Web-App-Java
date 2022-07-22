/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.repositories;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.Category;
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
public class ProductRepository {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public ProductRepository() {
        String databaseName="ShoppingApp";
        connectionUrl="jdbc:mariadb://localhost:3315/"+databaseName;
        username="root";
        password="admin";
    }

    public ArrayList<Product> fetchProductsData() throws ClassNotFoundException, SQLException, Userexception {
         Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select productid,categoryid,productname,image,price,productdescription from products";
            PreparedStatement statement =  connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(readNextProduct(resultSet));
            }
            return productList;
           
        }
    }
    
    private Product readNextProduct(ResultSet resultSet) throws SQLException, Userexception{
        
        int productid = resultSet.getInt("productid");
        int categoryid = resultSet.getInt("categoryid");
        String productname  = resultSet.getString("productname");
        String image=resultSet.getString("image");
        double price = resultSet.getDouble("price");
        String productdescription  = resultSet.getString("productdescription");
        return new Product(productid, categoryid, productname, image, price, productdescription);
    }

    public ArrayList<Category> fetchCategoryData() throws ClassNotFoundException, SQLException, Userexception {
       Class.forName("org.mariadb.jdbc.Driver");    
       try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select categoryid,categoryname from productcategory";
            PreparedStatement statement =  connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Category> categoryList = new ArrayList<>();
            while (resultSet.next()) {
                categoryList.add(readNextCategory(resultSet));
            }
            return categoryList;   
        }
    }

    private Category readNextCategory(ResultSet resultSet) throws SQLException,Userexception {
       int categoryid = resultSet.getInt("categoryid");
        String categoryname  = resultSet.getString("categoryname"); 
        return new Category(categoryid, categoryname);
    }
}

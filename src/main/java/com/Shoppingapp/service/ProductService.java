/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.service;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.Product;
import com.Shoppingapp.repositories.ProductRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isi
 */
public class ProductService {
    private final ProductRepository repository;


    public ProductService() {
        repository = new ProductRepository();
    }
       
    public ArrayList<Product> fetchProducts() throws ClassNotFoundException, SQLException, Userexception {
        try {
            return repository.fetchProductsData();
        } catch (SQLException | Userexception ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

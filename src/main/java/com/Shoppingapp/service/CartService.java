/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.service;

import com.Shoppingapp.repositories.CartRepository;
import java.sql.SQLException;

/**
 *
 * @author isi
 */
public class CartService {
    private final CartRepository repository;
    public CartService() {
        repository = new CartRepository();
    }

    public boolean addtoCart(String username, String productid) throws ClassNotFoundException, SQLException {
        if (repository.cartExists(username)) {
                   int cartid = repository.getCartId(username);

            if (repository.productExistInCart(cartid,productid)) {
                
            }
            else{
              return repository.addProductToCart(cartid,productid);
            }
        }
        else{
            repository.createCart(username);
            int cartid = repository.getCartId(username);
            if (repository.productExistInCart(cartid,productid)) {
                
            }
            else{
               return repository.addProductToCart(cartid,productid);
            }
        }
        return false;
    }
    
}

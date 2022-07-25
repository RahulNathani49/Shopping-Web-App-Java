/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.service;

import com.Shoppingapp.exceptions.Userexception;
import com.Shoppingapp.models.UserCartItems;
import com.Shoppingapp.repositories.CartRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ArrayList<UserCartItems> fetchCartItems(String username) throws ClassNotFoundException, SQLException, Userexception {
        if (repository.cartExists(username)) {
            int cartId = repository.getCartId(username);
            ArrayList<UserCartItems> usercartitems = repository.fetchCartItems(username);
            return usercartitems;
        }
        return null;
    }

    public void addQuantity(int cartid, String productid, String quantity) throws ClassNotFoundException, SQLException, Userexception{
        if (repository.productExistInCart(cartid, productid)) {
            repository.addQuantity(cartid, productid, quantity);
        }
    }

    public void removeQuantity(int cartid, String productid, String quantity) throws ClassNotFoundException, SQLException {
       if (repository.productExistInCart(cartid, productid)) {
            repository.removeQuantity(cartid, productid, quantity);
        }
    }
}

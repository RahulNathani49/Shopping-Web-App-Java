/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.models;

/**
 *
 * @author isi
 */
public class UserCartMap {
    private int cartid;
    private String username;

    public UserCartMap(int cartid, String username) {
        this.cartid = cartid;
        this.username = username;
    }

    public int getCartid() {
        return cartid;
    }

    public String getUsername() {
        return username;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.models;

/**
 *
 * @author isi
 */
public class UserCartItems {
     private int productId;
    private int cartid;
    private String productName;
    private int quantity;
    private double total;
    private String image;
    public UserCartItems(int productId,int cartid, String productName, int quantity, double total,String image) {
        this.productId = productId;
        this.cartid = cartid;
        this.image = image;
        this.productName = productName;
        this.quantity = quantity;
        this.total = total;
    }

    public int getProductId() {
        return productId;
    }

    public int getCartid() {
        return cartid;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public String getImage() {
        return image;
    }
    
}

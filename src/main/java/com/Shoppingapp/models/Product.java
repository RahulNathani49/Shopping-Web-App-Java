/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.models;

import com.Shoppingapp.exceptions.Userexception;

/**
 *
 * @author isi
 */
public class Product {
    private int productId;
    private int categoryId;
    private String productName;
    private String productImagePath;
    private double productPrice;
    private String productDescription;

    public Product(int productId, int categoryId, String productName, String productImagePath, double productPrice, String productDescription) throws Userexception {
        if (productName==null || "".equals(productName)) {
            throw new Userexception("Product name was fetched null");
        }
        if (productImagePath==null || "".equals(productImagePath) ) {
            throw new Userexception("Product image was fetched null");
        }
        if (productDescription==null || "".equals(productDescription) ) {
            throw new Userexception("Product Description was fetched null");
        }
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productImagePath = productImagePath;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }
    
}

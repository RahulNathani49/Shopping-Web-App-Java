/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Shoppingapp.models;

import java.sql.Date;

/**
 *
 * @author isi
 */
public class OrderHistory {
    private int ordercount;
    private int orderid;
    private double total;
    private Date date;


    public OrderHistory(int ordercount, int orderid, double total, Date date) {
        this.ordercount = ordercount;
        this.orderid = orderid;
        this.total = total;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    
    public int getOrdercount() {
        return ordercount;
    }

    public int getOrderid() {
        return orderid;
    }

    public double getTotal() {
        return total;
    }
    
    
}

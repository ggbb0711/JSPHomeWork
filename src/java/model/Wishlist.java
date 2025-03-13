/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author NGHIA
 */
public class Wishlist {
    private int id;
    private long custid;
    private boolean isCompleted;
    private Date createdAt;
    private Customer customer;
    private ArrayList<Car> details;

    public Wishlist(int id, long custid, boolean isCompleted, Date createdAt) {
        this.id = id;
        this.custid = custid;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }
    
    
    
    public int getId() {
        return id;
    }

    public long getCustid() {
        return custid;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustid(long custid) {
        this.custid = custid;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Car> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Car> details) {
        this.details = details;
    }
    
    
}

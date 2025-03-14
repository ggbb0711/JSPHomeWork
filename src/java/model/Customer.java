/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author bluax
 */
public class Customer implements Serializable{
    private long custID;
    private String custName;
    private String Phone;
    private String sex;
    private String custAddress;

    public Customer() {
//        custID = 0;
//        custName = "";
//        Phone = "";
//        sex = "";
//        custAddress = "";
    }
    
    public Customer(long custID, String custName, String Phone, String sex, String custAddress) {
        this.custID = custID;
        this.custName = custName;
        this.Phone = Phone;
        this.sex = sex;
        this.custAddress = custAddress;
    }

    public long getCustID() {
        return custID;
    }

    public void setCustID(long custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
    
}

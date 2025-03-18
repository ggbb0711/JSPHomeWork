/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author TNO
 */
public class SalesPerson {
    private int salesID;
    private String salesName;
    private Date birthday;
    private String sex;
    private String salesAddress;

    public SalesPerson() {
    }

    public SalesPerson(int salesID, String salesName, Date birthday, String sex, String salesAddress) {
        this.salesID = salesID;
        this.salesName = salesName;
        this.birthday = birthday;
        this.sex = sex;
        this.salesAddress = salesAddress;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalesAddress() {
        return salesAddress;
    }

    public void setSalesAddress(String salesAddress) {
        this.salesAddress = salesAddress;
    }

    @Override
    public String toString() {
        return "SalesPerson{" + "salesID=" + salesID + ", salesName=" + salesName + ", birthday=" + birthday + ", sex=" + sex + ", salesAddress=" + salesAddress + '}';
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.qe170179;

/**
 *
 * @author USER
 */
public class Customer {
    private int custID;
    private String custName;
    private int phone;
    private String sex;
    private String cusAddress; 

    public Customer() {
    }

    public Customer(int custID, String custName, int phone, String sex, String cusAddress) {
        this.custID = custID;
        this.custName = custName;
        this.phone = phone;
        this.sex = sex;
        this.cusAddress = cusAddress;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    @Override
    public String toString() {
        return "Customer{" + "custID=" + custID + ", custName=" + custName + ", phone=" + phone + ", sex=" + sex + ", cusAddress=" + cusAddress + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author bluax
 */
public class SalesInvoice {
    private int id;
    private Date invoiceDate;
    private String salesID;
    private long carID;
    private long custID;
    private Car car;
    
    public SalesInvoice() {
        id = 0;
        invoiceDate = null;
        salesID = null;
        carID = 0;
        custID = 0;
    }

    public SalesInvoice(int id, Date invoiceDate, String salesID, long carID, long custID) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.salesID = salesID;
        this.carID = carID;
        this.custID = custID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public long getCustID() {
        return custID;
    }

    public void setCustID(long custID) {
        this.custID = custID;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
    
    
}

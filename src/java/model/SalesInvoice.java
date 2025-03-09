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
    private long id;
    private Date invoiceDate;
    private long salesID;
    private long carID;
    private long custID;
    private Car car;
    private double revenue;
    

    public SalesInvoice(long id, Date invoiceDate, long salesID, long carID, long custID) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.salesID = salesID;
        this.carID = carID;
        this.custID = custID;
    }
    
    public SalesInvoice(){}

    public long getId() {
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

    public long getSalesID() {
        return salesID;
    }

    public void setSalesID(long salesID) {
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

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
    
}

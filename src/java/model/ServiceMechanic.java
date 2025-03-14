/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.math.BigDecimal;
/**
 *
 * @author USER
 */
public class ServiceMechanic {

    private int serviceTicketID;
    private int serviceID;
    private BigDecimal mechanicID;
    private int hours;
    private String commment;
    private double rate;

    public ServiceMechanic() {
    }

    public ServiceMechanic(int serviceTicketID, int serviceID, BigDecimal mechanicID, int hours, String commment, double rate) {
        this.serviceTicketID = serviceTicketID;
        this.serviceID = serviceID;
        this.mechanicID = mechanicID;
        this.hours = hours;
        this.commment = commment;
        this.rate = rate;
    }

    public int getServiceTicketID() {
        return serviceTicketID;
    }

    public void setServiceTicketID(int serviceTicketID) {
        this.serviceTicketID = serviceTicketID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public BigDecimal getMechanicID() {
        return mechanicID;
    }

    public void setMechanicID(BigDecimal mechanicID) {
        this.mechanicID = mechanicID;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}

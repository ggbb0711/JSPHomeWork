/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NGHIA
 */
public class PartUsed {
    private long serviceTicketID;
    private long partID;
    private int numberUsed;

    public PartUsed() {
    }
    private double price;
    private Parts part;
    
    public PartUsed(long serviceTicketID, long partID, int numberUsed, double price) {
        this.serviceTicketID = serviceTicketID;
        this.partID = partID;
        this.numberUsed = numberUsed;
        this.price = price;
    }

    public long getServiceTicketID() {
        return serviceTicketID;
    }

    public long getPartID() {
        return partID;
    }

    public int getNumberUsed() {
        return numberUsed;
    }

    public double getPrice() {
        return price;
    }

    public Parts getPart() {
        return part;
    }

    public void setServiceTicketID(long serviceTicketID) {
        this.serviceTicketID = serviceTicketID;
    }

    public void setPartID(long partID) {
        this.partID = partID;
    }

    public void setNumberUsed(int numberUsed) {
        this.numberUsed = numberUsed;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPart(Parts part) {
        this.part = part;
    }
    
}

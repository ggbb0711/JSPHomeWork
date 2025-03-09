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
public class Parts {
    private long partID;
    private String partName; 
    private double purchasePrice;
    private double retailPrice;

    public void setPartID(long partID) {
        this.partID = partID;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Parts(long partID, String partName, double purchasePrice, double retailPrice) {
        this.partID = partID;
        this.partName = partName;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
    }

    public long getPartID() {
        return partID;
    }

    public Parts() {
    }

    public String getPartName() {
        return partName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }
    
    
}

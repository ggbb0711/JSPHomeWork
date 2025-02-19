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
    private int partID;
    private String partName; 
    private double purchasePrice;
    private double retailPrice;

    public Parts(int partID, String partName, double purchasePrice, double retailPrice) {
        this.partID = partID;
        this.partName = partName;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
    }

    public int getPartID() {
        return partID;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.qe170179;

import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class Mechanic {
    private BigDecimal mechanicID;
    private String mechanicName;

    public Mechanic() {
    }

    public Mechanic(BigDecimal mechanicID, String mechanicName) {
        this.mechanicID = mechanicID;
        this.mechanicName = mechanicName;
    }

    public BigDecimal getMechanicID() {
        return mechanicID;
    }

    public void setMechanicID(BigDecimal mechanicID) {
        this.mechanicID = mechanicID;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    @Override
    public String toString() {
        return "Mechanic{" + "mechanicID=" + mechanicID + ", mechanicName=" + mechanicName + '}';
    }
}

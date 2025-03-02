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
public class Car {
    private long carID;
    private String serialNumber;
    private String model;
    private String colour;
    private int year;

    public Car(long carID, String serialNumber, String model, String colour, int year) {
        this.carID = carID;
        this.serialNumber = serialNumber;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public Car() {
    }

    public long getCarID() {
        return carID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }
    
    
}

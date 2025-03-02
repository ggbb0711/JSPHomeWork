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
public class CarSoldData {
    private int carSold;
    private Car car;
    private int yearSold;

    public CarSoldData() {
    }
    
    public CarSoldData(int carSold, Car car,int yearSold) {
        this.carSold = carSold;
        this.car = car;
        this.yearSold = yearSold;
    }

    public void setYearSold(int yearSold) {
        this.yearSold = yearSold;
    }

    public int getYearSold() {
        return yearSold;
    }

    public int getCarSold() {
        return carSold;
    }

    public Car getCar() {
        return car;
    }

    public void setCarSold(int carSold) {
        this.carSold = carSold;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
}

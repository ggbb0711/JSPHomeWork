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
public class CarRevenueData {
    private double carRevenue;
    private Car car;
    private int yearSold;

    public CarRevenueData(double carRevenue, Car car, int yearSold) {
        this.carRevenue = carRevenue;
        this.car = car;
        this.yearSold = yearSold;
    }

    public double getCarRevenue() {
        return carRevenue;
    }

    public Car getCar() {
        return car;
    }

    public int getYearSold() {
        return yearSold;
    }

    public void setCarRevenue(double carRevenue) {
        this.carRevenue = carRevenue;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setYearSold(int yearSold) {
        this.yearSold = yearSold;
    }
    
}

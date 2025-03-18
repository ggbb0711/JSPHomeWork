/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Service {
    private int serviceID;
    private String serviceName;
    private double hourlyRate;

    public Service() {
    }

    public Service(int serviceID, String serviceName, double hourlyRate) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.hourlyRate = hourlyRate;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", serviceName=" + serviceName + ", hourlyRate=" + hourlyRate + '}';
    }
    
    
}

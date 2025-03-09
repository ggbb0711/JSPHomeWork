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
public class TopMechanicData {
    private int ticketDone;
    private double averageRate;
    private int totalHours;
    private Mechanic mechanic;

    public TopMechanicData() {
    }

    public TopMechanicData(int ticketDone, double averageRate, int totalHours) {
        this.ticketDone = ticketDone;
        this.averageRate = averageRate;
        this.totalHours = totalHours;
    }

    public int getTicketDone() {
        return ticketDone;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setTicketDone(int ticketDone) {
        this.ticketDone = ticketDone;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
    
    
}

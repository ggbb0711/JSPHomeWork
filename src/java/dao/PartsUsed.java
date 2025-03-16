/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Parts;
import model.qe170179.ServiceTicket;

/**
 *
 * @author USER
 */
public class PartsUsed {
    private ServiceTicket tickets;
    private Parts part;
    private int numberUsed;
    private double price;

    public PartsUsed() {
    }

    public PartsUsed(ServiceTicket tickets, Parts part, int numberUsed, double price) {
        this.tickets = tickets;
        this.part = part;
        this.numberUsed = numberUsed;
        this.price = price;
    }

    public ServiceTicket getTickets() {
        return tickets;
    }

    public void setTickets(ServiceTicket tickets) {
        this.tickets = tickets;
    }

    public Parts getPart() {
        return part;
    }

    public void setPart(Parts part) {
        this.part = part;
    }

    public int getNumberUsed() {
        return numberUsed;
    }

    public void setNumberUsed(int numberUsed) {
        this.numberUsed = numberUsed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PartsUsed{" + "tickets=" + tickets + ", part=" + part + ", numberUsed=" + numberUsed + ", price=" + price + '}';
    }
    
    
}
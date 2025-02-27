/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mechanic;
import model.TopMechanicData;
import mylib.DBUtils;

/**
 *
 * @author NGHIA
 */
public class MechanicDAO {
    public static ArrayList<TopMechanicData> getTopMechanic(){
        ArrayList<TopMechanicData> topMechanicDataList = new ArrayList<>();
        String query = "SELECT m.*, COUNT(sm.serviceTicketID) as ticketDone , AVG(sm.rate) as averageRate, SUM(sm.hours) as totalHours FROM Mechanic m" +
                " JOIN ServiceMehanic sm ON sm.mechanicID = m.mechanicID" +
                " GROUP BY m.mechanicID, m.mechanicName" +
                " ORDER BY ticketDone DESC";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int ticketDone = rs.getInt("ticketDone");
                long averageRate = rs.getLong("averageRate");
                int totalHours = rs.getInt("totalHours");
                
                Mechanic mechanic = new Mechanic(rs.getLong("mechanicID"),rs.getString("mechanicName"));
                TopMechanicData mechanicData = new TopMechanicData();
                
                mechanicData.setAverageRate(averageRate);
                mechanicData.setTicketDone(ticketDone);
                mechanicData.setTotalHours(totalHours);
                mechanicData.setMechanic(mechanic);
                
                topMechanicDataList.add(mechanicData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return topMechanicDataList;
    }
}

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
    public  ArrayList<TopMechanicData> getTopMechanic(){
        ArrayList<TopMechanicData> topMechanicDataList = new ArrayList<>();
        String query = "SELECT m.mechanicID, \n" +
            "       m.mechanicName, \n" +
            "       COUNT(sm.serviceTicketID) AS ticketDone, \n" +
            "       AVG(sm.rate) AS averageRate, \n" +
            "       SUM(sm.hours) AS totalHours\n" +
            "FROM Mechanic m\n" +
            "JOIN ServiceMehanic sm ON sm.mechanicID = m.mechanicID\n" +
            "GROUP BY m.mechanicID, m.mechanicName\n" +
            "HAVING COUNT(sm.serviceTicketID) IN (\n" +
            "    SELECT DISTINCT TOP 3 COUNT(sm2.serviceTicketID)\n" +
            "    FROM ServiceMehanic sm2\n" +
            "    JOIN Mechanic m2 ON sm2.mechanicID = m2.mechanicID\n" +
            "    GROUP BY m2.mechanicID\n" +
            "    ORDER BY COUNT(sm2.serviceTicketID) DESC\n" +
            ")\n" +
            "ORDER BY ticketDone DESC";

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

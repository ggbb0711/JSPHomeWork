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
import model.CarSoldData;
import model.PartUsed;
import model.Parts;
import mylib.DBUtils;

/**
 *
 * @author NGHIA
 */
public class PartUsedDAO {
    public  ArrayList<PartUsed> getMostUsedParts(){
        ArrayList<PartUsed> partUsedList = new ArrayList<>();
        String query = "SELECT p.*, SUM(pu.numberUsed) as numberUsed, SUM(pu.price) as totalPrice FROM Parts p" +
                    " JOIN PartsUsed pu ON p.partID = pu.partID" +
                    " GROUP BY p.partID, p.partName, p.purchasePrice, p.retailPrice" +
                    " ORDER BY numberUsed DESC";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int numberUsed = rs.getInt("numberUsed");
                int totalPrice = rs.getInt("totalPrice");
                
                Parts part = new Parts(rs.getInt("partID"),rs.getString("partName"),rs.getInt("purchasePrice"),rs.getInt("retailPrice"));
                PartUsed partUsed = new PartUsed();
                
                partUsed.setNumberUsed(numberUsed);
                partUsed.setPrice(totalPrice);
                partUsed.setPart(part);
                
                partUsedList.add(partUsed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return partUsedList;
    }
}

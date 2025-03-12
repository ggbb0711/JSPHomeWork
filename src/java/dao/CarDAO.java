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
import model.Car;
import mylib.DBUtils;

/**
 *
 * @author NGHIA
 */
public class CarDAO {
    public ArrayList<Car> findCarNotInCarID(ArrayList<Long> carIdList){
        ArrayList<Car> carFound = new ArrayList<>();
        String sql ="SELECT * FROM Cars";
        
        if(carIdList.size()>0){
            sql = "SELECT * FROM Cars WHERE carID NOT IN (";
            for (int i = 0; i < carIdList.size(); i++) {
                sql+="?";
                if (i < carIdList.size() - 1) {
                    sql+=",";
                }
            }
            sql+=")";        
        }

        
        Connection conn;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
           
            for (int i = 0; i < carIdList.size(); i++) {
                ps.setLong(i + 1, carIdList.get(i));
            }

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Car car = new Car(rs.getLong("carID"),rs.getString("serialNumber"),rs.getString("model"),rs.getString("colour"),rs.getInt("year"));
                carFound.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carFound;
    }
}

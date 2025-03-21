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
import java.util.ArrayList;
import model.Car;
import mylib.DBUtils;

public class CarDAO {
    public ArrayList<Car> findCarNotInCarID(ArrayList<Long> carIdList) throws SQLException, ClassNotFoundException{
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
        conn.close();
        return carFound;
    }

    public Car checkCarID(String id){
        Car car = null;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "SELECT [carID]\n" +
                    "      ,[serialNumber]\n" +
                    "      ,[model]\n" +
                    "      ,[colour]\n" +
                    "      ,[year]\n" +
                    "  FROM [dbo].[Cars]\n" +
                    "  WHERE [carID]=?";
                PreparedStatement st = cn.prepareCall(sql);
                st.setString(1, id);
                ResultSet table = st.executeQuery();
                if(table!=null){
                    while(table.next()){
                        String carid = table.getString("carID");
                        String serial = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String year = table.getString("year");
                        car = new Car(Long.parseLong(carid), serial, model, colour, Integer.parseInt(year));
                    }
                }
            }    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return car;
    }
    
    public int createCar(String id, String serialnum, String model, String colour, String year){
        int rowAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "INSERT INTO [dbo].[Cars]\n" +
                    "           ([carID]\n" +
                    "           ,[serialNumber]\n" +
                    "           ,[model]\n" +
                    "           ,[colour]\n" +
                    "           ,[year])\n" +
                    "     VALUES\n" +
                    "           (?,?,?,?,?)";
                PreparedStatement st = cn.prepareCall(sql);
                st.setString(1, id);
                st.setString(2, serialnum);
                st.setString(3, model);
                st.setString(4, colour);
                st.setString(5, year);
                rowAffected = st.executeUpdate();
            }    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowAffected;
    } 
    
    public ArrayList<Car> findAllCar(String serial, String model, String year){
        ArrayList<Car> car = new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "SELECT [carID]\n" +
                            "      ,[serialNumber]\n" +
                            "      ,[model]\n" +
                            "      ,[colour]\n" +
                            "      ,[year]\n" +
                            "FROM [Car_Dealership].[dbo].[Cars]\n" +
                            "WHERE [serialNumber] like ? and [model] like ? and [year] like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + serial + "%");
                st.setString(2, "%" + model + "%");
                st.setString(3, "%" + year + "%");
                ResultSet table = st.executeQuery();
                
                if(table!=null){
                    while(table.next()){
                        String id = table.getString("carID");
                        String serialnum = table.getString("serialNumber");
                        String cmodel = table.getString("model");
                        String colour = table.getString("colour");
                        String cyear = table.getString("year");
                        Car c = new Car(Integer.parseInt(id), serialnum, cmodel, colour, Integer.parseInt(cyear));
                        car.add(c);
                    }
                }
            }    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return car;
    }
    
    public Car updateCar(String id, String serial, String model, String colour, String year){
        Car car = null;
        int rowAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[Cars]\n" +
                        "   SET \n" +
                        "      [serialNumber] = ?\n" +
                        "      ,[model] = ?\n" +
                        "      ,[colour] = ?\n" +
                        "      ,[year] = ?\n" +
                        " WHERE carID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serial);
                st.setString(2, model);
                st.setString(3, colour);
                st.setString(4, year);
                st.setString(5, id);
                rowAffected = st.executeUpdate();
                
                if(rowAffected>0){
                    car = new Car(Integer.parseInt(id), serial, model, colour, Integer.parseInt(year));
                }
            }    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        return car;
    }
    
    public boolean deleteCar(String id){
        boolean isDeleted = false;
        int rowAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "DELETE FROM [dbo].[Cars]\n" +
                        "      WHERE carID = ?";
                PreparedStatement st = cn.prepareCall(sql);
                st.setString(1, id);
                rowAffected = st.executeUpdate();
                
                if(rowAffected > 0){
                    isDeleted = true;
                }
            }    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null) cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isDeleted;
    }
}

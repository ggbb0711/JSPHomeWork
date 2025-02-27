/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Car;
import model.CarRevenueData;
import model.CarSoldData;
import model.SalesInvoice;
import mylib.DBUtils;

/**
 *
 * @author bluax
 */
public class InvoiceDAO {
    //ham nay dung de lay cac invoice cua 1 customer
    //input: id khach hang
    //output: ArrayList<SalesInvoice>
    public static ArrayList<SalesInvoice> getAllInvoice(long custID,String salesID){
        ArrayList<SalesInvoice> result = new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "select [invoiceID],[invoiceDate],[salesID],[carID],[custID]\n"+
                             "from dbo.SalesInvoice\n" +
                             "where [custID] = ? and [salesID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setLong(1, custID);
                pst.setString(2, salesID);
                ResultSet table = pst.executeQuery();
                if(table!=null){
                    while(table.next()){
                        int invoiceID = table.getInt("invoiceID");
                        Date createdDate = table.getDate("invoiceDate");
                        String salesid = table.getString("salesID");
                        int carID = table.getInt("carID");
                        //khong doc custid trong table vi la cung input dau vao
                        SalesInvoice si = new SalesInvoice(invoiceID, createdDate, salesid, carID, custID);
                        result.add(si);
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
        return result;
    }
    
    
    public static ArrayList<CarSoldData> getCarSoldByYear(long salesID, int year){
        ArrayList<CarSoldData> carSoldDataList = new ArrayList<>();
        String query = "SELECT c.carID, c.serialNumber, c.model, c.colour, c.year, COUNT(si.invoiceID) AS carSold " +
                       "FROM SalesInvoice si " +
                       "JOIN Cars c ON si.carID = c.carID " +
                       "WHERE si.salesID = ? AND YEAR(si.invoiceDate) = ? " +
                       "GROUP BY c.carID, c.serialNumber, c.model, c.colour, c.year " +
                       "ORDER BY carSold DESC";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, salesID);
            stmt.setInt(2, year);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int carID = rs.getInt("carID");
                String serialNumber = rs.getString("serialNumber");
                String model = rs.getString("model");
                String colour = rs.getString("colour");
                int carYear = rs.getInt("year");
                int carSold = rs.getInt("carSold");

                Car car = new Car(carID, serialNumber, model, colour, carYear);
                carSoldDataList.add(new CarSoldData(carSold, car, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carSoldDataList;
    }
    
    public static ArrayList<CarRevenueData> getCarRevenueByYear(long salesID, int year){
        ArrayList<CarRevenueData> carRevenueDataList = new ArrayList<>();
        String query = "SELECT c.carID, c.serialNumber, c.model, c.colour, c.year, SUM(si.revenue) AS carSold " +
                       "FROM SalesInvoice si " +
                       "JOIN Cars c ON si.carID = c.carID " +
                       "WHERE si.salesID = ? AND YEAR(si.invoiceDate) = ? " +
                       "GROUP BY c.carID, c.serialNumber, c.model, c.colour, c.year " +
                       "ORDER BY carSold DESC";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, salesID);
            stmt.setInt(2, year);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int carID = rs.getInt("carID");
                String serialNumber = rs.getString("serialNumber");
                String model = rs.getString("model");
                String colour = rs.getString("colour");
                int carYear = rs.getInt("year");
                int carSold = rs.getInt("carSold");

                Car car = new Car(carID, serialNumber, model, colour, carYear);
                carRevenueDataList.add(new CarRevenueData(carSold, car, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carRevenueDataList;
    }
}

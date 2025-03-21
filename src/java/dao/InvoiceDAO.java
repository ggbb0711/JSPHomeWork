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
import java.util.Random;
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
    
    public boolean createInvoice(ArrayList<SalesInvoice> invoices, int wishlistID) throws ClassNotFoundException, SQLException{
        boolean result = true;
        Connection cn = null;
        int id = 0;
        
        cn = DBUtils.getConnection();
        cn.setAutoCommit(false);
        String getLargestId = "Select top 1 invoiceID from SalesInvoice order by invoiceID desc";
        String insertInvoiceSql = "INSERT INTO SalesInvoice(invoiceID,invoiceDate,salesID,carID,custID,revenue) "
                + " VALUES(?,?,?,?,?,?)";
        String checkWishlistSql = "UPDATE Wishlist SET isCompleted=1 WHERE id = ?";

        PreparedStatement psGetId = cn.prepareStatement(getLargestId);
        ResultSet idTable = psGetId.executeQuery();
        if(idTable!=null){
            idTable.next();
            id = idTable.getInt("invoiceID");
        }


        PreparedStatement psInsert = cn.prepareStatement(insertInvoiceSql);
        for(SalesInvoice invoice:invoices){
            psInsert.setLong(1, ++id);
            psInsert.setDate(2, invoice.getInvoiceDate());
            psInsert.setLong(3, invoice.getSalesID());
            psInsert.setLong(4, invoice.getCarID());
            psInsert.setLong(5, invoice.getCustID());
            psInsert.setDouble(6, invoice.getRevenue());
            psInsert.addBatch();
        }
        PreparedStatement psCheckWishlist = cn.prepareStatement(checkWishlistSql);
        psCheckWishlist.setInt(1, wishlistID);

        int[] rowsInserted = psInsert.executeBatch();
        int hasCheckedWishlist = psCheckWishlist.executeUpdate();
        for(int row:rowsInserted){
            if(row<1) result = false;
        }
        if(hasCheckedWishlist<1) result = false;

        cn.commit();
        cn.close();
        return result;
    }

    public  ArrayList<SalesInvoice> getAllInvoice(long custID,long salesID) throws SQLException, ClassNotFoundException{
        ArrayList<SalesInvoice> result = new ArrayList<>();
        Connection cn=null;
        cn=DBUtils.getConnection();
        String sql = "select [invoiceID],[invoiceDate],[salesID],[carID],[custID]\n"+
                     "from dbo.SalesInvoice\n" +
                     "where [custID] = ? and [salesID] = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setLong(1, custID);
        pst.setLong(2, salesID);
        ResultSet table = pst.executeQuery();
        if(table!=null){
            while(table.next()){
                int invoiceID = table.getInt("invoiceID");
                Date createdDate = table.getDate("invoiceDate");
                long salesid = table.getLong("salesID");
                int carID = table.getInt("carID");
                //khong doc custid trong table vi la cung input dau vao
                SalesInvoice si = new SalesInvoice(invoiceID, createdDate, salesid, carID, custID);
                result.add(si);
            }
        }
        cn.close();
        return result;
    }
    
    
    public  ArrayList<SalesInvoice> getCarRevenueByUserID(long custID) throws SQLException, ClassNotFoundException{
        ArrayList<SalesInvoice> userInvoices = new ArrayList<>();
        String query = "SELECT ca.*,invoiceDate, revenue FROM Customer c" +
            " JOIN SalesInvoice si ON c.custID=si.custID" +
            " JOIN Cars ca ON ca.carID = si.carID" +
            " WHERE c.custID = ?"
            + " ORDER BY invoiceDate DESC";
        
        Connection conn = DBUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setLong(1, custID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Long carID = rs.getLong("carID");
            String serialNumber = rs.getString("serialNumber");
            String model = rs.getString("model");
            String colour = rs.getString("colour");
            int carYear = rs.getInt("year");
            double carRevenue = rs.getDouble("revenue");
            Date invoiceDate = rs.getDate("invoiceDate");

            Car car = new Car(carID, serialNumber, model, colour, carYear);
            SalesInvoice invoice = new SalesInvoice();
            invoice.setCar(car);
            invoice.setInvoiceDate(invoiceDate);
            invoice.setRevenue(carRevenue);

            userInvoices.add(invoice);
        }
        conn.close();

        return userInvoices;
    }
    
    
    public  ArrayList<CarSoldData> getCarSoldByYear(long salesID, int year) throws ClassNotFoundException, SQLException{
        ArrayList<CarSoldData> carSoldDataList = new ArrayList<>();
        String query = "SELECT c.carID, c.serialNumber, c.model, c.colour, c.year, COUNT(si.invoiceID) AS carSold " +
                       "FROM SalesInvoice si " +
                       "JOIN Cars c ON si.carID = c.carID " +
                       "WHERE si.salesID = ? AND YEAR(si.invoiceDate) = ? " +
                       "GROUP BY c.carID, c.serialNumber, c.model, c.colour, c.year " +
                       "ORDER BY carSold DESC";

        Connection conn = DBUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setLong(1, salesID);
        stmt.setInt(2, year);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Long carID = rs.getLong("carID");
            String serialNumber = rs.getString("serialNumber");
            String model = rs.getString("model");
            String colour = rs.getString("colour");
            int carYear = rs.getInt("year");
            int carSold = rs.getInt("carSold");

            Car car = new Car(carID, serialNumber, model, colour, carYear);
            carSoldDataList.add(new CarSoldData(carSold, car, year));
        }
        conn.close();

        return carSoldDataList;
    }
    
    public  ArrayList<CarSoldData> getMostSoldCarModel(long salesID) throws ClassNotFoundException, SQLException{
        ArrayList<CarSoldData> carSoldDataList = new ArrayList<>();
        String query = "    SELECT c2.model, COUNT(si2.invoiceID) AS modelSold\n" +
                "    FROM SalesInvoice si2\n" +
                "    JOIN Cars c2 ON si2.carID = c2.carID\n" +
                "    WHERE si2.salesID = ?\n" +
                "    GROUP BY c2.model\n" +
                "	ORDER BY COUNT(si2.invoiceID) DESC";

        Connection conn = DBUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setLong(1, salesID);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String model = rs.getString("model");
            int carSold = rs.getInt("modelSold");

            Car car = new Car();
            car.setModel(model);
            CarSoldData carSoldData = new CarSoldData();
            carSoldData.setCarSold(carSold);
            carSoldData.setCar(car);
            carSoldDataList.add(carSoldData);
        }
        conn.close();

        return carSoldDataList;
    }
    
    public  ArrayList<CarRevenueData> getCarRevenueByYear(long salesID, int year) throws SQLException, ClassNotFoundException{
        ArrayList<CarRevenueData> carRevenueDataList = new ArrayList<>();
        String query = "SELECT c.carID, c.serialNumber, c.model, c.colour, c.year, SUM(si.revenue) AS carRev " +
                       "FROM SalesInvoice si " +
                       "JOIN Cars c ON si.carID = c.carID " +
                       "WHERE si.salesID = ? AND YEAR(si.invoiceDate) = ? " +
                       "GROUP BY c.carID, c.serialNumber, c.model, c.colour, c.year " +
                       "ORDER BY carRev DESC";

        Connection conn = DBUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setLong(1, salesID);
        stmt.setInt(2, year);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Long carID = rs.getLong("carID");
            String serialNumber = rs.getString("serialNumber");
            String model = rs.getString("model");
            String colour = rs.getString("colour");
            int carYear = rs.getInt("year");
            double carRev = rs.getDouble("carRev");

            Car car = new Car(carID, serialNumber, model, colour, carYear);
            carRevenueDataList.add(new CarRevenueData(carRev, car, year));
        }
        conn.close();

        return carRevenueDataList;
    }
}

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
import model.Parts;
import mylib.DBUtils;

/**
 *
 * @author NGHIA
 */
public class PartsDAO {
    public  Parts getPartById(long id) throws ClassNotFoundException, SQLException{
        String sqlQuery = "SELECT p.partID, p.partName, p.purchasePrice, p.retailPrice from Parts p WHERE p.partID = ?";
        Parts p = null;
        Connection con = DBUtils.getConnection();
        PreparedStatement ps = con.prepareStatement(sqlQuery);

        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while(rs.next()){
                p=new Parts();
                p.setPartID(rs.getLong("partID"));
                p.setPartName(rs.getString("partName"));
                p.setPurchasePrice(rs.getDouble("purchasePrice"));
                p.setRetailPrice(rs.getDouble("retailPrice"));
            }
        }
        con.close();
            
        return p;
    }
    
    public  ArrayList<Parts> getParts(String partName) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT p.partID, p.partName, p.purchasePrice, p.retailPrice from Parts p";
        if(!partName.isEmpty()) sqlQuery+=" WHERE p.partName LIKE ?";
        ArrayList<Parts> list =new ArrayList<>(); 
        Connection con = DBUtils.getConnection();
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        // set params value to query
        if(!partName.isEmpty()){
            ps.setString(1, "%"+partName+"%");
        } 

        ResultSet rs = ps.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Parts p = new Parts(
                        rs.getLong("partID"),
                        rs.getString("partName"),
                        rs.getDouble("purchasePrice"),
                        rs.getDouble("retailPrice")
                );
                list.add(p);
            }
        }
        con.close();
        return list;
    }
    
    public  ArrayList<Parts> getParts() throws SQLException, ClassNotFoundException{
        return getParts("");
    }
    
    public  Parts create(Parts newParts) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String sqlQuery = "INSERT INTO Parts(partID,partName,purchasePrice,retailPrice) "
                + " VALUES(?, ?, ?, ?)";
        
        Connection con = DBUtils.getConnection();
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setLong(1, newParts.getPartID());
        ps.setString(2, newParts.getPartName());
        ps.setDouble(3, newParts.getPurchasePrice());
        ps.setDouble(4, newParts.getRetailPrice());
        int rows = ps.executeUpdate();
        status = rows>0;

        con.close();
        return (status)?newParts:null;
    }
    
    public boolean update(Parts updatePart) throws SQLException, ClassNotFoundException{
        String sqlQuery = "UPDATE Parts SET partName=?,purchasePrice=?,retailPrice=? WHERE partID=?";
        
        Connection con = DBUtils.getConnection();
        PreparedStatement ps = con.prepareStatement(sqlQuery);
        ps.setString(1, updatePart.getPartName());
        ps.setDouble(2, updatePart.getPurchasePrice());
        ps.setDouble(3, updatePart.getRetailPrice());
        ps.setLong(4, updatePart.getPartID());
        int rows = ps.executeUpdate();

        con.close();
        return rows>0;
    }
    
    public  boolean delete(long id) throws SQLException, ClassNotFoundException{
        boolean status = false;
        String deletePartsUsedSqlQuery = "DELETE FROM PartsUsed WHERE partID = ?";
        String deletePartsSqlQuery = "DELETE FROM Parts WHERE partID=?";
        
        Connection con = DBUtils.getConnection();
        con.setAutoCommit(false);
        PreparedStatement deletePartsUsePs = con.prepareStatement(deletePartsUsedSqlQuery);
        PreparedStatement deletePartsPs = con.prepareStatement(deletePartsSqlQuery);

        deletePartsUsePs.setLong(1, id);
        deletePartsPs.setLong(1, id);

        deletePartsUsePs.executeUpdate();
        status = deletePartsPs.executeUpdate()>0;
        con.commit();
        con.close();
        return status;
    }
}

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
    public static Parts getPartById(int id) throws ClassNotFoundException{
        String sqlQuery = "SELECT p.partID, p.partName, p.purchasePrice, p.retailPrice from Parts p WHERE p.partID = ?";
        Parts p = null;
        try{
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    p=new Parts();
                    p.setPartID(rs.getInt("partID"));
                    p.setPartName(rs.getString("partName"));
                    p.setPurchasePrice(rs.getDouble("purchasePrice"));
                    p.setRetailPrice(rs.getDouble("retailPrice"));
                }
            }
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("DBUtils not found.");
        } catch (SQLException ex) {
            System.out.println("SQL Exception in getting list of prices. Details: ");
            ex.printStackTrace();
        }
        return p;
    }
    
    public static ArrayList<Parts> getParts(String partName){
        String sqlQuery = "SELECT p.partID, p.partName, p.purchasePrice, p.retailPrice from Parts p";
        if(!partName.isEmpty()) sqlQuery+=" WHERE p.partName LIKE ?";
        ArrayList<Parts> list = null;
         try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            // set params value to query
            int paramIndex = 1;
            if(!partName.isEmpty()){
                //Using setFloat would create number with incorrect precision
                ps.setString(paramIndex++, "%"+partName+"%");
            } 

            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Parts p = new Parts(
                            rs.getInt("partID"),
                            rs.getString("partName"),
                            rs.getDouble("purchasePrice"),
                            rs.getDouble("retailPrice")
                    );
                    list.add(p);
                }
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("DBUtils not found.");
        } catch (SQLException ex) {
            System.out.println("SQL Exception in getting list of prices. Details: ");
            ex.printStackTrace();
        }
        return list;
    }
    
    public static ArrayList<Parts> getParts(){
        return getParts("");
    }
    
    public static Parts create(Parts newParts){
        boolean status = false;
        String sqlQuery = "INSERT INTO Parts(partID,partName,purchasePrice,retailPrice) "
                + " VALUES(?, ?, ?, ?)";
        
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, newParts.getPartID());
            ps.setString(2, newParts.getPartName());
            ps.setDouble(3, newParts.getPurchasePrice());
            ps.setDouble(4, newParts.getRetailPrice());
            int rows = ps.executeUpdate();
            status = rows>0;
            
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("DBUtils not found!");
        } catch (SQLException ex) {
            System.out.println("SQL Exception in inserting new product. Details: ");
            ex.printStackTrace();
        }
        return (status)?newParts:null;
    }
    
    public static Parts update(Parts updatePart){
        boolean status = false;
        String sqlQuery = "UPDATE Parts SET partName=?,purchasePrice=?,retailPrice=? WHERE partID=?";
        
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, updatePart.getPartName());
            ps.setDouble(2, updatePart.getPurchasePrice());
            ps.setDouble(3, updatePart.getRetailPrice());
            ps.setInt(4, updatePart.getPartID());
            int rows = ps.executeUpdate();
            
            status = rows>0;
            
            con.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("DBUtils not found!");
        } catch (SQLException ex) {
            System.out.println("SQL Exception in inserting new product. Details: ");
            ex.printStackTrace();
        }
        return (status)?updatePart:null;
    }
    
    public static boolean delete(int id){
        boolean status = false;
        String deletePartsUsedSqlQuery = "DELETE FROM PartsUsed WHERE partID = ?";
        String deletePartsSqlQuery = "DELETE FROM Parts WHERE partID=?";
        
        try{
            Connection con = DBUtils.getConnection();
            PreparedStatement deletePartsUsePs = con.prepareStatement(deletePartsUsedSqlQuery);
            PreparedStatement deletePartsPs = con.prepareStatement(deletePartsSqlQuery);

            deletePartsUsePs.setInt(1, id);
            deletePartsPs.setInt(1, id);
            
            deletePartsUsePs.executeUpdate();
            status = deletePartsPs.executeUpdate()>0;
            con.close();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("DBUtils not found!");
        } catch (SQLException ex) {
            System.out.println("SQL Exception in deleting product with id="+id+". Details: ");
            ex.printStackTrace();
        }
        return status;
    }
}

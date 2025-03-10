/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Customer;
import mylib.DBUtils;

/**
 *
 * @author bluax
 */
public class CustomerDAO {
    public Customer checkCustID(String id){
        Customer cs = null;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "SELECT [custID]\n" +
                            "      ,[custName]\n" +
                            "      ,[phone]\n" +
                            "      ,[sex]\n" +
                            "      ,[cusAddress]\n" +
                            "FROM [dbo].[Customer]\n" +
                            "where [custID] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet table = st.executeQuery();
                if(table!=null){
                    while(table.next()){
                        String custid = table.getString("custID");
                        int newID = Integer.parseInt(custid);
                        String name = table.getString("custName");
                        String phone = "" + table.getString("phone");
                        String sex = table.getString("sex");
                        String address = table.getString("cusAddress");
                        cs = new Customer(newID, name, phone, sex, address);
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
        return cs;
    }
    
    public int createCustomer(String id, String name, String phone, String sex, String address){
        int rowAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "INSERT INTO [dbo].[Customer]\n" +
                                "           ([custID]\n" +
                                "           ,[custName]\n" +
                                "           ,[phone]\n" +
                                "           ,[sex]\n" +
                                "           ,[cusAddress])\n" +
                                "     VALUES\n" +
                                "           (?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                st.setString(2, name);
                st.setString(3, phone);
                st.setString(4, sex);
                st.setString(5, address);
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
    
    //customer co the co nhieu ten nen luu vao arraylist
    public ArrayList<Customer> getAllCustomer(String name){
        ArrayList<Customer> rs = new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "SELECT [custID]\n" +
                            "      ,[custName]\n" +
                            "      ,[phone]\n" +
                            "      ,[sex]\n" +
                            "      ,[cusAddress]\n" +
                            "FROM [dbo].[Customer]\n" +
                            "where [custName] like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + name + "%");
                ResultSet table = st.executeQuery();
                if(table!=null){
                    while(table.next()){
                        String id = table.getString("custID");
                        int newID = Integer.parseInt(id);
                        String custname = table.getString("custName");
                        String phone = "" + table.getString("phone");
                        String sex = table.getString("sex");
                        String custAddress = table.getString("cusAddress");
                        Customer cs = new Customer(newID, custname, phone, sex, custAddress);
                        rs.add(cs);
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
        return rs;
    }
    
    public Customer updateCustomer(String id, String name, String phone, String sex, String address){
        Customer cus = null;
        int rowsAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "UPDATE [dbo].[Customer]\n" +
                            "   SET  \n" +
                            "      [custName] = ?\n" +
                            "      ,[phone] = ?\n" +
                            "      ,[sex] = ?\n" +
                            "      ,[cusAddress] = ?\n" +
                            " WHERE [custID] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, name);
                st.setString(2, phone);
                st.setString(3, sex);
                st.setString(4, address);
                st.setString(5, id);
                rowsAffected = st.executeUpdate();
                
                if(rowsAffected>0){
                    cus = new Customer(Integer.parseInt(id), name, phone, sex, address);
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
        return cus;
    }
    
    public boolean deleteCustomer(String id){
        boolean isDeleted = false;
        int rowAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "DELETE FROM [dbo].[Customer]\n" +
                            "      WHERE custID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                rowAffected = st.executeUpdate();
                
                if(rowAffected>0){
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

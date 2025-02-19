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
import java.util.ArrayList;
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
    public ArrayList<SalesInvoice> getAllInvoice(int custID,String salesID){
        ArrayList<SalesInvoice> result = new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "select [invoiceID],[invoiceDate],[salesID],[carID],[custID]\n"+
                             "from dbo.SalesInvoice\n" +
                             "where [custID] = ? and [salesID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, custID);
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
    
}

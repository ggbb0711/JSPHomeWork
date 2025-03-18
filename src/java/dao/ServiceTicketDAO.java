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
import model.ServiceTicket;
import mylib.DBUtils;

/**
 *
 * @author bluax
 */
public class ServiceTicketDAO {
    
    public int createServiceTicket(String id, Date dateReceive, Date dateReturn, String custid, String carid){
        int rowAffected = 0;
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "INSERT INTO [dbo].[ServiceTicket]\n" +
                            "           ([serviceTicketID]\n" +
                            "           ,[dateReceived]\n" +
                            "           ,[dateReturned]\n" +
                            "           ,[custID]\n" +
                            "           ,[carID])\n" +
                            "     VALUES\n" +
                            "           (?,?,?,?,?)";
                PreparedStatement st = cn.prepareCall(sql);
                st.setString(1, id);
                st.setDate(2, dateReceive);
                st.setDate(3, dateReturn);
                st.setString(4, custid);
                st.setString(5, carid);
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

    
    public ArrayList<ServiceTicket> getAllTickets(String id){
        ArrayList<ServiceTicket> result = new ArrayList<>();
        Connection cn=null;
        try{
            cn=DBUtils.getConnection();
            if(cn!=null){
                String sql = "SELECT [serviceTicketID]\n" +
                            "      ,[dateReceived]\n" +
                            "      ,[dateReturned]\n" +
                            "      ,[custID]\n" +
                            "      ,[carID]\n" +
                            "  FROM [dbo].[ServiceTicket]\n" +
                            "  where serviceTicketID like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + id + "%" );
                ResultSet table = st.executeQuery();
                if(table!=null){
                    while(table.next()){
                        String ticketid = table.getString("serviceTicketID");
                        Date datereceive = table.getDate("dateReceived");
                        Date datereturn = table.getDate("dateReturned");
                        String custid = table.getString("custID");
                        String carid = table.getString("carID");
                        ServiceTicket ticket = new ServiceTicket(ticketid, datereceive, datereturn, Integer.parseInt(custid), carid);
                        result.add(ticket);
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

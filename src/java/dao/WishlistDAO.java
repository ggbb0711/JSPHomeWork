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
import model.Car;
import mylib.DBUtils;

/**
 *
 * @author NGHIA
 */
public class WishlistDAO {
    public boolean createWishlist(int custid, ArrayList<Car> listcar){
        boolean rs = false;
        Connection cn=null;
        try{
            cn = DBUtils.getConnection();
            if(cn!=null){
                cn.setAutoCommit(false);
                
                String sql = "Insert INTO Wishlist(custid) values(?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, custid);
                st.executeUpdate();
                
                
                sql = "Select top 1 id from Wishlist order by id desc";
                st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if(table != null && table.next()){
                    int wishlistID = table.getInt("id");
                    
                    
                    for (Car c : listcar) {
                        long carid = c.getCarID();
                        sql = "insert INTO DetailWishlist(carid,wishlistid) values (?,?)";
                        st = cn.prepareStatement(sql);
                        st.setLong(1, carid);
                        st.setInt(2, wishlistID);
                        st.executeUpdate();
                    }
                }
                

                cn.commit();
                rs = true;
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
}

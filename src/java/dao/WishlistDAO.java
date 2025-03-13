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
import model.Customer;
import model.Wishlist;
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
    
    public ArrayList<Wishlist> getWishlists(){
        ArrayList<Wishlist> wishlists = new ArrayList<>();
        String sql = "SELECT wl.* FROM Wishlist wl WHERE wl.isCompleted = 0";
        
        try {
            Connection cn = DBUtils.getConnection();
            if(cn!=null){
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    Wishlist wishlist = new Wishlist(rs.getInt("id"),rs.getLong("custid"),rs.getBoolean("isCompleted"),rs.getDate("createdAt"));
                    wishlists.add(wishlist);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WishlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WishlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wishlists;
    }
    
    public Wishlist getWishlist(int wishlistId){
        String sql = "SELECT wl.*,c.*,ca.* FROM Wishlist wl"
                    + " JOIN DetailWishlist dw ON wl.id = dw.wishlistid "
                    + " JOIN Cars ca ON dw.carid=ca.carID"
                    + " JOIN Customer c ON c.custID=wl.custid WHERE wl.id = ?";
        Wishlist wishlist = null;
        
        try {
            Connection cn = DBUtils.getConnection();
            if(cn!=null){
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, wishlistId);
                
                ResultSet rs = ps.executeQuery();
                ArrayList<Car> wishlistDetails = new ArrayList<>();
                while(rs.next()){
                    if(wishlist==null){
                        Customer customer = new Customer(rs.getLong("custID"),rs.getString("custName"),rs.getString("phone"),rs.getString("sex"),rs.getString("cusAddress"));
                        wishlist = new Wishlist(rs.getInt("id"),rs.getLong("custid"),rs.getBoolean("isCompleted"),rs.getDate("createdAt"));
                        wishlist.setCustomer(customer);
                    } 
                    
                    Car car = new Car(rs.getLong("carID"),rs.getString("serialNumber"),rs.getString("model"),rs.getString("colour"),rs.getInt("year"));
                    wishlistDetails.add(car);
                }
                if(wishlist!=null) wishlist.setDetails(wishlistDetails);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WishlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WishlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wishlist;
    }
}

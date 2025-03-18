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
import java.util.List;

import model.Car;
import model.Customer;

import model.Parts;

import model.qe170179.SaleInvoice;
import model.SalesPerson;
import model.qe170179.ServiceTicket;
import mylib.DBUtils;

public class CustomerDAO extends DBUtils {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<ServiceTicket> tickets;
    private List<PartsUsed> partUsedList;
    private List<SaleInvoice> invoices;

    public CustomerDAO() {
        tickets = new ArrayList<>();
        partUsedList = new ArrayList<>();
        invoices = new ArrayList<>();
    }

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
                        cs = new Customer(newID, name, (phone), sex, address);
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
                        Customer cs = new Customer(newID, custname, (phone), sex, custAddress);
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
                    cus = new Customer(Integer.parseInt(id), name, (phone), sex, address);
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

     public model.qe170179.Customer login(String name, String phone) throws ClassNotFoundException, SQLException {
        String sql = "select * from Customer c\n"
                + "where c.custName = ? and c.phone = ?";

        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, phone);

            rs = ps.executeQuery();

            if (rs.next()) {
                int cusId = rs.getInt("custID");
                String cusName = rs.getString("custName");
                int cusPhone = rs.getInt("phone");
                String sex = rs.getString("sex");
                String address = rs.getString("cusAddress");

                model.qe170179.Customer customer = new model.qe170179.Customer(cusId, cusName, cusPhone, sex, address);

                return customer;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public List<ServiceTicket> viewTicketsByUserId(int userId) throws ClassNotFoundException, SQLException {
        String sql = "select * from ServiceTicket s\n"
                + "join Customer c\n"
                + "on s.custID = c.custID\n"
                + "join Cars ca\n"
                + "on s.carID = ca.carID\n"
                + "where s.custID = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int serviceTickerId = rs.getInt("serviceTicketID");
                Date dateReceived = rs.getDate("dateReceived");
                Date dateReturned = rs.getDate("dateReturned");
                int custID = rs.getInt("custID");

                String cusName = rs.getString("custName");
                int cusPhone = rs.getInt("phone");
                String sex = rs.getString("sex");
                String address = rs.getString("cusAddress");

                int carId = rs.getInt("carID");
                String serialNumber = rs.getString("serialNumber");
                String model = rs.getString("model");
                String colour = rs.getString("colour");
                int year = rs.getInt("year");

                model.qe170179.Customer customer = new model.qe170179.Customer(custID, cusName, cusPhone, sex, address);

                Car car = new Car(carId, serialNumber, model, colour, year);

                ServiceTicket ticket = new ServiceTicket(serviceTickerId, dateReceived,
                        dateReturned, customer, car);

                tickets.add(ticket);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tickets;
    }

    public ServiceTicket viewTicketsById(int id) throws ClassNotFoundException, SQLException {
        String sql = "select * from ServiceTicket s\n"
                + "join Customer c\n"
                + "on s.custID = c.custID\n"
                + "join Cars ca\n"
                + "on s.carID = ca.carID\n"
                + "where s.serviceTicketID = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                int serviceTickerId = rs.getInt("serviceTicketID");
                Date dateReceived = rs.getDate("dateReceived");
                Date dateReturned = rs.getDate("dateReturned");
                int custID = rs.getInt("custID");

                String cusName = rs.getString("custName");
                int cusPhone = rs.getInt("phone");
                String sex = rs.getString("sex");
                String address = rs.getString("cusAddress");

                int carId = rs.getInt("carID");
                String serialNumber = rs.getString("serialNumber");
                String model = rs.getString("model");
                String colour = rs.getString("colour");
                int year = rs.getInt("year");

                model.qe170179.Customer customer = new model.qe170179.Customer(custID, cusName, cusPhone, sex, address);

                Car car = new Car(carId, serialNumber, model, colour, year);

                ServiceTicket ticket = new ServiceTicket(serviceTickerId, dateReceived,
                        dateReturned, customer, car);

                return ticket;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List<PartsUsed> getPartUsedByServiceTicketId(int id) throws ClassNotFoundException {
        String sql = "select * from PartsUsed p \n"
                + "join Parts pa\n"
                + "on p.partID = pa.partID\n"
                + "where p.serviceTicketID = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                int serviceTickerId = rs.getInt("serviceTicketID");
                int partID = rs.getInt("partID");
                int numberUsed = rs.getInt("numberUsed");
                double price = rs.getDouble("price");

                String partName = rs.getString("partName");
                double purchasePrice = rs.getDouble("purchasePrice");
                double retailPrice = rs.getDouble("retailPrice");

                ServiceTicket ticket = new ServiceTicket(serviceTickerId, null,
                        null, null, null);

                Parts part = new Parts(partID, partName, purchasePrice, retailPrice);

                PartsUsed partUsed = new PartsUsed(ticket, part, numberUsed, price);

                partUsedList.add(partUsed);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return partUsedList;
    }

    public List<SaleInvoice> getAllInvoiceByUserId(int id) throws ClassNotFoundException {
        String sql = "select * from SalesInvoice s\n"
                + "join Customer c\n"
                + "on s.custID = c.custID\n"
                + "join Cars ca\n"
                + "on s.carID = ca.carID\n"
                + "join SalesPerson sp\n"
                + "on s.salesID = sp.salesID\n"
                + "where s.custID = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                int invoiceID = rs.getInt("invoiceID");
                Date invoiceDate = rs.getDate("invoiceDate");
                int salesID = rs.getInt("salesID");
                int carID = rs.getInt("carID");
                int custID = rs.getInt("custID");

                String cusName = rs.getString("custName");
                int cusPhone = rs.getInt("phone");
                String sex = rs.getString("sex");
                String address = rs.getString("cusAddress");

                String serialNumber = rs.getString("serialNumber");
                String model = rs.getString("model");
                String colour = rs.getString("colour");
                int year = rs.getInt("year");

                String salesName = rs.getString("salesName");
                Date birthday = rs.getDate("birthday");
                String sexSale = rs.getString(19);
                String salesAddress = rs.getString("salesAddress");

                model.qe170179.Customer customer = new model.qe170179.Customer(custID, cusName, cusPhone, sex, address);

                Car car = new Car(carID, serialNumber, model, colour, year);

                SalesPerson saler = new SalesPerson(salesID, salesName, birthday, sexSale, salesAddress);

                SaleInvoice invoice = new SaleInvoice(invoiceID, invoiceDate, saler, car, customer);

                invoices.add(invoice);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return invoices;
    }

    public model.qe170179.Customer findInforCustomerId(int id) throws ClassNotFoundException {
        String sql = "select * from Customer c\n"
                + "where c.custID = ?";
        try (Connection connection = DBUtils.getConnection()) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                int cusId = rs.getInt("custID");
                String cusName = rs.getString("custName");
                int cusPhone = rs.getInt("phone");
                String sex = rs.getString("sex");
                String address = rs.getString("cusAddress");

                model.qe170179.Customer customer = new model.qe170179.Customer(cusId, cusName, cusPhone, sex, address);

                return customer;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean updateCustomer(model.qe170179.Customer customer) throws ClassNotFoundException {
        String sql = "UPDATE [dbo].[Customer]\n"
                + "   SET [custID] = ?\n"
                + "      ,[custName] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[sex] = ?\n"
                + "      ,[cusAddress] = ?\n"
                + " WHERE custID = ?";
        try (Connection connection = DBUtils.getConnection()) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, customer.getCustID());
            ps.setString(2, customer.getCustName());
            ps.setInt(3, customer.getPhone());
            ps.setString(4, customer.getSex());
            ps.setString(5, customer.getCusAddress());
            ps.setInt(6, customer.getCustID());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }
}

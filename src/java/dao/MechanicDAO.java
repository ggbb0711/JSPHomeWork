/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import mylib.DBUtils;

import model.Car;
import model.qe170179.Customer;
import model.qe170179.Mechanic;
import model.Service;
import model.ServiceMechanic;
import model.qe170179.ServiceTicket;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TNO
 */
public class MechanicDAO extends DBUtils {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<ServiceTicket> tickets;
    private Connection conn;
    private List<ServiceMechanic> serviceMechanics;
    private List<Service> services;

    public MechanicDAO() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            conn = getConnection();
        }
        serviceMechanics = new ArrayList<>();
        tickets = new ArrayList<>();
        services = new ArrayList<>();

    }

    public List<ServiceTicket> findAllServiceTickets() {
        String sql = "select * from ServiceTicket s\n"
                + "join Customer c\n"
                + "on s.custID = c.custID\n"
                + "join Cars ca\n"
                + "on s.carID = ca.carID\n";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int serviceTickerId = rs.getInt("serviceTicketID");
                Date dateReceived = rs.getDate("dateReceived");
                Date dateReturned = rs.getDate("dateReturned");
                int custID = rs.getInt("custID");

                String cusName = rs.getString("custName");
                String cusPhone = rs.getString("phone");
                String sex = rs.getString("sex");
                String address = rs.getString("cusAddress");

                int carId = rs.getInt("carID");
                String serialNumber = rs.getString("serialNumber");
                String model = rs.getString("model");
                String colour = rs.getString("colour");
                int year = rs.getInt("year");

                

                Car car = new Car(carId, serialNumber, model, colour, year);
                Customer customer  = new Customer(custID, cusName, year, sex, address);
                
                ServiceTicket ticket = new ServiceTicket(serviceTickerId, dateReceived,
                        dateReturned, customer, car);

                tickets.add(ticket);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tickets;
    }

    public List<ServiceTicket> filterServiceTickets(String custIdRequest, String carIdRequest,
            String dateRecievedRequest) {
        String sql = "select * from ServiceTicket s\n"
                + "join Customer c\n"
                + "on s.custID = c.custID\n"
                + "join Cars ca\n"
                + "on s.carID = ca.carID\n"
                + "where s.custID like ? and s.carID like ? and s.dateReceived like ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + custIdRequest + "%");
            ps.setString(2, "%" + carIdRequest + "%");
            ps.setString(3, "%" + dateRecievedRequest + "%");

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

                Customer customer = new Customer(custID, cusName, cusPhone, sex, address);

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

    public List<ServiceMechanic> findServiceMechanicsByTicketId(int serviceTicketId) {
        String sql = "select * from ServiceMehanic s\n"
                + "where s.serviceTicketID = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, serviceTicketId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int ticketId = rs.getInt("serviceTicketID");
                int serviceId = rs.getInt("serviceID");
                BigDecimal mechanicID = rs.getBigDecimal("mechanicID");
                int hours = rs.getInt("hours");
                String comment = rs.getString("comment");
                double rate = rs.getDouble("rate");

                ServiceMechanic mechanic = new ServiceMechanic(ticketId,
                        serviceId, mechanicID, hours, comment, rate);

                serviceMechanics.add(mechanic);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return serviceMechanics;
    }

    public boolean updateServiceMechanic(ServiceMechanic mechanic) {
        String sql = "UPDATE [dbo].[ServiceMehanic]\n"
                + "SET [serviceTicketID] = ?,\n"
                + "    [serviceID] = ?,\n"
                + "    [mechanicID] = ?,\n"
                + "    [hours] = ?,\n"
                + "    [comment] = ?,\n"
                + "    [rate] = ?\n"
                + "WHERE [serviceTicketID] = ? AND [serviceID] = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, mechanic.getServiceTicketID());
            ps.setInt(2, mechanic.getServiceID());
            ps.setBigDecimal(3, mechanic.getMechanicID());
            ps.setInt(4, mechanic.getHours());
            ps.setString(5, mechanic.getCommment());
            ps.setDouble(6, mechanic.getRate());
            ps.setInt(7, mechanic.getServiceTicketID());
            ps.setInt(8, mechanic.getServiceID());

            int rowAff = ps.executeUpdate();

            return rowAff > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Service> findAllService() {
        String sql = "select * from Service s\n"
                + "order by s.serviceID desc";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int serviceId = rs.getInt("serviceID");
                String serviceName = rs.getString("serviceName");
                double hourlyRaye = rs.getDouble("hourlyRate");

                Service service = new Service(serviceId, serviceName, hourlyRaye);

                services.add(service);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return services;
    }

    public List<Service> findServicesByTicketId(int ticketId) {
        String sql = "select * from ServiceMehanic s\n"
                + "join Service se\n"
                + "on s.serviceID = se.serviceID\n"
                + "where s.serviceTicketID = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, ticketId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int serviceId = rs.getInt("");
                String serviceName = rs.getString("");
                double hourlyRaye = rs.getDouble("");

                Service service = new Service(serviceId, serviceName, hourlyRaye);

                services.add(service);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return services;
    }

    public List<Mechanic> findAllMechanics() {
        List<Mechanic> mechanics = new ArrayList<>();
        String sql = "select * from Mechanic m\n";
        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                BigDecimal mechanicId = rs.getBigDecimal("mechanicID");
                String name = rs.getString("mechanicName");


                Mechanic mechanic = new Mechanic(mechanicId, name);
                mechanics.add(mechanic);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mechanics;
    }

    public boolean addService(Service service) {
        String sql = "INSERT INTO [dbo].[Service] \n"
                + "    ([serviceName], [hourlyRate]) \n"
                + "VALUES \n"
                + "    (?, ?);";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, service.getServiceName());
            ps.setDouble(2, service.getHourlyRate());

            int rowAff = ps.executeUpdate();

            return rowAff > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean updateService(Service service) {
        String sql = "UPDATE [dbo].[Service] \n"
                + "SET [serviceName] = ?, \n"
                + "    [hourlyRate] = ? \n"
                + "WHERE [serviceID] = ?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, service.getServiceName());
            ps.setDouble(2, service.getHourlyRate());
            ps.setInt(3, service.getServiceID());

            int rowAff = ps.executeUpdate();
            return rowAff > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean deleteService(int id) {
        String sql = "DELETE FROM [dbo].[Service] WHERE serviceID = ?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rowAff = ps.executeUpdate();
            return rowAff > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public Service findServiceById(int id) {
        String sql = "SELECT * FROM [dbo].[Service] WHERE serviceID = ?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Service(
                        rs.getInt("serviceID"),
                        rs.getString("serviceName"),
                        rs.getDouble("hourlyRate")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
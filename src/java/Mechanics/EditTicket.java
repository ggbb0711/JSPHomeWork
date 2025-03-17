/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mechanics;

import dao.CustomerDAO;
import dao.MechanicDAO;
import dao.PartsUsed;
import model.Service;
import java.io.IOException;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.qe170179.Mechanic;
import model.qe170179.SaleInvoice;
import model.ServiceMechanic;
import model.qe170179.ServiceTicket;
import utils.constant.Routes;

/**
 *
 * @author USER
 */
@WebServlet(name = "EditTicket", urlPatterns = {Routes.EDIT_TICKETS})
public class EditTicket extends HttpServlet {
    private PreparedStatement ps;
    private ResultSet rs;
    private List<ServiceTicket> tickets;
    private List<PartsUsed> partUsedList;
    private List<SaleInvoice> invoices;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int ticketId = Integer.parseInt(request.getParameter("ticketId"));
            CustomerDAO customerDAO = new CustomerDAO();
            MechanicDAO mechanicDAO = new MechanicDAO();

            ServiceTicket ticket = customerDAO.viewTicketsById(ticketId);

            List<ServiceMechanic> servicesMechanic = mechanicDAO.findServiceMechanicsByTicketId(ticketId);

            List<Mechanic> mechanics = mechanicDAO.findAllMechanics();
            List<Service> services = mechanicDAO.findAllService();

            request.setAttribute("mechanics", mechanics);
            request.setAttribute("services", services);
            request.setAttribute("ticket", ticket);
            request.setAttribute("servicesMechanic", servicesMechanic);

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
        request.getRequestDispatcher("/views/mechanic/editserviceticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Double mechanicRequest = Double.parseDouble( request.getParameter("mechanicId"));
            BigDecimal mechanicId = BigDecimal.valueOf(mechanicRequest);
            int serviceId = Integer.parseInt(request.getParameter("serviceId"));
            int ticketId = Integer.parseInt(request.getParameter("ticketId"));
            int hours = Integer.parseInt(request.getParameter("hours"));
            double rate = Double.parseDouble(request.getParameter("rate"));
            String comment = request.getParameter("comment");

            ServiceMechanic mechanic = new ServiceMechanic(ticketId, serviceId, mechanicId, hours, comment, rate);

            MechanicDAO mechanicDAO = new MechanicDAO();
            if (!mechanicDAO.updateServiceMechanic(mechanic)) {
                throw new Exception("Update failed");
            }
            response.sendRedirect("/JSPHomeWork/mechanic/manage-service-ticket?action=Edit&ticketId=" + ticketId);

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
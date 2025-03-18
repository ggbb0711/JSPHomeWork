/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import dao.CustomerDAO;
import model.qe170179.Customer;
import model.qe170179.ServiceTicket;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.constant.Routes;

/**
 *
 * @author USER
 */
@WebServlet(name = "ViewTickersCustomer", urlPatterns = {Routes.VIEW_SERVICE_TICKET_CUSTOMER})
public class ViewTickersCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");

            if (customer == null) {
                throw new Exception("user not found");
            }

            CustomerDAO customerDAO = new CustomerDAO();

            List<ServiceTicket> tickets = customerDAO.viewTicketsByUserId(customer.getCustID());
            request.setAttribute("tickets", tickets);

        } catch (Exception e) {
            response.sendRedirect("/views/mechanic/error.jsp");
        }
        request.getRequestDispatcher("/views/mechanic/manageserviceticket.jsp").forward(request, response);
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
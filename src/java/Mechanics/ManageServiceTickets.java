/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mechanics;

import dao.MechanicDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.qe170179.ServiceTicket;
import utils.constant.Routes;

/**
 *
 * @author USER
 */
@WebServlet(name = "ManageServiceTickets", urlPatterns = {Routes.MANAGE_SERVICE_TICKETS})
public class ManageServiceTickets extends HttpServlet {

    private static final String MANAGE_SERVICE_TICKETS_PAGE = "/views/mechanic/manageserviceticket.jsp";
    private static final String FILTER_TICKETS_CONTROLLER = "/mechanic/filterTickets";
    private static final String EDIT_TICKET_CONTROLLER = "/mechanic/editTicket";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "Sample";

        try {
            if (action == null) {
                MechanicDAO mechanicDAO = new MechanicDAO();

                List<ServiceTicket> tickets = mechanicDAO.findAllServiceTickets();

                request.setAttribute("tickets", tickets);
                url = MANAGE_SERVICE_TICKETS_PAGE;

                return;

            }

            switch (action) {
                case "filter":
                    url = FILTER_TICKETS_CONTROLLER;
                    break;
                case "Edit":
                    url = EDIT_TICKET_CONTROLLER;
                    break;

            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
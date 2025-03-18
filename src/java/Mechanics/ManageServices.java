/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mechanics;

import dao.MechanicDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Service;
import utils.constant.Routes;

/**
 *
 * @author USER
 */
@WebServlet(name = "ManageServices", urlPatterns = {Routes.MANAGE_SERVICE})
public class ManageServices extends HttpServlet {

    private static final String MANAGE_SERVICES_PAGE = "/views/mechanic/manage-services.jsp";
    private static final String ADD_SERVICE_CONTROLLER = "/mechanic/addService";
    private static final String EDIT_SERVICE_CONTROLLER = "/mechanic/editService";
    private static final String DELETE_SERVICE_CONTROLLER = "/mechanic/deleteService";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "Sample";

        try {
            if (action == null) {
                MechanicDAO mechanicDAO = new MechanicDAO();

                List<Service> services = mechanicDAO.findAllService();
                request.setAttribute("services", services);

                url = MANAGE_SERVICES_PAGE;

                return;

            }

            switch (action) {
                case "add":
                    url = request.getContextPath()+ ADD_SERVICE_CONTROLLER;
                    break;
                case "edit":
                    url = request.getContextPath()+EDIT_SERVICE_CONTROLLER;
                    break;
                case "delete":
                    url = request.getContextPath()+DELETE_SERVICE_CONTROLLER;
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
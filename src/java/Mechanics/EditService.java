/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mechanics;

import dao.MechanicDAO;
import model.Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "EditService", urlPatterns = {"/editService"})
public class EditService extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int serviceId = Integer.parseInt(request.getParameter("serviceId"));

            MechanicDAO mechanicsDAO = new MechanicDAO();
            Service service = mechanicsDAO.findServiceById(serviceId);

            request.setAttribute("service", service);

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
        request.getRequestDispatcher("edit-service.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            int serviceId = Integer.parseInt(request.getParameter("serviceId"));
            String serviceName = request.getParameter("serviceName");
            double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));

            MechanicDAO mechanicDAO = new MechanicDAO();

            Service service = mechanicDAO.findServiceById(serviceId);

            if (service == null) {
                throw new Exception("Service not found!");
            }
            service.setServiceName(serviceName);
            service.setHourlyRate(hourlyRate);

            if (mechanicDAO.updateService(service)) {
                response.sendRedirect("manage-services?action=edit&serviceId=" + serviceId);
            } else {
                throw new Exception("Update faild!");
            }
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }

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
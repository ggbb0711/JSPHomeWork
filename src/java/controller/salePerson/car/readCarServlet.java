/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salePerson.car;

import dao.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author bluax
 */
@WebServlet(name = "readCarServlet", urlPatterns = { Routes.READ_CAR })
public class readCarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String serialNumber = request.getParameter("txtserialnumber");
            String model = request.getParameter("txtmodel");
            String year = request.getParameter("txtyear");
            
            if(serialNumber == null || serialNumber.trim().isEmpty()){
                serialNumber = "";
            }
            if(model==null || model.trim().isEmpty()){
                model = "";
            }
            if(year==null || year.trim().isEmpty() ){
                year = "";
            }
            
            CarDAO d = new CarDAO();
            ArrayList<Car> list = d.findAllCar(serialNumber, model, year);
            
            request.setAttribute("findserial", serialNumber);
            request.setAttribute("findmodel", model);
            request.setAttribute("findyear", year);
            
            if(list==null || list.isEmpty()){
                request.setAttribute("findCar", "Serial " + serialNumber + " not found!"  );
            }else{
                request.setAttribute("findCar", "Car(s) found");
                request.setAttribute("carlist", list);
            }

            request.getRequestDispatcher(Pages.READ_CAR_PAGE).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

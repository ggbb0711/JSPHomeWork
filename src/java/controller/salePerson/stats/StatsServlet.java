/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salePerson.stats;

import dao.InvoiceDAO;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CarRevenueData;
import model.CarSoldData;
import model.SalePerson;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author NGHIA
 */
@WebServlet(name = "StatsServlet", urlPatterns = {Routes.STATS})
public class StatsServlet extends HttpServlet {

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
        int currentYear = Year.now().getValue();
        
        Integer carSoldByYear = currentYear;
        Integer carRevenueByYear =currentYear;
        
        try{
            carSoldByYear = Integer.parseInt(request.getParameter("carSoldByYear"));
            carRevenueByYear = Integer.parseInt(request.getParameter("carRevenueByYear"));
        }
        catch(NumberFormatException ex){
            System.out.println(ex);
        }
        
        SalePerson salePerson =  (SalePerson) request.getSession().getAttribute("saleperson");

        InvoiceDAO invoiceDAO = new InvoiceDAO();
        
        ArrayList<CarSoldData> carSoldDataList = invoiceDAO.getCarSoldByYear(Long.parseLong(salePerson.getId()),carSoldByYear);
        ArrayList<CarRevenueData> carRevenueDataList = invoiceDAO.getCarRevenueByYear(Long.parseLong(salePerson.getId()),carRevenueByYear);
        ArrayList<CarSoldData> carModelSoldDataList = invoiceDAO.getMostSoldCarModel(Long.parseLong(salePerson.getId()));

        request.setAttribute("carSoldDataList", carSoldDataList);
        request.setAttribute("carRevenueDataList", carRevenueDataList);
        request.setAttribute("carModelSoldDataList", carModelSoldDataList);
        request.getRequestDispatcher(Pages.STATS_PAGE).forward(request,response);
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

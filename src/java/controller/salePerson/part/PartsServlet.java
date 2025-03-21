/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salePerson.part;

import dao.PartsDAO;
import dto.PartsDTO;
import exceptions.InvalidDataException;
import exceptions.ValidationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Parts;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author NGHIA
 */
@WebServlet(name = "PartsServlet", urlPatterns = {Routes.PARTS})
public class PartsServlet extends HttpServlet {
    
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
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            String partName = (request.getParameter("partName")!=null)?request.getParameter("partName"):"";
            
            PartsDAO partsDAO = new PartsDAO();
            ArrayList<Parts> parts = partsDAO.getParts(partName);
            
            request.setAttribute("partList",parts);
            request.getRequestDispatcher(Pages.PART_PAGE+"?partName="+((partName!=null)?partName:"")).forward(request,response);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.setStatus(500);
            request.setAttribute("message", ex);
            request.getRequestDispatcher(Pages.INTERNAL_ERROR_SALE_PERSON_PAGE).forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
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

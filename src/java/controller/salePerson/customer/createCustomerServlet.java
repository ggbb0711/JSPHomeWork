/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salePerson.customer;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author bluax
 */
@WebServlet(name = "createCustomerServlet", urlPatterns = { Routes.CUSTOMER })
public class createCustomerServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String id = request.getParameter("txtid");
            String name = request.getParameter("txtname");
            String phone = request.getParameter("txtphone");
            String sex = request.getParameter("txtsex");
            String address = request.getParameter("txtaddress");

            CustomerDAO d = new CustomerDAO();
            Customer cs = d.checkCustID(id);
            
            if(cs != null){
                request.setAttribute("checkID", "ID already exist");
                //request.getRequestDispatcher(Pages.CREATE_CUSTOMER_PAGE).forward(request, response);
                //return;
            }else{
                int result = d.createCustomer(id, name, phone, sex, address);
                if(result > 0){
                    request.setAttribute("createCust", "Create Successful");
                }else{
                    request.setAttribute("createCust", "Fail To Create");
                }
            }
            request.getRequestDispatcher(Pages.CREATE_CUSTOMER_PAGE).forward(request, response);
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

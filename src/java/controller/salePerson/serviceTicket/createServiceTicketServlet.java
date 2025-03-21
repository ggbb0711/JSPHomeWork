 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salePerson.serviceTicket;

import dao.CarDAO;
import dao.CustomerDAO;
import dao.ServiceTicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.Customer;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author bluax
 */
@WebServlet(name = "createServiceTicketServlet", urlPatterns = { Routes.SERVICETICKET })
public class createServiceTicketServlet extends HttpServlet {

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
            String id = request.getParameter("txtticketid");
            String dateReceive = request.getParameter("txtdatereceive");
            String dateReturn = request.getParameter("txtdatereturn");
            String custid = request.getParameter("txtcustid");
            String carid = request.getParameter("txtcarid");

            java.sql.Date sqlDateReceive = null;
            java.sql.Date sqlDateReturn = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                
                if(dateReceive!=null && !dateReceive.isEmpty()){
                    java.util.Date parseDate = format.parse(dateReceive);
                    sqlDateReceive = new java.sql.Date(parseDate.getTime());
                }
                
                if(dateReturn!=null && !dateReturn.isEmpty()){
                    java.util.Date parseDate = format.parse(dateReturn);
                    sqlDateReturn = new java.sql.Date(parseDate.getTime());
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ServiceTicketDAO d = new ServiceTicketDAO();
            int result = d.createServiceTicket(id, sqlDateReceive, sqlDateReturn, custid, carid);
            
            CarDAO d1 = new CarDAO();
            ArrayList<Car> list = d1.findAllCar("", "", "");
            
            CustomerDAO d2 = new CustomerDAO();
            ArrayList<Customer> list1 = d2.getAllCustomer("");
             
            if(result>0){
                request.setAttribute("createTicket", "Created");
            }else{
                request.setAttribute("createTicket", "Fail to create");
            }
            request.setAttribute("customerlist", list1);
            request.setAttribute("carlist", list);
            request.getRequestDispatcher(Pages.CREATE_SERVICE_TICKET_PAGE).forward(request, response);
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

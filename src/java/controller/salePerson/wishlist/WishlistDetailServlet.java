/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.salePerson.wishlist;

import dao.InvoiceDAO;
import dao.WishlistDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SalePerson;
import model.SalesInvoice;
import model.Wishlist;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author NGHIA
 */
@WebServlet(name = "WishlistDetailServlet", urlPatterns = {Routes.WISHLIST_DETAIL_SALE_PERSON})
public class WishlistDetailServlet extends HttpServlet {

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
        try{
            String wishlistIdString = request.getParameter("id");
            Integer wishlistId = null;

            try{
                wishlistId = Integer.parseInt(wishlistIdString);
            }
            catch(NumberFormatException ex){
                request.setAttribute("message", "The wishlistId is not in the correct format");
                request.getRequestDispatcher(Pages.MISSING_404_ERROR_SALE_PARSON_PAGE).forward(request, response);
                return;
            }

            WishlistDAO wishlistDAO = new WishlistDAO();
            Wishlist wishlist = wishlistDAO.getWishlist(wishlistId);

            if(wishlist==null){
                response.setStatus(500);
                request.setAttribute("message", "The wishlistId: "+wishlistId+" does not exist.");
                request.getRequestDispatcher(Pages.MISSING_404_ERROR_SALE_PARSON_PAGE).forward(request, response);
            }
            else {
                response.setStatus(500);
                request.setAttribute("wishlistDetail", wishlist);
                request.getRequestDispatcher(Pages.WISHLIST_DETAIL_SALE_PERSON_PAGE).forward(request, response);
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.setStatus(500);
            request.setAttribute("message", ex);
            request.getRequestDispatcher(Pages.INTERNAL_ERROR_SALE_PERSON_PAGE).forward(request, response);
        }
        
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
        try{
            Long custID = Long.parseLong(request.getParameter("custID"));
            String[] carIDStr = request.getParameterValues("carID");
            String[] carRevenue = request.getParameterValues("revenue");
            int wishlistID = Integer.parseInt(request.getParameter("wishlistID"));
            SalePerson salePerson =  (SalePerson) request.getSession().getAttribute("saleperson");

            ArrayList<SalesInvoice> invoices = new ArrayList<>(); 


            for(int i=0;i<carIDStr.length;i++){
                SalesInvoice invoice = new SalesInvoice(); 
                invoice.setInvoiceDate(new Date(System.currentTimeMillis()));
                invoice.setSalesID(Long.parseLong(salePerson.getId()));
                invoice.setCustID(custID);
                invoice.setCarID(Long.parseLong(carIDStr[i]));
                invoice.setRevenue(Double.parseDouble(carRevenue[i]));
                invoices.add(invoice);
            }

            InvoiceDAO invoiceDAO =new InvoiceDAO();
            if(!invoiceDAO.createInvoice(invoices,wishlistID)){
                request.setAttribute("message", "Failed to create invoices");
                request.getRequestDispatcher(Pages.WISHLIST_DETAIL_SALE_PERSON_PAGE+"?id="+wishlistID).forward(request, response);
            }
            else{
                response.sendRedirect(request.getContextPath()+Routes.WISHLIST_SALE_PERSON);
            }
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.setStatus(500);
            request.setAttribute("message", ex);
            request.getRequestDispatcher(Pages.INTERNAL_ERROR_SALE_PERSON_PAGE).forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PartsDAO;
import dto.PartsDTO;
import exceptions.InvalidDataException;
import exceptions.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Parts;
import utils.constant.Pages;

/**
 *
 * @author NGHIA
 */
@WebServlet(name = "PartUpdateServlet", urlPatterns = {"/part-update"})
public class PartUpdateServlet extends HttpServlet {
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
        String partID = (request.getParameter("partID")!=null)?request.getParameter("partID"):"";
        int idValue;
        
        try {
            idValue = Integer.parseInt(partID);
            Parts part=PartsDAO.getPartById(idValue);
            if(part==null) throw new Error("Cannot find part");
            
            HashMap<String, String> updatingPart = new HashMap<>();
            updatingPart.put("partID",String.valueOf(part.getPartID()));
            updatingPart.put("partName", part.getPartName());
            updatingPart.put("purchasePrice", String.valueOf(part.getPurchasePrice()));
            updatingPart.put("retailPrice", String.valueOf(part.getRetailPrice()));
            request.setAttribute("updating-part", updatingPart);
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("parts");
        }
        
        
        request.getRequestDispatcher(Pages.UPDATE_PART_PAGE).forward(request,response);
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
        String partID = request.getParameter("partID");
        String partName = request.getParameter("partName");
        String purchasePrice = request.getParameter("purchasePrice");
        String retailPrice = request.getParameter("retailPrice");
        
        // Save user input to persist in form
        HashMap<String, String> formData = new HashMap<>();
        formData.put("partName", partName);
        formData.put("purchasePrice", purchasePrice);
        formData.put("retailPrice", retailPrice);
        
        PartsDTO priceDTO = new PartsDTO(partID,partName,purchasePrice,retailPrice);
        try {
            priceDTO.validate();
            // call DAO
            Parts part = new Parts(Integer.parseInt(partID),partName,Double.parseDouble(purchasePrice),Double.parseDouble(retailPrice));
            Parts createdPart = PartsDAO.update(part);
            if (createdPart==null) {
                throw new InvalidDataException("Cannot update product to database!");
            } else {
                response.sendRedirect("parts");
            }
        }
        catch (ValidationException ex) {
            request.setAttribute("validation-err", ex.getErrors());
            request.setAttribute("formData", formData);
            request.getRequestDispatcher("part-update").forward(request, response);
        }
        catch(InvalidDataException ex){
            request.setAttribute("invalid-data-exception", ex.getMessage());
            request.setAttribute("formData", formData);
            request.getRequestDispatcher("part-update").forward(request, response);
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

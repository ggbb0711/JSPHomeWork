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
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet(name = "PartUpdateServlet", urlPatterns = {Routes.UPDATE_PARTS})
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
            PartsDAO partsDAO = new PartsDAO();
            Parts part=partsDAO.getPartById(idValue);
            if(part==null) throw new Exception("Cannot find part");
            
            HashMap<String, String> updatingPart = new HashMap<>();
            updatingPart.put("partID",String.valueOf(part.getPartID()));
            updatingPart.put("partName", part.getPartName());
            updatingPart.put("purchasePrice", String.valueOf(part.getPurchasePrice()));
            updatingPart.put("retailPrice", String.valueOf(part.getRetailPrice()));
            
            HashMap<String, String> formData = new HashMap<>();
            formData.put("partName", part.getPartName());
            formData.put("purchasePrice", String.valueOf(part.getPurchasePrice()));
            formData.put("retailPrice", String.valueOf(part.getRetailPrice()));
            
            request.setAttribute("formData", formData);
            request.setAttribute("updating-part", updatingPart);
            request.getRequestDispatcher(Pages.UPDATE_PART_PAGE+"?partID="+partID).forward(request,response);
        } catch (Exception e) {
            System.out.println(e);
            request.setAttribute("message", "The partId cannot be found");
            request.getRequestDispatcher(Pages.MISSING_404_ERROR_PAGE).forward(request,response);
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
        String partID = request.getParameter("partID");
        String partName = request.getParameter("partName");
        String purchasePrice = request.getParameter("purchasePrice");
        String retailPrice = request.getParameter("retailPrice");
        
        String updatingPartId = request.getParameter("updating-partId");
        
        HashMap<String, String> updatingPart = new HashMap<>();
        updatingPart.put("partID",updatingPartId);
        updatingPart.put("partName", request.getParameter("updating-partName"));
        updatingPart.put("purchasePrice", request.getParameter("updating-purchasePrice"));
        updatingPart.put("retailPrice", request.getParameter("updating-retailPrice"));
        
        HashMap<String, String> formData = new HashMap<>();
        formData.put("partName", partName);
        formData.put("purchasePrice", purchasePrice);
        formData.put("retailPrice", retailPrice);
        
        PartsDTO priceDTO = new PartsDTO(partID,partName,purchasePrice,retailPrice);
        try {
            priceDTO.validateUpdate();
            // call DAO
            Parts part = new Parts(Integer.parseInt(partID),partName,Double.parseDouble(purchasePrice),Double.parseDouble(retailPrice));
            PartsDAO partsDAO = new PartsDAO();
            Parts createdPart = partsDAO.update(part);
            if (createdPart==null) {
                throw new InvalidDataException("Cannot update product to database!");
            } else {
                response.sendRedirect(request.getContextPath()+Routes.PARTS);
            }
        }
        catch (ValidationException ex) {
            request.setAttribute("validation-err", ex.getErrors());
            request.setAttribute("formData", formData);
            request.setAttribute("updating-part", updatingPart);
            request.getRequestDispatcher(Pages.UPDATE_PART_PAGE+"?partID="+partID).forward(request, response);
        }
        catch(InvalidDataException ex){
            request.setAttribute("invalid-data-exception", ex.getMessage());
            request.setAttribute("formData", formData);
            request.setAttribute("updating-part", updatingPart);
            request.getRequestDispatcher(Pages.UPDATE_PART_PAGE+"?partID="+partID).forward(request, response);
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

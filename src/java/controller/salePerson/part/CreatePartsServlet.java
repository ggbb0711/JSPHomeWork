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
import java.sql.SQLException;
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
@WebServlet(name = "CreatePartsServlet", urlPatterns = {Routes.CREATE_PARTS})
public class CreatePartsServlet extends HttpServlet {

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
        request.getRequestDispatcher(Pages.CREATE_PART_PAGE).forward(request,response);
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String partID = request.getParameter("partID");
        String partName = request.getParameter("partName");
        String purchasePrice = request.getParameter("purchasePrice");
        String retailPrice = request.getParameter("retailPrice");
        
        // Save user input to persist in form
        HashMap<String, String> formData = new HashMap<>();
        formData.put("partID", partID);
        formData.put("partName", partName);
        formData.put("purchasePrice", purchasePrice);
        formData.put("retailPrice", retailPrice);
        
        PartsDTO priceDTO = new PartsDTO(partID,partName,purchasePrice,retailPrice);
        try {
            priceDTO.validate();
            Parts part = new Parts(Integer.parseInt(partID),partName,Double.parseDouble(purchasePrice),Double.parseDouble(retailPrice));
            PartsDAO partsDAO = new PartsDAO();
            
            Parts existingPart = partsDAO.getPartById(part.getPartID());
            if(existingPart!=null) throw new InvalidDataException("The part with the id: "+part.getPartID()+" has already existed.");
            Parts createdPart = partsDAO.create(part);
            if (createdPart==null) {
                throw new InvalidDataException("Cannot save product to database!");
            } else {
                response.sendRedirect(request.getContextPath()+Routes.PARTS);
            }
        }
        catch (ValidationException ex) {
            request.setAttribute("validation-err", ex.getErrors());
            request.setAttribute("formData", formData);
            request.getRequestDispatcher(Pages.CREATE_PART_PAGE).forward(request, response);
        }
        catch(InvalidDataException ex){
            request.setAttribute("invalid-data-exception", ex.getMessage());
            request.setAttribute("formData", formData);
            request.getRequestDispatcher(Pages.CREATE_PART_PAGE).forward(request, response);
        }catch (SQLException | ClassNotFoundException ex) {
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

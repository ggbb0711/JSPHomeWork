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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
@WebServlet(name = "PartsServlet", urlPatterns = {"/parts"})
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
        String action = request.getParameter("action");
        String method = request.getMethod();
        

        if("POST".equals(method)){
           switch(action){
               case "delete":
                   deletePart(request,response);
                   break;
               default:
                createNewPart(request,response);
                break;
           } 
        }
        else if("GET".equals(method)){
            switch(action){
                default:
                    printPartList(request,response);
                    break;
            }
        }
        else printPartList(request,response);
    }
    
    private void printPartList(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String partName = request.getParameter("partName");
        
        ArrayList<Parts> parts = PartsDAO.getParts(partName);

        request.setAttribute("partList",parts);
        request.getRequestDispatcher(Pages.PART_PAGE+"?partName="+((partName!=null)?partName:"")).forward(request,response);
    }
    
    private void deletePart(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String partId = request.getParameter("partID");
        
        try{
            boolean hasDeleted = PartsDAO.delete(Integer.parseInt(partId));
        }
        catch(Exception ex){
            System.out.println(ex);
            request.getRequestDispatcher(Pages.PART_PAGE).forward(request,response);
        }
    }
    
    private void createNewPart(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
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
            // call DAO
            Parts part = new Parts(Integer.parseInt(partID),partName,Double.parseDouble(purchasePrice),Double.parseDouble(retailPrice));
            Parts existingPart = PartsDAO.getPartById(part.getPartID());
            if(existingPart!=null) throw new InvalidDataException("The part with the id: "+part.getPartID()+" has already existed.");
            Parts createdPart = PartsDAO.create(part);
            if (createdPart==null) {
                throw new InvalidDataException("Cannot save product to database!");
            } else {
                response.sendRedirect("parts");
            }
        }
        catch (ValidationException ex) {
            request.setAttribute("validation-err", ex.getErrors());
            request.setAttribute("formData", formData);
            request.getRequestDispatcher(Pages.PART_PAGE).forward(request, response);
        }
        catch(InvalidDataException ex){
            request.setAttribute("invalid-data-exception", ex.getMessage());
            request.setAttribute("formData", formData);
            request.getRequestDispatcher(Pages.PART_PAGE).forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
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

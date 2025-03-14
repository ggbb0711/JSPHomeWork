/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SalePerson;
import utils.constant.Pages;

/**
 *
 * @author NGHIA
 */
public class resolveAuthenticationError {
    public static void authenticate(HttpSession session,HttpServletRequest request, HttpServletResponse response, String authenticatedRole) throws ServletException, IOException{
        SalePerson salePerson = (SalePerson) session.getAttribute("saleperson");
        
        if(salePerson!=null){
            request.setAttribute("message", "You are not authorized for this route. Your current role: Sale person, the role you need to login as: "+authenticatedRole);
            request.getRequestDispatcher(Pages.FORBIDDEN_SALE_PERSON_PAGE).forward(request, response);
        }
        else request.getRequestDispatcher(Pages.FORBIDDEN_PAGE).forward(request, response);
    }
}

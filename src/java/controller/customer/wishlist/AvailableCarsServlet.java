/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.customer.wishlist;

import dao.CarDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import utils.constant.Pages;
import utils.constant.Routes;

/**
 *
 * @author NGHIA
 */
@WebServlet(name = "AvailableCarsServlet", urlPatterns = {Routes.AVAILABLE_CAR_CUSTOMER})
public class AvailableCarsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            CarDAO carDAO = new CarDAO();
            ArrayList<Car> currentCart = new ArrayList<>();
            HttpSession session = request.getSession();
            if(session.getAttribute("cartItems")!=null) currentCart = (ArrayList<Car>) session.getAttribute("cartItems");


            ArrayList<Car> carList = carDAO.findCarNotInCarID(currentCart.stream().map(Car::getCarID).collect(Collectors.toCollection(ArrayList::new)));
            request.setAttribute("availableCar",carList);
            request.getRequestDispatcher(Pages.AVAILABLE_CAR_PAGE).forward(request, response);
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.setStatus(500);
            request.setAttribute("message", ex);
            request.getRequestDispatcher(Pages.INTERNAL_ERROR_CUSTOMER_PAGE).forward(request, response);
        }     

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

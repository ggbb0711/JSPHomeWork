/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.CustomerDAO;
import model.qe170179.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TNO
 */
@WebServlet(name = "Login", urlPatterns = {"customer/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/mechanic/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");

            CustomerDAO cusDAO = new CustomerDAO();

            Customer customer = cusDAO.login(name, phone);

            String msg = "";

            if (customer == null) {
                msg = "name or phone is not valid!";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("views/mechanic/login.jsp").forward(request, response);

            } else {
                HttpSession sesson = request.getSession();
                sesson.setAttribute("customer", customer);

                response.sendRedirect("home");
                return;

            }
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

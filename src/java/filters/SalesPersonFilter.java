/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SalePerson;
import mylib.resolveAuthenticationError;

/**
 *
 * @author NGHIA
 */
@WebFilter(filterName = "SalesPersonFilter", urlPatterns = {"/sales-person/*"})
public class SalesPersonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        HttpSession session = httpReq.getSession(false);    
        
        SalePerson salePerson =  (SalePerson) session.getAttribute("saleperson");
        
        if(salePerson==null){
            resolveAuthenticationError.authenticate(session, httpReq, httpResp, "Sale Person");
            return;
        }
    
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
}

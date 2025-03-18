package org.apache.jsp.views.salePerson.parts.components;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import utils.constant.Routes;

public final class newPartsForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    HashMap<String, String> formData = (HashMap<String, String>) request.getAttribute("formData");

    HashMap<String,String> inputError = (HashMap<String,String>) request.getAttribute("validation-err");
    String partIDErr = (inputError != null) ? inputError.get("partID") : null;
    String nameErr = (inputError != null) ? inputError.get("partName") : null;
    String purchasePriceErr = (inputError != null) ? inputError.get("purchasePrice") : null;
    String retailPriceErr = (inputError != null) ? inputError.get("retailPrice") : null;

    String invalidDataErr = (String) request.getAttribute("invalid-data-exception");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <h1>Create new part</h1>\r\n");
      out.write("    <form class=\"form-container\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/sales-person/CreatePartsServlet\" method=\"POST\">\r\n");
      out.write("        <div class=\"form-input-container\">\r\n");
      out.write("            <label for=\"partID\">ID:</label>\r\n");
      out.write("            <input class=\"form-control\" name=\"partID\" id=\"partID\" required=\"\" type=\"number\" value=\"");
      out.print( (formData != null && formData.get("partID") != null) ? formData.get("partID") : "" );
      out.write("\">\r\n");
      out.write("            <p class=\"form-error-input\">");
      out.print((partIDErr!=null)?partIDErr:"");
      out.write("</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-input-container\">\r\n");
      out.write("            <label for=\"partName\">Name:</label>\r\n");
      out.write("            <input class=\"form-control\" name=\"partName\" id=\"partName\" value=\"");
      out.print( (formData != null && formData.get("partName") != null) ? formData.get("partName") : "" );
      out.write("\">\r\n");
      out.write("            <p class=\"form-error-input\">");
      out.print((nameErr!=null)?nameErr:"");
      out.write("</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-input-container\">\r\n");
      out.write("            <label for=\"purchasePrice\">Purchase price:</label>\r\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"purchasePrice\" id=\"purchasePrice\" value=\"");
      out.print( (formData != null && formData.get("purchasePrice") != null) ? formData.get("purchasePrice") : "" );
      out.write("\">\r\n");
      out.write("            <p class=\"form-error-input\">");
      out.print((purchasePriceErr!=null)?purchasePriceErr:"");
      out.write("</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-input-container\">\r\n");
      out.write("            <label for=\"retailPrice\">Retail price:</label>\r\n");
      out.write("            <input class=\"form-control\" type=\"number\" name=\"retailPrice\" id=\"retailPrice\" value=\"");
      out.print( (formData != null && formData.get("retailPrice") != null) ? formData.get("retailPrice") : "" );
      out.write("\">\r\n");
      out.write("            <p class=\"form-error-input\">");
      out.print((retailPriceErr!=null)?retailPriceErr:"");
      out.write("</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <p class=\"form-error-input\">");
      out.print((invalidDataErr!=null)?invalidDataErr:"");
      out.write("</p>\r\n");
      out.write("        <input class=\"form-submit-btn\" type=\"submit\">\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

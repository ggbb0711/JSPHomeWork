package org.apache.jsp.views.mechanic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Đăng nhập</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("            .login-container {\n");
      out.write("                background-color: white;\n");
      out.write("                padding: 30px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("                width: 350px;\n");
      out.write("            }\n");
      out.write("            h2 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #333;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            .form-group {\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("            }\n");
      out.write("            label {\n");
      out.write("                display: block;\n");
      out.write("                margin-bottom: 5px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: #555;\n");
      out.write("            }\n");
      out.write("            input[type=\"text\"], \n");
      out.write("            input[type=\"tel\"] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("            .btn-submit {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 100%;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("            }\n");
      out.write("            .btn-submit:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("            .error-message {\n");
      out.write("                color: red;\n");
      out.write("                font-size: 14px;\n");
      out.write("                margin-top: 5px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"login-container\">\n");
      out.write("            <h2>Đăng Nhập</h2>\n");
      out.write("\n");
      out.write("            <!-- Hiển thị thông báo lỗi nếu có -->\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"login\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"name\">Họ và tên:</label>\n");
      out.write("                    <input type=\"text\" id=\"name\" name=\"name\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"phone\">Số điện thoại:</label>\n");
      out.write("                    <input type=\"tel\" id=\"phone\" name=\"phone\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <button type=\"submit\" class=\"btn-submit\">Đăng Nhập</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            document.querySelector('form').addEventListener('submit', function (e) {\n");
      out.write("                const phoneInput = document.getElementById('phone');\n");
      out.write("                const phonePattern = /^[0-9]{9}$/;\n");
      out.write("                const errorMessage = document.querySelector('.error-message');\n");
      out.write("\n");
      out.write("                if (!phonePattern.test(phoneInput.value)) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    errorMessage.innerText = 'Vui lòng nhập số điện thoại hợp lệ (9 số)';\n");
      out.write("                    errorMessage.style.display = 'block';\n");
      out.write("                    phoneInput.focus();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty msg}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <div class=\"error-message\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</div>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}

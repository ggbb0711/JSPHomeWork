package org.apache.jsp.views.mechanic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Scarica gratis GARAGE Template html/css - Web Domus Italia - Web Agency </title>\n");
      out.write("        <meta name=\"description\" content=\"Scarica gratis il nostro Template HTML/CSS GARAGE. Se avete bisogno di un design per il vostro sito web GARAGE può fare per voi. Web Domus Italia\">\n");
      out.write("        <meta name=\"author\" content=\"Web Domus Italia\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"source/bootstrap-3.3.6-dist/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"source/font-awesome-4.5.0/css/font-awesome.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/slider.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/mystyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"source/custon-css/header-customer.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Header -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/header.jsp", out, false);
      out.write("\n");
      out.write("            <!-- Header -->\n");
      out.write("            <!--_______________________________________ Carousel__________________________________ -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/Carousel.jsp", out, false);
      out.write("\n");
      out.write("            <!-- ____________________Featured Section ______________________________--> \n");
      out.write("            <div class=\"allcontain\">\n");
      out.write("\n");
      out.write("                <!-- ________________________LATEST CARS SECTION _______________________-->\n");
      out.write("                <div class=\"latestcars\">\n");
      out.write("                    <h1 class=\"text-center\">&bullet; LATEST   CARS &bullet;</h1>\n");
      out.write("                    <ul class=\"nav nav-tabs navbar-left latest-navleft\">\n");
      out.write("                        <li role=\"presentation\" class=\"li-sortby\"><span class=\"sortby\">SORT BY: </span></li>\n");
      out.write("                        <li data-filter=\".RECENT\" role=\"presentation\"><a href=\"#mostrecent\" class=\"prcBtnR\">MOST RECENT </a></li>\n");
      out.write("                        <li data-filter=\".POPULAR\" role=\"presentation\"><a href=\"#mostpopular\" class=\"prcBtnR\">MOST POPULAR </a></li>\n");
      out.write("                        <li  role=\"presentation\"><a href=\"#\" class=\"alphSort\">ALPHABETICAL </a></li>\n");
      out.write("                        <li data-filter=\".HPRICE\" role=\"presentation\"><a href=\"#\" class=\"prcBtnH\">HIGHEST PRICE </a></li>\n");
      out.write("                        <li data-filter=\".LPRICE\" role=\"presentation\"><a href=\"#\" class=\"prcBtnL\">LOWEST  PRICE </a></li>\n");
      out.write("                        <li id=\"hideonmobile\">\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <div class=\"grid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xs-12 col-sm-6 col-md-4 col-lg-3\">\n");
      out.write("                            <div class=\"txthover\">\n");
      out.write("                                <img src=\"image/car1.jpg\" alt=\"car1\">\n");
      out.write("                                <div class=\"txtcontent\">\n");
      out.write("                                    <div class=\"stars\">\n");
      out.write("                                        <div class=\"glyphicon glyphicon-star\"></div>\n");
      out.write("                                        <div class=\"glyphicon glyphicon-star\"></div>\n");
      out.write("                                        <div class=\"glyphicon glyphicon-star\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"simpletxt\">\n");
      out.write("                                        <h3 class=\"name\">Rolls Royce</h3>\n");
      out.write("                                        <p>\"Lorem ipsum dolor sit amet, consectetur,<br>\n");
      out.write("                                            sed do eiusmod tempor incididunt\" </p>\n");
      out.write("                                        <h4 class=\"price\"> 1000&euro;</h4>\n");
      out.write("                                        <button>READ MORE</button><br>\n");
      out.write("                                        <div class=\"wishtxt\">\n");
      out.write("                                            <p class=\"paragraph1\"> Add to Wishlist <span class=\"glyphicon glyphicon-heart\"></span> </p>\n");
      out.write("                                            <p class=\"paragraph2\">Compare <span class=\"icon\"><img src=\"image/compicon.png\" alt=\"compicon\"></span></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"stars2\">\n");
      out.write("                                        <div class=\"glyphicon glyphicon-star\"></div>\n");
      out.write("                                        <div class=\"glyphicon glyphicon-star\"></div>\n");
      out.write("                                        <div class=\"glyphicon glyphicon-star\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\t \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"source/js/header-customer.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"source/bootstrap-3.3.6-dist/js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"source/js/isotope.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"source/js/myscript.js\"></script> \n");
      out.write("        <script type=\"text/javascript\" src=\"source/bootstrap-3.3.6-dist/js/jquery.1.11.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"source/bootstrap-3.3.6-dist/js/bootstrap.js\"></script>\n");
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
}

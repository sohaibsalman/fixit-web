package org.apache.jsp.html.fixer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_002dfixer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../helper/h-link.html", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <title>Sign up</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <header class=\"signup-header\">\r\n");
      out.write("        <div class=\"container-fluid\" style=\"padding: 0;\">\r\n");
      out.write("            <div class=\"row no-gutters\">\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"signup__img\">\r\n");
      out.write("                        <img src=\"img/signup/1.png\" alt=\"\" class=\"img-fluid\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <div class=\"signup__form\">\r\n");
      out.write("                        <div class=\"form--center\">\r\n");
      out.write("                            <h1 class=\"heading-main\">FIXIT</h1>\r\n");
      out.write("                            <h5 class=\"u-margin-top-small\">Signup as a Fixer</h5>\r\n");
      out.write("                            <form action=\"FormController\" method=\"post\">\r\n");
      out.write("                                <input type=\"hidden\" name=\"command\" value=\"FIXER-CREDENTIALS\">\r\n");
      out.write("                                <div class=\"container u-margin-top-huge\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-md-12\">\r\n");
      out.write("                                            <input type=\"text\" name=\"username\" placeholder=\"Username\" required>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-12\">\r\n");
      out.write("                                            <input type=\"email\" name=\"email\" placeholder=\"Email\" required>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-12\">\r\n");
      out.write("                                            <input type=\"password\" name=\"password\" placeholder=\"Password\" required>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-12 u-margin-top-medium\">\r\n");
      out.write("                                            <input type=\"submit\" value=\"Create Your Account\" class=\"btn-submit\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

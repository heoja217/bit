/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.15
 * Generated at: 2014-12-05 06:42:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/Header.jsp", out, false);
      out.write("  \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class='container'>\n");
      out.write("<h1>로그인</h1>\n");
      out.write("<form class='form-horizontal' role='form' \n");
      out.write("  action='login.do' method='post'>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='uid' class='col-sm-2 control-label'>아이디</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <input type='text' class='form-control' \n");
      out.write("        id='uid' name='uid' placeholder='아이디' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='pwd' class='col-sm-2 control-label'>암호</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <input type='password' class='form-control' \n");
      out.write("        id='pwd' name='pwd' placeholder='암호'>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"form-group\">\n");
      out.write("  <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t<div class='checkbox'>\n");
      out.write("\t    <label>\n");
      out.write("\t\t    <input type='checkbox' id='save' name='save'> 아이디 저장\n");
      out.write("\t\t  </label>\n");
      out.write("\t\t</div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <div class='col-sm-offset-2 col-sm-10'>\n");
      out.write("    <button id='btnAdd' type='submit' class='btn btn-primary'>로그인</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<script src='../js/jquery-1.11.1.js'></script>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/Footer.jsp", out, false);
      out.write(" \n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

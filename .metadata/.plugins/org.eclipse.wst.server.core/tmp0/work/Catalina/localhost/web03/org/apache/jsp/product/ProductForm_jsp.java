/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.15
 * Generated at: 2014-12-01 02:39:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ProductForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/home/bit/git/bit/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web03/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1416808365000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/Header.jsp", out, false);
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class='container'>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/LoginPanel.jsp", out, false);
      out.write("  \n");
      out.write("<h1>제품 등록</h1>\n");
      out.write("<form class='form-horizontal' role='form' \n");
      out.write("  action='add.do' method='post' enctype='multipart/form-data'>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='name' class='col-sm-2 control-label'>제품</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <input type='text' class='form-control' \n");
      out.write("        id='name' name='name' placeholder='제품명 예) 아이폰6 플러스'>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='qty' class='col-sm-2 control-label'>수량</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <input type='text' class='form-control' \n");
      out.write("        id='qty' name='quantity' placeholder='수량 예) 20'>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='mkno' class='col-sm-2 control-label'>제조사</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <select id='mkno' name='makerNo' class='form-control'>\n");
      out.write("      <option value=\"0\">제조사를 선택하세요</option>\n");
      out.write("      ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("    </select>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='madeDate' class='col-sm-2 control-label'>제조일</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <input type='date' class='form-control' id='madeDate' name='madeDate' placeholder='제조일 예)2014-02-17 '>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <label for='photo' class='col-sm-2 control-label'>제조일</label>\n");
      out.write("  <div class='col-sm-10'>\n");
      out.write("    <input type='file' class='form-control' id='photo' name='photofile'>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class='form-group'>\n");
      out.write("  <div class='col-sm-offset-2 col-sm-10'>\n");
      out.write("    <button id='btnAdd' type='submit' class='btn btn-primary'>등록</button>\n");
      out.write("    <button id='btnCancel' type='button' class='btn btn-primary'>취소</button>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<script src='../js/jquery-1.11.1.js'></script>\n");
      out.write("<script>\n");
      out.write("  $('#btnCancel').click(function(){\n");
      out.write("    history.back();\n");
      out.write("  });\n");
      out.write("  \n");
      out.write("  $('#btnAdd').click(function(){\n");
      out.write("    if ( $('#name').val().length == 0) {\n");
      out.write("      alert('제품명은 필수 입력 항목입니다.');\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    if ( $('#qty').val().length == 0) {\n");
      out.write("      alert('수량은 필수 입력 항목입니다.');\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    if ( $('#mkno').val() == '0') {\n");
      out.write("      alert('제조사를 선택하세요');\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("  });\n");
      out.write("</script>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/Footer.jsp", out, false);
      out.write(" \n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /product/ProductForm.jsp(34,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/product/ProductForm.jsp(34,6) '${makers}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${makers}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /product/ProductForm.jsp(34,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("maker");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("        <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${maker.no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${maker.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("      ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}

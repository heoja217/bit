package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* Include에 사용할 서블릿
 => HTML페이지의 헤더부분을 맡음.
*/

//@WebServlet("/common/header")
public class HtmlHeaderServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		//웹 애플리케이션의 보여주는 출력명 얻기
		//web.xml<display-name> 
		//그리고 이 태그의 값은 관리자 화면에 출력됨.
		//this.getServletContext().getServletContextName();
		//웹 애플리케이션 경로 알아내기  예)/web02
		String webAppPath = this.getServletContext().getContextPath();
		
		PrintWriter out = response.getWriter();
		
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath + "/css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath + "/css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='" + webAppPath + "/css/common.css'>");
	}

}

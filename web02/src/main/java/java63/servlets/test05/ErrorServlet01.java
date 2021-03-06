package java63.servlets.test05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/common/error")
public class ErrorServlet01 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");

    //다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    RequestDispatcher rd = 
    		request.getRequestDispatcher("/common/header");
    rd.include(request, response);

    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<p>잠시 후 다시 시도해 주세요.</p>");

    out.println("</div>");

    out.println("</body>");
    out.println("</html>");
    
    
    // 오류에 대한 자세한 정보는 콘솔창에 출력!
    Exception e = (Exception) request.getAttribute("error");
    e.printStackTrace();
    		
  }
  
}













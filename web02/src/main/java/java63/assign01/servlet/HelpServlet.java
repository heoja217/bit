package java63.assign01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;



@WebServlet("/help")
public class HelpServlet extends GenericServlet{
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<body>");
    out.println("<p>list</p>");
    out.println("<p>view 제품번호</p>");
    out.println("<p>add</p>");
    out.println("<p>delete 제품번호</p>");
    out.println("<p>update 제품번호</p>");
    out.println("</body>");
    out.println("</html>");
    out.println();   
  }
}










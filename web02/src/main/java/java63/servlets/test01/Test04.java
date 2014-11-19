package java63.servlets.test01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/* 웹 브라우저가 보낸 데이터 꺼내기
 => request.getParameter("파라미터명")
 
 GET 방식으로 전달되는 데이터
  => Tomcat8(자동처리), 
  => Tomcat7 이하 : server.xml 파일을 다음과같이 편집
    <Connector connectionTimeout="20000" 
               port="8080" 
               protocol="HTTP/1.1" 
               redirectPort="8443"
               URIEncoding="UTF-8"/>//URIEncoding 속성 추가
               
 POST 방식으로 전달되는 데이터 
  => Tomcat8(?)
  => Tomcat7이하 :
      1) request.setCharacterEncoding("UTF-8");
      2) 1번을 먼저 호출한 다음에 getParameter()를 호출
      3) getParameter()를 호출하기전에 1번을 수행.
        단 한번이라도 getParameter()가 호출된 다음에 1번을 수행하면 효과 없음.
 */
@WebServlet("/test01/Test04")
public class Test04 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    System.out.println(name.length());
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>안녕하세요. " + name + "님!</h1>");
    out.println("</body>");
    out.println("</html>");
   
    
  }

}


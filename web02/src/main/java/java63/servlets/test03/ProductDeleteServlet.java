package java63.servlets.test03;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

/* Redirect 하기2
 * => 클라이언트에게 콘텐츠를 보내지 않는다.
 * => 응답 헤어에 다시 요청할 주소를 보낸다.
 * 
 */

@WebServlet("/test03/product/delete")
public class ProductDeleteServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    //AppInitServlet.productDao.delete(no);
    //ContextLoaderListener.productDao.delete(no);
    
    ProductDao productDao = (ProductDao)this.getServletContext().getAttribute("productDao");
    productDao.delete(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>삭제 결과</h1>");
    out.println("<p>삭제하였습니다</p>");
    out.println("</div>");
    
    out.println("</body>");
    out.println("</html>");
    
    /* Redirect는 클라이언트에 재요청 URL만 보낸다
     따라서 이전에 출력한 콘텐츠는 취소한다. 
     => 버퍼에 출력된 내용은 클라이언트에 보내지 않고 버림!
    */
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");  
    
    /* Redirect의 응답 내용
     
     
     
    */
  }
}













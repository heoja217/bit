package java63.servlets.test05;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.test05.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/* Redirect 하기2
 * => 클라이언트에게 콘텐츠를 보내지 않는다.
 * => 응답 헤어에 다시 요청할 주소를 보낸다.
 * 
 */

@WebServlet("/test05/product/delete")
public class ProductDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));

    ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(
    		this.getServletContext());
    ProductDao productDao = (ProductDao) appCtx.getBean("productDao");
    
    productDao.delete(no);
   
    response.sendRedirect("list");  
    
     
  }
}













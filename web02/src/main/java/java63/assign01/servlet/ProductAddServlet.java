package java63.assign01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java63.assign01.dao.ProductDao;
import java63.assign01.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
//add?name=ohora2&qty=200&mkno=1  
@WebServlet("/product/add")
public class ProductAddServlet extends GenericServlet{
  ProductDao productDao; 
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    productDao = new ProductDao();  
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      Product product = new Product();
      product.setName(request.getParameter("name"));
      product.setQuantity(Integer.parseInt(request.getParameter("qty")));
      product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));

      productDao.insert(product);

      out.println("<html>");
      out.println("<body>");
      out.println("<p>저장하였습니다.</p>");
    
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<p>서버가 바쁩니다. 잠시 후 다시 시도하세요.</p>");
    } finally {
      out.println("</body>");
      out.println("</html>");
    }
  
  }    

}

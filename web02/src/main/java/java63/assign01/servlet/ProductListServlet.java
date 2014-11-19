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

@WebServlet("/product/list")
public class ProductListServlet extends GenericServlet{
  
  ProductDao productDao; 
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    productDao = new ProductDao();  

    int pageNo = 0;
    int pageSize = 0;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      pageSize = 3;
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<body>");
    try {
      for (Product product : productDao.selectList(pageNo, pageSize)) {

          out.println("<p>" + product.getNo() + "  "
              + product.getName() + "  "
              + product.getQuantity() + "  " 
              + product.getMakerNo() + "</p>");

        }
    } catch (Exception e) {
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  
  }    

}

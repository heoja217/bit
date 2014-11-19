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

@WebServlet("/product/update")
public class ProductUpdateServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    ProductDao productDao = new ProductDao();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    

    try {
      Product product = new Product();
      product.setNo(Integer.parseInt(request.getParameter("no")));
      product.setName(request.getParameter("name"));
      product.setQuantity(Integer.parseInt(request.getParameter("qty")));
      product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
      
      productDao.update(product);
      out.println("<p>변경하였습니다.<p>");
      out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<p>서버가 바쁩니다. 잠시 후 다시 시도하세요.<p>");
      out.println();
    }
    
  }

}

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


@WebServlet("/product/delete")
public class ProductDeleteServlet extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    ProductDao productDao = new ProductDao();
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
      int no = Integer.parseInt(request.getParameter("no"));
      
      Product product;

      try {
        product = productDao.selectOne(no);
        if (product == null) {
          out.println("<p>해당 번호의 제품 정보를 찾을 수 없습니다.</p>");
          out.println();
          return;
        }
        productDao.delete(no);
        out.println("<p>삭제하였습니다.</p>");
        out.println();
      } catch (Exception e) {
        e.printStackTrace();
      }

  }

}

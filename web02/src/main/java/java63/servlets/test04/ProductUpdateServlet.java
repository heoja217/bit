package java63.servlets.test04;

import java.io.IOException;
import java63.servlets.test04.dao.ProductDao;
import java63.servlets.test04.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test04/product/update")
public class ProductUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // 다음 코드를 필터로 대체.
  	//request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    product.setNo(Integer.parseInt(request.getParameter("no")));
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    //ProductDao productDao = (ProductDao)this.getServletContext().getAttribute("productDao");
    ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx.getBean("productDao");

    productDao.update(product);
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}









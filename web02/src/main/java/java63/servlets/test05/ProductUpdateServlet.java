package java63.servlets.test05;

import java.io.IOException;
import java63.servlets.test05.dao.ProductDao;
import java63.servlets.test05.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/test05/product/update")
public class ProductUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 다음 코드를 필터로 대체.
  	//request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    product.setNo(Integer.parseInt(request.getParameter("no")));
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    //ProductDao productDao = (ProductDao)this.getServletContext().getAttribute("productDao");
    //ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx.getBean("productDao");

    ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(
    		this.getServletContext());
    ProductDao productDao = (ProductDao) appCtx.getBean("productDao");
    
    productDao.update(product);
    
    response.sendRedirect("list");
  }
  
}









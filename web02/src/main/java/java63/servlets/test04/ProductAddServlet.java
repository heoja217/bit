package java63.servlets.test04;

import java.io.IOException;

import java63.servlets.test04.dao.ProductDao;
import java63.servlets.test04.domain.Product;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test04/product/add")
public class ProductAddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    // 다음 코드를 필터로 대체.
    //request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    //ProductDao productDao = (ProductDao)this.getServletContext().getAttribute("productDao");
    ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx.getBean("productDao");
    try {
    	productDao.insert(product);
    } catch (Exception e) {
      RequestDispatcher rd = 
      		request.getRequestDispatcher("/common/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }


    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");  
    
  }
  
}













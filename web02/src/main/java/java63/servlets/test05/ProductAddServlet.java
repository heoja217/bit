package java63.servlets.test05;

import java.io.IOException;
import java63.servlets.test05.dao.ProductDao;
import java63.servlets.test05.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/test05/product/add")
public class ProductAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  		throws ServletException, IOException {
    RequestDispatcher rd = 
    		request.getRequestDispatcher("/test05/product/ProductForm.jsp");
    rd.forward(request, response);

  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    Product product = new Product();
    
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    
    //ProductDao productDao = (ProductDao) ContextLoaderListener.appCtx.getBean("productDao");

    ApplicationContext appCtx =
        WebApplicationContextUtils.getWebApplicationContext(
            this.getServletContext());
    
    ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
    try {
    	productDao.insert(product);
    } catch (Exception e) {
      RequestDispatcher rd = 
      		request.getRequestDispatcher("/common/error");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }

    response.sendRedirect("list");  
    
  }
  
}













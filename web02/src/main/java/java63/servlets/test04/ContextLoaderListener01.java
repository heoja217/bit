package java63.servlets.test04;

import java.io.InputStream;
import java63.servlets.test04.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ContextLoaderListener01 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext ctx = sce.getServletContext();
			InputStream inputStream = Resources.getResourceAsStream(
					ctx.getInitParameter("mybatisConfig"));
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);

			
			ProductDao productDao = new ProductDao();
			productDao.setSqlSessionFactory(sqlSessionFactory);
			
			//ServletConstext보관소에 객체 저장
			ctx.setAttribute("productDao", productDao);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 웹 애플리케이션이 종료될때 호출
	// => 서블릿이 사용한 자원을 해제
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}


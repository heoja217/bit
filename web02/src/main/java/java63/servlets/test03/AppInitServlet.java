package java63.servlets.test03;

import java.io.IOException;
import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//@WebServlet(name = "AppInitServlet", loadOnStartup = 1) //버그!
public class AppInitServlet extends GenericServlet {
	
	public static ProductDao productDao;//다른서블릿도 접근가능하도록 static으로 설정.
	
	public AppInitServlet() {
		System.out.println("AppInitServlet 생성됨");
	}

	/* 외부 자원을 참조하는 경우
	 가능한 하드코딩하지 말고 설정 파일에서 읽어오는 방식으로 처리하라!
	
	설정파일: web.xml
	설정방법
	<servlet>
		<servlet name>...</servlet-name>
		<servlet class>...</servlet-class>
		<init-param>
			<param-name>키</param-name>
			<param-value>값</param-value>
		</init-param>
		<init-param>
			<param-name>키</param-name>
			<param-value>값</param-value>
		</init-param>
		:
		:
	</servlet>
	
	설정값을 꺼내는 방법
	=> ServletConfig 객체의 getInitParameter("키")
	*/
	@Override
	public void init() throws ServletException {
    try {
      InputStream inputStream = Resources.getResourceAsStream(
      		getServletConfig().getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
	}
}

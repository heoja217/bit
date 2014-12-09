package java63.servlets.test03;

import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*  공통으로 사용하는 자원은 보통 ServletContext에 보관한다
 
 ServletContext :웹 애플리케이션 시작 시 생성. 종료시 제거
 HttpSession :최초요청시 생성 
 HttpServletRequest
 PageContext
 */

/* 보관소 
  ┌ServletContext─────────────────────────┐
  │					┌Http Session────┐		┌Http Session─────┐
  │					│				┌S1──S2┐
	│					│		pageContext pageContext					
	│					│
	│					│
	│					│
WebApp──최초요청─요청───응답─Timeout───최초요청 ────Timeout───WebAppStop
 start														 invalidate										or invalidate		

*/

public class ContextLoaderListener implements ServletContextListener {
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


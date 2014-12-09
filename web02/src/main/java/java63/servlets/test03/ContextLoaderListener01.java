package java63.servlets.test03;

import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* ServletContextListener 
 * 웹 애플리케이션이 시작하거나 종료하는 이벤트에 대해 작업을 수행
 *
 *컨텍스트 파라미터?
 => 웹 애플리케이션에서 사용할 환경 변수 정의할때 사용.
 => 모든 서블릿이 사용가능
 
 *설정 방법:web-xml에 다음과같이 설정
 <context-param>
 	<param-name>키</param-name>
 	<parma-value>값</param-value>
 </context-param>
 
 * 사용 방법 
 ServletContext 의 getInitParameter(키) 호출
 */


//@WebListener
public class ContextLoaderListener01 implements ServletContextListener {
	public static ProductDao productDao;

	// 웹 애플리케이션이 시작될때 호출
	// => 서블릿이 사용할 공통 자원 준비
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext ctx = sce.getServletContext();
			InputStream inputStream = Resources.getResourceAsStream(
					ctx.getInitParameter("mybatisConfig"));
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);

			productDao = new ProductDao();
			productDao.setSqlSessionFactory(sqlSessionFactory);

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

/* ServletContext
  : 웹 애플리케이션 정보를 다루는 역할.
 - 컨텍스트 파라미터값 조회
 - 웹 애플리케이션의 배치 경로 
 - 값을 저장할 수 있는 보관소
 			    								ㄴ공통자원 보관
 - *웹 어플리케이션당 하나의 ServletContext객체만 생성 가능

 */


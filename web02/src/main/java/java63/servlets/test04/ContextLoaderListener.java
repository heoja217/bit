package java63.servlets.test04;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ContextLoaderListener implements ServletContextListener {
	static ApplicationContext appCtx;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			
	    appCtx = new ClassPathXmlApplicationContext(//스프링 IOC컨테이너
	          new String[]{"java63/servlets/test04/application-context.xml"});

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


package java63.servlets.test05;

import java.io.IOException;

/*  Filter 
 	요청처리 전/후에 수행할 작업
 	- 특정작업을 추가하거나 제거하기가 쉽다 
 			└로그기록, 암호해제/암호화, 디코딩/인코딩, Auth(인증/권한검사)
 	방법:web.xml에 설정정보 추가 
 	
 	
 	요청→┌<<Servlet  Container>>┐  
 				│				Tomcat        │
 	응답←└───────────┘
 							리턴↑↓doFilter()
 						 ┌─────┐  
 						 │		필터	 │
 					   └─────┘
 							리턴↑↓doFilter()
 						 ┌─────┐
 						 │		필터	 │
 						 └─────┘
 							리턴↑↓service()
 						┌──────┐
 						│	:Servlet  │
 						└──────┘
 									↑↓
 						  ┌─┘└─┐
 						  │ service│
 						  └────┘
 						  
 						      
 			* 필터 만들기
 			
 				┌<< interface>>┐  
 				│	  Filter    │
 				└───────┘
 							  ↑
  	┌────────────┐  
 		│ CharacterEncodingFilter│
 		└────────────┘
							init()
							doFilter()
							destroy
 	
*/
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		
		//다음 필터를 실행하기 전에 해야 할 일
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		System.out.println(httpRequest.getRemoteAddr());
		
		//다음 필터 실행하기
		//단, 더 이상 다음 필터가 없으면 톰캣 서버는 해당 서블릿을 실행한다.
		nextFilter.doFilter(request, response);
		
		//다음 필터를 실행한 후에 해야 할 일
		System.out.println("LogFilter 끗!");
	}

	@Override
	public void destroy() {}
	

}

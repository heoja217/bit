package java63.web03.control.bind;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/* 프런트 컨트롤러에게 조언하고 싶다!
 =>프런트 컨트롤러에게 조언하는 역할의 클래스는 @ControllerAdivce를 붙임
 => @ControllerAdvice가 붙은 클래스는 스프링에서 적절히 메서드를 호출...
 
 
스프링 MVC 프레임워크에 다음 클래스는 조언할 기능이 있는 클래스이니 
살펴보고 상황에 알맞는 메서드를 호출하도록 
*/
@ControllerAdvice
public class GlobalInitBinder {
	static Logger log = Logger.getLogger(GlobalInitBinder.class);
	
	// 조언 1 => 문자열의 요청 파라미터 값을 java.util.Date로 바꿀시 다음 CustumDateEditer를 사용하라.
  @InitBinder
  public void initBinder(WebDataBinder binder) {
  	log.debug("initBinder() 호출됨");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    
    // 문자열을 특정 타입으로 바꿀 변환기 등록
    binder.registerCustomEditor(Date.class, //어떤 타입으로 변환할 것인지 지정
    		new CustomDateEditor(dateFormat, true)// 변환기
    ); 
  }

}

package java02.test21.spring.exam05;

/* Spring Bean Container 사용하기
 * 1) ClassPathXmlApplicationContext -> 클래스 경로에서 설정파일을 찾는다
 * 2) FileSystemXmlApplication -> 설정 파일이 있는 경로 지정
 * 
*/
import java02.test21.spring.exam05.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    //Carc =new Car();
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        new String[]{"java02/test21/spring/exam05/application-context.xml"});

    Car c1 = (Car)ctx.getBean("b01");
    System.out.println(c1);
    
    Car c2 = (Car)ctx.getBean("b02");
    System.out.println(c2);
    
    
  }
  
  
}

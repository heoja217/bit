package java02.test21.spring.exam02;

/* 
 * 
*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    //Carc =new Car();
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        new String[]{"java02/test21/spring/exam02/application-context.xml"});
    Car c1 = (Car)ctx.getBean("b01");
    Car c2 = (Car)ctx.getBean("b02");
    Car c3 = (Car)ctx.getBean("b03");
    Car c4 = (Car)ctx.getBean("b04");
    Car c5 = (Car)ctx.getBean("b05");
    //Car c6 = (Car)ctx.getBean("b06");// 빈을 찾지못하면 에러발생!
    

    Car c11 = (Car)ctx.getBean("b11");
    Car c12 = (Car)ctx.getBean("b12");
    Car c13 = (Car)ctx.getBean("b13");

    Car c21 = (Car)ctx.getBean("b21");
    Car c22 = (Car)ctx.getBean("b22");
    Car c23 = (Car)ctx.getBean("b23");
    

    // 빈을 설정할때 이름을 지정하지않으면 패키지명+클래스명+#인덱스를 이름으로 사용
    // 그리고 0번 빈의 별명은 "패키지명+클래스명"이 됨
    Car c30 = (Car)ctx.getBean("java02.test21.spring.exam02.Car");
    Car c31 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#0");
    
    if (c31 == c30) System.out.println("c31==c30");
    Car c32 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#1");
    Car c33 = (Car)ctx.getBean("java02.test21.spring.exam02.Car#2");
    
  
    
  }
  
  
}

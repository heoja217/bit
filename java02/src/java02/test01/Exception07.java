/* 예외 발생을 먼 호출자에 던지고자 할때
 - 바로 전 호출자가 아닌 상위의 호출자에게 오류 정보를 던지고 싶을때
    RuntimeException 객체 사용
 - RuntimeException 은 Exception의 자식이지만 Error 처럼 동작.
 - Error를 그냥 사용하면?
   => Error는 시스템 오류를 담을때 사용되는것으로 애플리케이션에서 Error를 사용하는것은 바람직하지 않음.
   => 그럼에도 Error 형태와 같은 예외를 던지고 싶을 때 RuntimeException 클래스를 을 사용
 */
package java02.test01;

import java.util.Scanner;
/* RuntimeException 을 사용하지 않을 경우
  상위 호출자에게 오류를 보내기 위해 메서드 선언에 반드시 throws명령을 붙여야함.
*/
public class Exception07 {
  static int a;
  static int b;
  static String op;

  static class Calculator {
    // Exception 대신 RuntimeException 을 던진다.
    public static int compute(int a, int b, String op) 
        /*throws Exception*/ {
      switch (op) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      default:
        throw new RuntimeException("지원하지 않는 연산자입니다");
      }
    }
  }
  
  // compute()에서는 RuntimeException을 던짐.
  // try ... catch로 처리하지 않으면 *자동으로!!!!!! 상위호출자에게 던짐
  // -> throws 문장 선언하지 않아도 되므로 코드가 간결해짐.
  // 아래와같이 일반 메서드 호출하듯이 호출 가능. 
  public static void printResult() /*throws Exception*/ {
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("result = " + Calculator.compute(a, b, op));
  }
  
  public static void printContent()/* throws Exception */{
    System.out.println("****************************");
    printResult();
    System.out.println("****************************");
  }
  
  public static void printPage()/* throws Exception */{
    System.out.println("머리말~~~~~~~~`");
    printContent();
    System.out.println("꼬리말~~~~~~~~`");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("a?");
      a = Integer.parseInt(scanner.next());

      System.out.println("b?");
      b = Integer.parseInt(scanner.next());

      System.out.println("op?");
      op = scanner.next();
      
      // compute()에서 발생된 예외를 중간의 메서드에서는 처리할 필요가 없다
      // 처음 호출자가 통합하여 처리하므로 오류관리가 쉽고 코드가 간결해진다.
      try {
      printResult();  
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }

    }

  }
}

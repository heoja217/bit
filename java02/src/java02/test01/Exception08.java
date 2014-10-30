/* finally 블록
 * try 블록에서 예외가 발생하든 한하든 반드시 실행하는 블록
 * try블록에서 생성항 자원을 해제하는 코드를 둔다.
 */
package java02.test01;

import java.util.Scanner;
public class Exception08 {
  static int a;
  static int b;
  static String op;

  static class Calculator {
    public static int compute(int a, int b, String op) {
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
  
  public static void printResult() {
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("result = " + Calculator.compute(a, b, op));
  }
  
  public static void printContent() {
    System.out.println("****************************");
    printResult();
    System.out.println("****************************");
  }
  
  public static void printPage() {
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
      
      try {
      printPage();  
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      } finally {
        //try 또는 catch블록을 벗어나기 전에 반드시 실행하는 블록
        System.out.println("finally");
      }
    }

  }
}

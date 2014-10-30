/* 예외 처리 의미
  1) 리턴값으로 예외상황을 알릴 수 없는 경우
  2) 리턴값으로 예외상황을 알리더라도 연산결과와 충돌이 일어날때
  3) 작업코드와 오류처리 코드를 분리하여 코드 가독성을 높임
 *4) 오류가 발생했을 때 시스템을 종료하지 않고 계속 수행가능하게 함
 */
package java02.test01;

import java.util.Scanner;

public class Exception05 {
  public static int divide(int a, int b) {
    if (b == 0)
      throw new Error("0으로 나눌 수 없음");
    return a / b;
  }

  public static void main01(String[] args) {
    // 예외상황 발생시 시스템 Stop!
    Scanner scanner = new Scanner(System.in);
    int a, b;
    while (true) {
      System.out.println("a?");
      a = Integer.parseInt(scanner.nextLine());

      System.out.println("b?");
      b = Integer.parseInt(scanner.nextLine());
      System.out.println("결과(a/b) " + divide(a, b));

      System.out.println("계속하시겠시겠습니까(y/n)");
      if (scanner.nextLine().equals("n"))
        break;
    }
    scanner.close();
  }
  
  
  // 개선
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a, b;
    while (true) {
      System.out.println("a?");
      a = Integer.parseInt(scanner.nextLine());

      System.out.println("b?");
      b = Integer.parseInt(scanner.nextLine());
      
      try { // 예외가 발생해도 간단히 처리하고 계속 실행...
      System.out.println("결과(a/b) " + divide(a, b));     
      } catch (Error ex) {
        System.out.println(ex.getMessage());
      }

      System.out.println("계속하시겠시겠습니까(y/n)");
      if (scanner.nextLine().equals("n"))
        break;
    }
    scanner.close();

  }
}

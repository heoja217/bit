/*
   메서드
  공개범위 스태틱여부 리턴타입 메서드명(타입 변수명, 타입 변수명, ...) {
    return 값;
    }  
   int plus(int i, int b) {
     return i + b;
   }
 */
package java01;

//사용자로부터 두 개의 값과 연산자를 입력받아 계산 후 결과 출력
//값1 : 10 ,값2 : 20, 연산자 : + 
//$ 10 + 30 = 30 입니다

import java.util.Scanner;

//step 2 메서드 도입 => 결과 출력을 별도의 메서드로 분리

public class Test27_3 {

  static void displayResult(
      int v1, int v2, String op, int result) {
    System.out.printf("%d %s %d = %d\n", 
        v1, op, v2, result);
  }
/*  
  static void compute(int v1, int v2, String op){
    int result = 0;
    switch(op){
    case "+": result = v1 + v2; break;
    case "-": result = v1 - v2; break;
    case "*": result = v1 * v2; break;
    case "/": result = v1 / v2; break;
    }
    displayResult(v1, v2, op, result);
  }
  */
  
  static int compute(int v1, int v2, String op){
    int result = 0;
    switch(op){
    case "+": result = v1 + v2; break;
    case "-": result = v1 - v2; break;
    case "*": result = v1 * v2; break;
    case "/": result = v1 / v2; break;
    }
    return result;
  }


  public static void main(String[] args) {
    // switch문을 사용하여 계산결과를 result변수에 담아서 출력
    Scanner scanner = new Scanner(System.in);

    System.out.print("값1? ");
    int v1 = Integer.parseInt(scanner.nextLine());
    System.out.print("값2? ");
    int v2 = Integer.parseInt(scanner.nextLine());
    System.out.print("연산자? ");
    String op = scanner.nextLine();
    
    compute(v1, v2, op);
    displayResult(v1, v2, op,  compute(v1, v2, op));


    }


}

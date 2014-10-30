/* 클래스
 */
package java01;

//사용자로부터 두 개의 값과 연산자를 입력받아 계산 후 결과 출력
//값1 : 10 ,값2 : 20, 연산자 : + 
//$ 10 + 30 = 30 입니다

import java.util.Scanner;

// step 5 클래스 분리
//        -> Calculator 클래스 정의, 계산과 관련된
public class Test00 {
  static int v1;
  static int v2;
  static String op;
  static int result;

  static void displayResult() {
    System.out.printf("%d %s %d = %d\n", 
        v1, op, v2, result);
  }

  
  static void compute(){
    switch(op){
    case "+": result = v1 + v2; break;
    case "-": result = v1 - v2; break;
    case "*": result = v1 * v2; break;
    case "/": result = v1 / v2; break;
    }
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("값1? ");
    v1 = Integer.parseInt(scanner.nextLine());
    System.out.print("값2? ");
    v2 = Integer.parseInt(scanner.nextLine());
    System.out.print("연산자? ");
    op = scanner.nextLine();
    
    compute();
    displayResult();


    }


}

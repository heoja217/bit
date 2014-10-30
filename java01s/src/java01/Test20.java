/* 조건문 
프로그램 아규먼트로 나이를 입력받아 청소년 청년 등의 여부를 출력하시오
 */
package java01;

public class Test20 {

  public static void main(String[] args) {
    int age= 10;
    switch (age/10){
    case 1 :  System.out.println("10");
      break;
    case 2 :  System.out.println("20");
      break;
    case 3 :  System.out.println("30");
      break;
    case 4 :  System.out.println("40");
      break;
    case 5 :  System.out.println("50");
      break;
    case 6 :  System.out.println("기타");
    }
  }
}

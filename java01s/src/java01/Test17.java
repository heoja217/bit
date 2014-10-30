/* 조건문 
프로그램 아규먼트로 나이를 입력받아 청소년 청년 등의 여부를 출력하시오
 */
package java01;

public class Test17 {

  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      int age = Integer.parseInt(args[i]);
      if (age < 18) {
        System.out.println("청소년");
      } else if (age >= 18 && age < 40) {
        System.out.println("청년");
      } else if (age >= 40 && age < 50) {
        System.out.println("장년");
      } else if (age >= 50 && age < 65) {
        System.out.println("중년");
      } else {
        System.out.println("노인");
      }
    }
  }
}

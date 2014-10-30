/* 조건문 

Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();
 */
package java01;
 
public class Test18 {

  public static void main(String[] args) {
    
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    System.out.println("1. 10대");
    System.out.println("2. 20대");
    System.out.println("3. 30대");
    System.out.println("4. 40대");
    System.out.println("5. 50대");  
    System.out.println("6. 기타");
    System.out.println("당신의 나이는?");
    String input = scanner.nextLine();
    switch (Integer.parseInt(input)){
    case 1 :
      System.out.println("10");
      break;
    case 2 :
      System.out.println("20");
      break;
    case 3 :
      System.out.println("30");
      break;
    case 4 :
      System.out.println("40");
      break;
    case 5 :
      System.out.println("50");
      break;
    case 6 :
      System.out.println("기타");
    }
  }
}

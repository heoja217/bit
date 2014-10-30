/* 조건문 
 - if(조건) ~ else ~
 - if(조건) ~

 */
package java01;
 
public class Test16 {

  public static void main(String[] args) {
    int age = 20;
    if (age < 18) {
      System.out.println("청소년");
    } else if (age >=18 && age <40) {
      System.out.println("청년");
    } else if (age >=40 && age <50) {
      System.out.println("장년");
    } else if (age >=50 && age <65) {
      System.out.println("중년");
    } else {
      System.out.println("노인");
    }
  }
}

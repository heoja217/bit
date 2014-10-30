/* StringBuffer 클래스
 => mutable
  */
package java01.test50;

public class StringTest04 {

  public static void main(String[] args) {
  StringBuffer str1= new StringBuffer("Hello");
  System.out.println(str1);
  
  StringBuffer str2 = str1.replace(2,4,"xx");

  System.out.println(str1);
  System.out.println(str2);
  
  if (str1 == str2) System.out.println("str1 == str2");

  }

  
  public static void main01(String[] args) {
    String str1 = "Hello";
    String str2 = str1.replace('l','x');
    String str3 = str1.replace("ell","ohoho");
    String str4 = str1.replace('l','x');
    
    System.out.println(str1);
    System.out.println(str2);
    System.out.println(str3);
    System.out.println(str4);
    
    if (str2 == str4) System.out.println("str2 == str4");
  }
}


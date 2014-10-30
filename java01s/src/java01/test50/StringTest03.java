/* 
  replace() :원본데이터 변경 불가능
  => String은 immutable 객체이다.
  */
package java01.test50;

public class StringTest03 {

  public static void main01(String[] args) {
  String str1= new String("Hello");
  String str2 = str1.intern();
  String str3 = "Hello";
  
  if(str1 == str2) System.out.println("str1 == str2");
  if(str2 == str3) System.out.println("str2 == str3");
  }  
  
  
  

  
  public static void main(String[] args) {
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


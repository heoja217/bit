/* 상수 문자열
  -"문자열"로 표현
  - String Pool 영역에 생성된다
  - 중복생성되지 않는다
  
 Method Area영역에 클래스가 로딩되면 각 클래스별로 상수문자열의 String 인스턴스가 준비됨
 Method Area 영역에서 각 클래서별로 상수문자열을 준비하는 메모리 영역을 상수풀(constant Pool)이라고 부른다.
 
 즉, Method Area 안에 클래스가 로딩되고, 로딩된 클래스 안에 상수 문자열이 준비된다.
  *String Pool
  - 상수 문자열을
  */
package java01.test50;
class A {
  static String str1 = "Hello";
  static String str2 = "Hello";
}

class B {
  static String str1 = "Hello";
  static String str2 = "Hello";
}

public class StringTest02 {

  static String str1 = "Hello";
  static String str2 = "Hello";
  
  // 특정클래스 안에서만 사용할 클래스라면 그 클래스 내부에 선언하라!
  // => 중첩클래스(inner class) 라 부른다

  public static void main01(String[] args) {
    if (str1 == str2) System.out.println("str1 == str2");
    if (A.str1 == A.str2) System.out.println("A.str1 == A.str2");
    if (B.str1 == B.str2) System.out.println("B.str1 == B.str2");
    
    if (str1 == A.str2) System.out.println("str1 == A.str2");
    if (A.str1 == B.str2) System.out.println("A.str1 == B.str2");

    
  }
  public static void main(String[] args) {
    String str1 = "Hello";
    String str2 = "Hello";
    String str3 = new String("Hello");

    if (str1 == str2) System.out.println("str1 == str2");
    if (str2 == str3) System.out.println("str2 == str3");
    
    if (str1.equals(str3))
      System.out.println("str1.equals(str3)");
    
    System.out.println(str1);
    //System.out.printf("%d", str1);
  }
}


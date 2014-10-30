/*
char[]이 유니코드 문자열 저장 문자열 다루는 다양한 메서드 제공
*/
package java01.test50;

public class StringTest01 {

  public static void main(String[] args) {
    String str1 = new String("Hello");
    String str2 = str1;
    String str3 = new String("Hello");
    
    //인스턴스의 주소 비교
    if (str1 == str2) System.out.println("str1 == str2");
    if (str1 != str3) System.out.println("str1 != str3");
   
    //인스턴스의 값 비교
    if (str1.equals(str3)) System.out.println("str1.equals(str3))");
  }

}

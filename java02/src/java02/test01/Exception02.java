/* 자바에서의 예외처리
 - 예외상황 발생시 예외 정보를 특별한 객체에 담아 호출자에게 알림
 문법 => throws new Throwable("예외 내용");
 - 메서드 선언부에 어떤 예외를 던지는지 지정
 문법 => void 메서드명() throws Throwable { ... } 
 - 예외를 던질수있는 메서드는 호출하는쪽에서는 try ...catch를 사용하여 예외처리코드 준비
 - 효과 
   1) 
*/
package java02.test01;

public class Exception02 {
  public static float divide(float a, float b) throws Throwable {
    if (b == 0) 
      throw new Throwable("0으로 나눌 수 없음");
    return a / b;
  }
  public static void main(String[] args) {
    try {
      // 예외 발생시키는 코드
      float result = divide(10, 0);
      System.out.println("result:" + result);
    } catch (Throwable ex) {
      // 예외 발생시 수행할 코드
      System.out.println(ex.getMessage());
    }
  }

}

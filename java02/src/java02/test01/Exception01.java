/* 예외처리를 위한 문법이 없었을 때 
 - 메서드의 리턴값을 통해 호출자에게 예외상황을 알림.
 - 호출자는 늘 리턴값을 검사해야 했음
*/
package java02.test01;

public class Exception01 {
  public static float divide(float a, float b) {
    if (b == 0) { // 예외 상황 발생
      return -999999.0f; // 특별한 값 리턴
    }
    return a / b;
  }
  public static void main(String[] args) {
    float result = divide(10, 0);
    if (result != -999999.0f) {
      System.out.println("result:" +result);
    } else {
      System.out.println("Error!");
    }
  }

}

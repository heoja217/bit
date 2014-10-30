//계산기 역할을 수행

package java01.test29;

public class Calculator {
  // 클래스 멤버만 접근가능하도록 제한
  private static int result;
  // 단 결과를 알 수 있도록 메서드 제공
  static int getResult(){
    return result;
  } // 내부 변수의 값을 리턴하는 메서드에 get이라는 접두어 붙임 => ***getter 메서드
  static void plus(int value) {
    result += value;
  }
  static void minus(int value) {
    result -= value;
  }
  static void multiple(int value) {
    result *= value;
  }
  static void divide(int value) {
    result /= value;
  }
    
}

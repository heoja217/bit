//계산기 역할을 수행

package java01.study;

public class Calculator {
  private static int result;
  
  static int getResult(){
    return result;
  }
  
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

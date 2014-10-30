//계산기 역할을 수행

package java01.test30;

public class Calculator {
  private int result;
  // 인스턴스변수는 클래스 로딩시 준비되지 않으므로 려도의 명령을 내려야함.
  // new Method();
  
  // 인스턴스 변수 사용 
  static int getResult(Calculator that){
    return that.result;
  }
  
  static void plus(Calculator that, int value) {
    that.result += value;
  }
  static void minus(Calculator that, int value) {
    that.result -= value;
  }
  static void multiple(Calculator that, int value) {
    that.result *= value;
  }
  static void divide(Calculator that, int value) {
    that.result /= value;
  }
    
}

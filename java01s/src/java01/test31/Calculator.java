//계산기 역할을 수행

package java01.test31;

public class Calculator {
  private int result;
  
  // this 변수는 내부에 숨겨진 변수로 메서드를 호출할때 사용한 인스턴스의 주소를 보관. 
  int getResult(){
    return this.result;
    // or return result;->this 생략 가능. 컴파일러가 자동으로 있다고 가정하고 컴파일.
  }
  
  void plus(int value) {
    this.result += value;
  }
  void minus(int value) {
    this.result -= value;
  }
  void multiple(int value) {
    this.result *= value;
  }
  void divide(int value) {
    this.result /= value;
  }
    
}

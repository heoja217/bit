/* 상속 
- class 새로만들클래스 extends 기존클래스 { 
        추가할 인스턴스변수; 
        추가할 메서드(연산자)
  }
  상속을 해주는 클래스 super(parent) class
  상속을 받는 클래스 sub(child) class
*/
package java01.test40;

public class Truck extends Car{
  float weight = 1000; // 초기화 문장을 통해 변수의 값을 1000kg으로 설정
  boolean autoDump;
  public Truck() {
    super();//생략가능
    autoDump = true;  
    //super(); -> Error! 수퍼클래스의 생성자를 제일 먼저 호출해야함.
  }
}

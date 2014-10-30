/* 호출할 수퍼 클래스의 생성자 지정
 - super(호출활 생성자의 파라미터값);
*/
package java01.test41;

public class Truck extends Car{
  float weight = 1000; // 초기화 문장을 통해 변수의 값을 1000kg으로 설정
  boolean autoDump;
  public Truck() {
    super("미정", "미정", 800);
    autoDump = true;  
  }
}

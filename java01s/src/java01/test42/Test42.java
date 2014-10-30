/*
  상속
  1) Specialization
  - 수퍼클래스로부터 서브클래스 정의
  2) Generalization
  - 서브클래스들의 공통점을 추출하여 수퍼클래스로 정의
*/

package java01.test42;

public class Test42 {

  public static void main(String[] args) {
    Tico c1 = new Tico();
    Jeep c2 = new Jeep();
    Carbrio c3 = new Carbrio();
    
    ////////
    Car c4 = new Car();
    
  }

}



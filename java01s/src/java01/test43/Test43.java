/* 추상 클래스 : 그 자체로 사용하지 않음 -> 인스턴스를 생성할 수 없다.
abstract calss명

- 일반클래스(concrete class)
   ㄴpackage member class
   ㄴinner class (중첩/내부 클래스)
     ㄴ top level inner class
     ㄴ memver inner class
     ㄴ local inner class
     ㄴ anonymous inner class
- 추상클래스
 */

package java01.test43;

public class Test43 {

  public static void main(String[] args) {
    Tico c1 = new Tico();
    Jeep c2 = new Jeep();
    Carbrio c3 = new Carbrio();
    
    //Car c4 = new Car();//추상 클래스의 인스턴스 생성불가능
        
  }

}



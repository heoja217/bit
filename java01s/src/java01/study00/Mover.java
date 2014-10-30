/*상수
 - 숫자를 읽고 이해하기 쉽도록 글자로 정의
 - final int 상수변수명 = 값;
 
 final
 1) final class 클래스명 {} => 서브 클래스를 만들수 없음.
 2) final 리턴타입 메서드() {} => 서브 클래스에서 재정의 불가능 == overriding 불가  
 3) final 데이터타입 변수명; => 값을 단 한번만 할당 가능
 */
package java01.study00;
public class Mover extends Unit {
  public void move(){
    System.out.println("movemove");
  }

}

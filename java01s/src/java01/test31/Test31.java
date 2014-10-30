/* 인스턴스 메서드
 */
package java01.test31;

// 단 계산은 순차적으로 실행
// 다음 두 개의 연산을 동시에 실행
// 10 + 2 * 7 - 4 / 2 = ? 
// 20 * 3 + 76 - 5 = ?

// step 7 result 변수를 개별적으로 유지 => 인스턴스변수
public class Test31 {
  public static void main(String[] args) {
    // Cal- 클래스의 명령에 따라 준비된 메모리 : 인스턴스 
    //!!!인스턴스는 메서드와 독립적인관계이다. Heap영역에서는 method, 명령어가 호출될수없음..
    // 인스턴스 메모리의 주소 저장을 위한 변수 : 레퍼런스
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    
    c1.plus(10);
    c2.plus(20);

    c1.plus(2);
    c2.multiple(3);
    
    c1.multiple(7);
    c2.plus(76);

    c1.minus(4);
    c2.minus(5);
    
    c1.divide(2);
    
    System.out.println("첫번째 결과는 = " + c1.getResult()); 
    System.out.println("두번째 결과는 = " + c2.getResult()); 
    
  }
  
}


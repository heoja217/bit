/* 인스턴스 변수
 */
package java01.test30;

//Calculator의 기능을 이용하여 다음 계산 수행
// 단 계산은 순차적으로 실행
// 다음 두 개의 연산을 동시에 실행
// 10 + 2 * 7 - 4 / 2 = ? 
// 20 * 3 + 76 - 5 = ?

// step 7 result 변수를 개별적으로 유지 => 인스턴스변수
public class Test30 {
  public static void main(String[] args) {
    // Cal- 클래스의 명령에 따라 준비된 메모리 : 인스턴스 
    //!!!인스턴스는 메서드와 독립적인관계이다. Heap영역에서는 method, 명령어가 호출될수없음..
    // 인스턴스 메모리의 주소 저장을 위한 변수 : 레퍼런스
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    
    Calculator.plus(c1, 10);
    Calculator.plus(c2, 20);

    Calculator.plus(c1, 2);
    Calculator.multiple(c2, 3);
    
    Calculator.multiple(c1, 7);
    Calculator.plus(c2, 76);

    Calculator.minus(c1, 4);
    Calculator.minus(c2, 5);
    
    Calculator.divide(c1, 2);
    
    System.out.println("첫번째 결과는 = " + Calculator.getResult(c1)); 
    System.out.println("두번째 결과는 = " + Calculator.getResult(c2)); 
    
  }
  
}

//***객체지향 : 개별적으로 데이터를 관리하기 위함
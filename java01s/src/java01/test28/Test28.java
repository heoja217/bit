/* 클래스
 */
package java01.test28;

//Calculator의 기능을 이용하여 다음 계산 수행
// 단 계산은 순차적으로 실행
// 10 + 2 * 7 - 4 / 2 = ? 

// step 5 클래스 분리
//        -> Calculator 클래스 정의, 계산과 관련된 기능 분리
public class Test28 {
  public static void main(String[] args) {
    //Calculator.result = 0;
    Calculator.plus(10);
    Calculator.plus(2);
    Calculator.multiple(7);
    Calculator.result = -100; // !!!
    Calculator.minus(4);
    Calculator.divide(2);
    
    System.out.println("결과는 = " + Calculator.result); 
    
  }
  
}

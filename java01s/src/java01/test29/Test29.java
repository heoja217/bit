/* 캡슐화 encapsulation
 : [접근 제어자(access modifier)] 타입 변수명;
   [접근 제어자(access modifier)] 리턴타입 메서드명(){};
     ㄴprivate 
     ㄴprotected 
     ㄴ(default)
     ㄴpublic
 */
package java01.test29;

//Calculator의 기능을 이용하여 다음 계산 수행
// 단 계산은 순차적으로 실행
// 10 + 2 * 7 - 4 / 2 = ? 

// step 6 result 변수의 외부접근 차단 = > 캡슐화
public class Test29 {
  public static void main(String[] args) {
    Calculator.plus(10);
    Calculator.plus(2);
    Calculator.multiple(7);
    //Calculator.result = -100; -error
    Calculator.minus(4);
    Calculator.divide(2);
    
    System.out.println("결과는 = " + Calculator.getResult()); 
    
  }
  
}

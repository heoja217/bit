/* 예외상황 발생시 던질 수 있는 클랫 : Throwable
 - Error, Exception
 - 시스템 관련 예외는 Error =>개발자가 처리할수 없는 예외상황
 - 애플리케이션관련 예외는 Exception 계열의 객체에 담아서 던짐. 
      =>개발자가 처리 가능한 예외상황
*/
package java02.test01;

public class Exception03 {
  public static int compute(int a, int b, String op) throws Exception, ArithmeticException {
    if (op == null) 
      throw new Exception("연산자를 지정하세요");
    
    switch(op) {
    case "+" : return a + b; 
    case "-" : return a - b; 
    case "*" : return a * b; 
    case "/" : 
      if (b == 0) 
        throw new ArithmeticException("0으로 나눌 수 없음");
        return a / b; 
    default : throw new Exception("지원하지 않는 연산자입니다.");
    }
  }
  
  // 여려 종류의 예외 처리
  public static void main(String[] args) {
    // catch문 작성시 자식 예외부터 잡도록 처리하라. => 다형적 변수!
    try {
      int result = compute(10, 20, "+");
      System.out.println(result);
    } catch (ArithmeticException ex) {
      System.out.println("연산 오류!");
    } catch (Exception ex) {
      System.out.println("실행 오류!");
    }
  }

}

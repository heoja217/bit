/* Error계열 예외는 예외처리를 하지 않아도 컴파일 오류 발생하지 않음
 - throw new Error("오류 내용")
 - 메서드 선언부 : 예외 객체를 지정할 필요 없음
 - 호출자 : try ... catch 사용할 필요 없음
*/
package java02.test01;

public class Exception04 {
  public static int divide(int a, int b) {
      if (b == 0) 
        throw new Error("0으로 나눌 수 없음");
        return a / b; 
  }
  
  // 여려 종류의 예외 처리
  public static void main01(String[] args) {
    // Error 계열의 예외는 애플리케이션에서 상관하지 않음-> try... catch 사용 x
    // divide()에서 발생한 예외는 JVM에 전달
    int result = divide(10, 0);
      System.out.println(result);
  }
  
  // but! Error계열의 예외도 try catch로 잡을 수는 있음
  public static void main(String[] args) {
    try {
      int result = divide(10, 0);  
      System.out.println(result);
      
    } catch (Error ex) {
      System.out.println("0이래요");
    }
  }
}

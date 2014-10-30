/* static 블록

 */

package java01.test45;

public class ClassA {
  static int value = 100;
  
  static {
    System.out.println("run ClassA static block");
    value = 200;
  }
  
  static {
    System.out.println("스태틱 블록이 여러 개일 경우 순차적으로 실행");
  }
}

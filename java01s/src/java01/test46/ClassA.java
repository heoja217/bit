/* instance 블록

 */

package java01.test46;

public class ClassA {
  int i = 1;
  int j = 2;
  
  {
    System.out.println("인스턴스 블록 1");
    i = 100;
    j = 200;
  }
  
  public ClassA(){
    System.out.println("생성자 호출");
    i = 10;
    j = 20;
  }
 
  {
    System.out.println("인스턴스 블록 2");
    i = 1000;
    j = 2000;
  }
}

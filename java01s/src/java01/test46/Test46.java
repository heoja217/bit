/*클래스 로딩 
  new 연산자를 사용하여 인스터스를 만들때
  Class.forName("클래스이름")
*/

package java01.test46;

public class Test46 {

  public static void main(String[] args) {
  /*  ClassA obj1;
    
    obj1= new ClassA();
    
    System.out.println(obj1.i);
  */
    ClassB obj2 = new ClassB();
    System.out.println(obj2.x);
    System.out.println(obj2.i);
    System.out.println(obj2.j);
    
  }

}

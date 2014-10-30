/*클래스 로딩 
  new 연산자를 사용하여 인스터스를 만들때
  Class.forName("클래스이름")
*/

package java01.test45;

public class Test45 {

  public static void main(String[] args) {
    // 참조변수를 선언할때는 클래스가 로딩되지 않음
    ClassA obj1;
    
    //인스턴스 생성시 클래스로딩
    obj1= new ClassA();
    
    System.out.println(ClassA.value);
  }

}

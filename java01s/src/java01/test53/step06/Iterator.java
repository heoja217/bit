/* Iterator를 클래스에서 자격을 의미하는 인터페이스로 변경
  인터페이스 : 자격, 규칙을 정의함
  
  메서드 : 반드시 abstract public 이어야한다
  //규칙은 반드시 공개되어야하므로 public 
  변수 : 반드시 public static final 이어야 한다
*/
package java01.test53.step06;

// 자격을 갖추기위해 가져야할 메서드 선언.
public interface Iterator {
  // list 인스턴스 변수를 자식클래스도 접근가능하도록 변경
  //private int i;
  /* public static final *///int i = 10;
  /* abstract public */void setList(String[] list);
  /* abstract public */boolean hasNext();
  /* abstract public */String next();
}

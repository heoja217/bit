/* 인스턴스 출력하기
 * ObjectOutputStream
 Serialize(Marshaling) => 바이트 배열로 만드는 것.
 Deserialisze(Unmarshaling) => 바이트 배열로 인스턴스를 만드는 것
 */
package java02.test02;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//@SuppressWarnings("serial")
// Serialize 허용
// java.io.Serializable 인터페이스 구현
class Score implements Serializable {
  // 인스턴스의 값을 출력할때 클래스 버전 번호도 출력됨
  // 읽어들이는 쪽에서 자신이 갖고 있는 클래스와 같은 버전인지 검사할때 사용
  // 클래스 상속시에도 반드시 
  private static final long serialVersionUID = 1L;
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float average;
  
  public Score() {}
  
  public Score(String n, int k, int e, int m) {
    name = n; kor = k; eng = e; math = m;
    sum = k + e + m;
    average = sum / 3.0f;
  }
}

public class Test14 {
  
  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test14.dat");
    ObjectOutputStream out2 = new ObjectOutputStream(out);
    
    Score obj = new Score("홍길동", 100, 90, 80);
    
    // 인스턴스의 값을 바이트 배열로 만들어서 출력
    // 단 해당 클래스가 허락해야함
    out2.writeObject(obj);
    
    // 닫을 때 꺼꾸로 닫는다.
    out2.close(); 
    out.close();
  }
  
 

}
























/* Data processing stream class
  - 중간에서 데이터를 가공하는 역할
  - 스스로 출력할수 없으며 반드시 Data Sink Stream 클래스를 통하여 출력
  - DataOutputStream
   => 문자열이나 기본타입의 데이터를 출력할 대, 내부에서 바이트 배열로 만들어 
다른 출력 스트림으로 넘김.
*/
package java02.test02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test11 {
  
  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test11_2.dat");
    DataOutputStream out2 = new DataOutputStream(out);
    int kor = 100;
    int math = 90;
    int money = 145630;
    
    out2.writeInt(kor);
    out2.writeInt(math);
    out2.writeInt(money);
    
    // 닫을떄는 반대로
    out2.close();
    out.close();
  }
  
  public static void main01(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test11.dat");
    int kor = 100;
    int math = 90;
    int money = 145630;
    
    out.write(kor >> 24);
    out.write(kor >> 16);
    out.write(kor >> 8);
    out.write(kor);
    
    out.write(math >> 24);
    out.write(math >> 16);
    out.write(math >> 8);
    out.write(math);
    
    out.write(money >> 24);
    out.write(money >> 16);
    out.write(money >> 8);
    out.write(money);
    out.close();
    
    
    
  }
  /*
  41 42 43 00 01 04
  */
  
}

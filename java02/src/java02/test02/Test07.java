/* 바이너리 데이터의 읽기
- FileInputStream
- read();
*/
package java02.test02;

import java.io.FileInputStream;

public class Test07 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test01.txt");
    int b = -1;
    while((b = in.read()) != -1) {
      System.out.println(Integer.toHexString(b));
    }
    in.close();
  }
}

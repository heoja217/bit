/* 문자 데이터의 읽기
- FileReader
- read(); 한 문자단위로 => 리턴값은 유니코드
- 텍스트파일을 읽을때...
*/
package java02.test02;

import java.io.FileReader;

public class Test08 {

  public static void main(String[] args) throws Exception {
    FileReader in = new FileReader("test01.txt");
    int b = -1;
    while((b = in.read()) != -1) {
      System.out.println(Integer.toHexString(b));
    }
    in.close();
  }
  /*
  문자 스트림은 읽어들인 데이터를 유니코드로 변환
  한글 출력결과 
  ac00
  b098
  b2e4
  */
}

/*  바이너리 데이터 읽기*/
/* java.io 패키지
         |     binary(byte)     |     character(unicode)
================================================================
Data 읽기 | InputStream          |  Reader
  file   |  └ FilleInputStream  |   └ FileReader
  array  |  └ ByteArray I.S     |   └ CharArrayReader
  process|  └ Piped I.S         |   └ PipedReader
----------------------------------------------------------------
Data 쓰기 |  OutputStream        |  Writer
  file   |  └ FileOutputStream  |   └ FileWriter
  array  |  └ ByteArray O.S     |   └ CharArrayReader
  process|  └ Piped O.S         |   └ PipedReader
----------------------------------------------------------------
*/
package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01 {

  public static void main(String[] args) {
    FileInputStream in = null;
    try {
      //1. 입력스트림 객체를 준비한다.
    // 현재 파일의 위치는 프로젝트 디렉토리이다
      in = new FileInputStream("img1.jpg");
      int count = 0;
      int b = -1;
      //2. read()를 통해 1바이트 읽기
    // 리턴타입이 int라고 해서 4바이트를 읽는것은 아니다.
      while ((b = in.read()) != -1) {
        count++;
      }
       System.out.println("파일 크기는" + count +  "바이트입니다.");
      
      //3. File이나 Database, Socket등의 자원은 사용한 다음 명시적으로 
      //해제해야 한다. 그러나 read중에 오류가 발생하면 close() 호출이
      //불가능하므로 자원을 해제하는 명령은 finally블록에 두도록 한다.
      // in.close();
    } catch (FileNotFoundException ex) {
      System.out.println("img1.jpg파일을 찾을 수 없습니다.");
    } catch (IOException ex) {
      System.out.println("읽기 오류!");    
    } finally {
      try { in.close(); } catch (IOException ex) {}
    }
  }

}

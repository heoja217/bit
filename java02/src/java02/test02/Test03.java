/* Quiz
  - 예외처리 강화
  1) 파일이 존재하지 않으면, 다음문장 출력
    xxxx.xxx 파일이 존재하지 않습니다.
  2) 디렉토리라면 
    xxxx.xxx는 파일이 아니라 디렉토리입니다.
    
  파일을 쓸 때,
  1) 파일이 이미 존재한다면,
    xxxx.xxx 파일이 이미 존재합니다. 덮어쓰시겠습니까?(y/n) y
    xxxx.xxx 파일을 출력하였습니다.
  2) 파일이 존재하지 않는다면
    xxxx.xxx 파일을 출력하였습니다.
 */
package java02.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test03 {

  public static void outWrite(String newFileName, FileInputStream in, int index)
       throws IOException{
    FileOutputStream out = new FileOutputStream(newFileName);
    int b = -1;
    while ((b = in.read()) != -1) {
      out.write(b);
    }
    System.out.println(newFileName.substring(index + 1) + "파일을 출력하였습니다.");
    out.close();
  }

  public static void main(String[] args) throws Exception {
    FileInputStream in = null;
    File file = new File(args[0]);
    int index = args[0].lastIndexOf('.');
    String newFileName = args[0].substring(0, index) + "-01"
        + args[0].substring(index);
    index = args[0].lastIndexOf('/');

    String fileName = args[0].substring(index + 1);
    
    if (file.isDirectory()) {
      System.out.println(fileName + "는 파일이 아니라 디렉토리입니다.");
    } else if (!file.isFile()) {
      System.out.println(fileName + "파일이 존재하지 않습니다");
    } else {
    try {
      in = new FileInputStream(args[0]);
      file = new File(newFileName);
      
      if (file.isFile()) {
        System.out.println(newFileName.substring(index + 1)
            + "파일이 이미 존재합니다. 덮어쓰시겠습니까?(y/n)");

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        
        if (a.equals("n") || a.equals("N")) {
          System.out.println("작업을 취소하였습니다.");
        } else if (a.equals("y") || a.equals("Y")) {
          outWrite(newFileName, in, index);
        } else {
          System.out.println("잘못 입력하셨습니다");;
        } 
      } else {
      outWrite(newFileName, in, index);
      }
    }
    catch (IOException ex) {
      System.out.println("읽기 오류!");
    } finally {
      try {
        if (in != null) {
          in.close();
        }
      } catch (IOException ex) {
      }
    }

  }

  }
  }

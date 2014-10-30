/* Quiz
 - Test04 읽어들일파일명 출력할디렉토리명
 - 출력할 파일명이 다음과 같을 경우,
   예) Test04 img1.jpg aaa
 - aaa 폴더를 먼저 생성하고,
   그 폴더 아래에 읽어들인 파일(img1.jpg)를 출력한다.
 */
package java02.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Study {


  public static void main(String[] args)  {
    FileInputStream in = null;
    FileOutputStream out = null;
    try{
      in = new FileInputStream(args[0]);  
      int index = args[0].lastIndexOf('/');
      String dirName = args[1];
      String newDirName = args[0].substring(0, index+1)
          + dirName;
      
      File newDir = new File(newDirName);
      newDir.mkdir();
      
      out = new FileOutputStream(newDirName + args[0].substring(index));
      
      int b = 1;
      
      while ((b = in.read()) != -1 ) {
        out.write(b);
      } 
      System.out.println(args[1] + args[0].substring(index) + "이 출력되었습니다");
    } catch (FileNotFoundException ex) {
      System.out.println(args[0] + " 파일을 찾을 수 없습니다.");
    } catch (IOException ex) {   
      System.out.println("읽기 오류!");
          
    } finally {
      try {if(in != null) {in.close();out.close();}}   
      catch (IOException ex) {}
    }
  }

}







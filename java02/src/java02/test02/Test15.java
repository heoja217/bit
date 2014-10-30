/* 인스턴스 출력하기
 * ObjectInputStream
 */
package java02.test02;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Test15 {
  
  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test14.dat");
    ObjectInputStream in2 = new ObjectInputStream(in);
    
    Score obj = new Score();
    
    obj = (Score)in2.readObject();

    System.out.println(obj.name);
    System.out.println(obj.kor);
    System.out.println(obj.eng);
    System.out.println(obj.math);
    System.out.println(obj.sum);
    System.out.println(obj.average);
    
    in2.close(); 
    in.close();
  }

}
























/* Buffer의 사용
  1 byte씩 데이터를 읽는것보다 여러 바이트를 한꺼번에 읽는 것이 속도가 더 빠름.
  ∵ 데이터 읽기속도 = Data Seek Time + Data Transfer Time
  ex) 퀀텀 하드 
  Data Seek Time 4.2ms -> 0.0042초
  Data Transfer time 3Gb/sec -> 0.000003초/1byte 
 */
package java02.test02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Test16_02 {
  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("/home/bit/test.pdf");
    BufferedInputStream in2 = new BufferedInputStream(in);

    int b = 0;
    long start = System.currentTimeMillis();
    
    while((b = in2.read()) != -1) {}
    long end = System.currentTimeMillis();
    
    System.out.println(end - start);
    
    in2.close();
    in.close();
    
  }

}
























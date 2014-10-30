/* 정수변수
byte(1) -128 127
short(2) -32768 32767
int(4) 약 -21억 21억
long(8) 약 -922경 922경
*/
package java01;

public class Test08 {

  public static void main(String[] args) {
    byte minByte = -128;
    byte maxByte = 127;
    
    short minShort = -32768;
    short maxShart = 32767;
    
    int minInt = -2147483648;
    int maxInt = 2147483647;
    
    long minLong = Long.MIN_VALUE;
    long maxLong = Long.MAX_VALUE;
    
    //minByte = -129;
    //maxByte = 128;
    
    //literal 정수리터럴 4바이트 정수값, 8바이트 정수값
    
    byte b = 127;
    
    //byte b3 = 30L;
    //short s2 = 30L;
    //int i = 30L;
    long l = 30L;
    

  }

}

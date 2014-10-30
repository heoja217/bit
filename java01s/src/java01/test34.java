/* 형변환 */
package java01;

public class test34 {
  public static void main(String[] args){
    int i = 10;
    byte b = 10;
    
    //byte b2 = i; //error!
    
    //r-value 를 l-value에 넣는 방법
    // l-value= (데이터형)r-value 
    byte b3 = (byte)i;
    //but!
    int i2 = 128;
    byte b4 = (byte) i2;
    System.out.println(b4);

  }
}

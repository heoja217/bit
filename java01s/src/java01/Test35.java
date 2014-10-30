/* 암시적 형변환 */
package java01;

public class Test35 {

  public static void main(String[] args) {
    byte b = 10;
    byte b2 = 10;
    short s = 10;
    char c = 10;
    int i = 10;
    long l = 10L;
    float f = 10.0f;
    double d = 10.0; 
    
    //byte sum1 = b + s + c + i + l + f + d; r-value :double
    //byte sum2 = b + s + c + i + f + l; // r-value : float 
    //byte sum3 = b + b2; // 연산의 기본은 int
    
    int x = 5;
    int y = 2;
    // System.out.println(x / y); //결과는 2
    // System.out.println((float)x / (float)y);
    System.out.println((float)x / y);
    
  
   
    
  }

}

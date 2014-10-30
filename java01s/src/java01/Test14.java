// garbage, garbage collector
package java01;

public class Test14 {

  public static void main(String[] args) {
  int[] p = new int[5]; // 예) 배열의 주소가 100번지라고 하자!
  int[] p2 = new int[3]; // 예) 200번지
  int[] p3 = p; // 100번지
  
  p3[2] = 100;
  System.out.println(p[2]);
  
  p2 = p; 
    
  }
}
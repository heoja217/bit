package java02.test02;

public class Test06_Ep01 {
  // 1~50 출력
  //함수 호출 이용
  public static void main(String[] args) {
    displayNo(1);
  }
  public static void displayNo(int no) {
    System.out.println(no);
    if (no == 50) 
      return;
    else 
      displayNo(no + 1);
  }
  
  //반복문 사용
  public static void main01(String[] args) {
    for (int i = 1; i <= 50; i++) {
      System.out.println(i);
    }
  }
}

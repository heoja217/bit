package java02.test02;

public class Test06_Ep02 {
  // 1~50까지 합 구하기
  //함수 호출 이용
  public static void main(String[] args) {
    System.out.println(f(50));
  }
  public static int f(int no) {
    if (no == 1) {
      return no;
    } else
    return no + f(no - 1);
  }
}

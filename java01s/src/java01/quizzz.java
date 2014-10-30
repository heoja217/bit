package java01;

public class quizzz {
  static int a = 10;
  static int b = 5;

  static int test() {
    int c = 20;
    return c;
  }

  public static void main(String[] args) {
    int d = test();
    plus(a, d);
    System.out.printf("%d, %d, %d ",a,b,d);
  }

  static void plus(int e, int x) {
    b =  e + x;
  }
}

/* 반복문 
while (조건)  명령문;
while (조건) {...};
do 명령문; while (조건);
do {...} while (조건)
for (초기화명령문;조건;증가문){...}
for (변수
 */
package java01;

public class Test24 {
  public static void main(String[] args) {
    int x = 0;
    do {
      x += 5;
      System.out.print(x + " ");
      if (x % 25 == 0) {
        System.out.println("\n---------------");
        if (x % 50 == 0) {
        }
        System.out.print("^");
      }
    } while (x < 100);

    System.out.println();

    for (int i = 5; i <= 100; i += 5) {
      System.out.print(i + " ");
      if (i % 25 == 0) {
        System.out.println("\n---------------");
        if (i % 50 == 0) {
          System.out.print("^");
        }
      }
    }
  }
}

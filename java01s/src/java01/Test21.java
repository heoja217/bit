/* 반복문 
while (조건)  명령문;
while (조건) {...};
do 명령문; while (조건);
do {...} while (조건)
for (초기화명령문;조건;증가문){...}
for (변수
 */
package java01;
 
public class Test21 {

  public static void main(String[] args) {
    long startMilliSec = System.currentTimeMillis();
    int i = 1;
    do {
      if (i%4 == 0){
        System.out.print(i+",");
        if ( i%20 == 0){
          System.out.print("\n");
          if ( i% 60 == 0 ){
            System.out.print("@");
          }
        }
      } 
      i++;
    } while (i <= 100000);

    long endMilliSec = System.currentTimeMillis();
    System.out.println(endMilliSec-startMilliSec);
  }
}

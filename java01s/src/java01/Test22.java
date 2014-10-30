/* 반복문 
while (조건)  명령문;
while (조건) {...};
do 명령문; while (조건);
do {...} while (조건)
for (초기화명령문;조건;증가문){...}
for (변수
 */
package java01;
 
public class Test22 {

  public static void main(String[] args) {
    int i = 1;
    while (i < 20){
      if (i%3 != 0) {
        System.out.println(i);  
      } 
      i++;
/*      while (i%3 != 0) {
        System.out.println(i);  
        i++;
      } 
      i++; */
    }
  }
}

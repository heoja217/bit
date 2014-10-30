/* import
ex) java.util.ArrayList
ex2) import java.util.Array;
ex3) import java.util.*;
 */


package java01;

import java.util.ArrayList;//컴파일 후 제거됨.

public class Test26 {

  public static void main(String[] args) {
    int[] arr = new int[] { 100, 90, 80 };
    for (int value : arr) {
      System.out.println(value);
    }
    System.out.println("-------------------");

    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(100);
    list.add(90);
    list.add(80);

    for (Object value : list) {
      System.out.println(value);
    }
  }
}


package java01;

import java.util.ArrayList;

public class Test25 {

  public static void main(String[] args) {
    int[] arr = new int[] { 100, 90, 80 };
    for (int value : arr) {
      System.out.println(value);
    }
    System.out.println("-------------------");

    java.util.ArrayList list = new java.util.ArrayList();
    list.add("홍길동");
    list.add(100);
    list.add(90);
    list.add(80);

    for (Object value : list) {
      System.out.println(value);
    }
  }
}

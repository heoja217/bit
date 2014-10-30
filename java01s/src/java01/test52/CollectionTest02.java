/*
 Collection API
 */
package java01.test52;

import java.util.ArrayList;

/* Generic 사용*/

public class CollectionTest02 {

  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("Hello");
    list.add("Hello");
    list.add(new String("Hello"));
    list.add(10);// == new Integer(10) <= auto boxing

    ArrayList<String> list2 = new ArrayList<String>();
    list2.add("Hello");
    list2.add(new String("Hello"));
    // list2.add(new Integer(10));

    // local inner class
    class Score {
      String name;
      int kor;
      int eng;
      int math;

      public Score(String n, int k, int e, int m) {
        name = n;
        kor = k;
        eng = e;
        math = m;
      }
    }

    ArrayList list3 = new ArrayList();
    list3.add(new Score("홍길동", 100, 100, 100));
    list3.add(new Score("임꺽정", 90, 90, 90));

    // ?? 목록에서 Score 객체를 꺼내 이름을 출력
    Score score = null;
    for (int i = 0; i < list3.size(); i++) {
      score = (Score) list3.get(i);
      System.out.println(score.name);
    }

    System.out.println("--------------");
    list3.get(1);
    System.out.println(score.name);
    System.out.println("--------------");

    ArrayList<Score> list4 = new ArrayList<Score>();
    list4.add(new Score("홍길동", 100, 100, 100));
    list4.add(new Score("임꺽정", 90, 90, 90));
    //list4.add("nono");//error

    for (int i = 0; i < list4.size(); i++) {
      score = list4.get(i);
      System.out.println(score.name);
    }
  }
}

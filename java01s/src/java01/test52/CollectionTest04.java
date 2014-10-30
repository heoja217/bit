/*
 HashMap 사용하기 
 */
package java01.test52;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionTest04 {
  
  // member inner class
  /* top level inner class
  // 스태틱 블록에서는 오로지 클래스 변수 및 클래스 메서드만 사용가능...
  class A {
    int value;
    void print() {
      System.out.println(value);
    }
    static void test() {
      print();
    }
  }*/
  static class Score {
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
  public static void main(String[] args) {
    
    HashMap<String,Score> map = new HashMap<String,Score>();

    map.put("1111", new Score("홍길동", 100, 100, 100));
    map.put("1111", new Score("임꺽정", 90, 90, 90)); // key는 중복 불가능->기존데이터를 덮어씀
    map.put("2222", new Score("유관순", 100, 90, 100));
    
    System.out.println(map.get("1111").name);
    System.out.println(map.get("2222").name);
    
    System.out.println();
    
    
    Set<Entry<String,Score>> kvSet = map.entrySet();
    for (Entry<String,Score> entry : kvSet) {
      System.out.println(entry.getKey()+ ":" + entry.getValue().name);
    }
    
    
    System.out.println("==================================");
    Set<String> keySet = map.keySet();
    for (String key : keySet) {
      System.out.println(key +":" +map.get(key).name);
    }
    
    
    System.out.println("==================================");
    Collection<Score> valueList = map.values();
    for (Score value : valueList) {
      System.out.println(value.name);
    }
  }  
}




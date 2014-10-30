/* 맵에 데이터를 저장할때 문자열이 아닌 특별한 객체를 사용
 */
package java01.test49;

import java.util.HashMap;

public class Test49 {
//Map에 데이터 저장시 특수 키를 사용
  public static void main(String[] args) {
    HashMap 냉장고2 = new HashMap();
    
    Integer key3 = new Integer(10);
    Integer key4 = new Integer(10);
    냉장고2.put(key3, "보약2");
    System.out.println(냉장고2.get(key4));
    
    String key5 = new String("열쇠");
    String key6 = new String("열쇠");
    냉장고2.put(key5, "보약3");
    System.out.println(냉장고2.get(key6));
    
    MyKey key1 = new MyKey("1234abcd", 100, 1255);
    MyKey key2 = new MyKey("1234abcd", 100, 1255);
    냉장고2.put(key1, "보약");
    System.out.println(냉장고2.get(key2));
    
    System.out.println("---------------");
    System.out.println("key1 == key2?? " + (key1 == key2));
    System.out.println("key3 == key4?? " + (key3 == key4));
    System.out.println("key5 == key6?? " + (key5 == key6));
    
    System.out.println("---------------");
    System.out.println(key1.hashCode());
    System.out.println(key2.hashCode());
    System.out.println(key3.hashCode());
    System.out.println(key4.hashCode());
    System.out.println(key5.hashCode());
    System.out.println(key6.hashCode());
    
    /* Why???
    - Object에서 상속받은 원래 매서드는 인스턴스가 다르면 해시값도 다르도록 프로그램되어있음.
    - but, String클래스와 랩퍼클래스(Byte, Integer,...)는 상속받은 hashCode()를 재정의
    */
    
    
    //equals() 리턴값
    System.out.println("---------------");
    System.out.println("key1.equals(key2)?" + key1.equals(key2));
    System.out.println("key3.equals(key4)?" + key3.equals(key4));
    System.out.println("key5.equals(key6)?" + key5.equals(key6));
    
  }

//Map에 데이터 저장시 문자열을 키로 사용
  public static void main01(String[] args) {
    HashMap studentMap = new HashMap();
    
    studentMap.put("s001",new Student("홍길동",10));
    studentMap.put("s002",new Student("임꺽정",9));
    
    System.out.println(studentMap);
    System.out.println(studentMap.get("s001"));
    System.out.println(studentMap.get("s002"));
  }

}
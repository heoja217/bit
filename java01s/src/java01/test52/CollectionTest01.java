/*
 Collection API
 */
package java01.test52; 

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTest01 {

  public static void main(String[] args) {   
    ArrayList list = new ArrayList();
    list.add("Hello");
    list.add("Hello");
    list.add(new String("Hello"));
    list.add(10);//== new Integer(10) <= auto boxing 
    
    /*for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    */
    
    // for (값을 담을 변수 : 배열 또는 Collection객체)
/*    for (Object value : list) {
      System.out.println(value);
    }
    */
    
    // Iterater 사용
    
    Iterator iterator = list.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    
  }
}

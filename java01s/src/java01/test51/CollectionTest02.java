/* Collection 다루기 1 - 배열 사용하여 여러 객체의 주소 보관
 */
package java01.test51;

import java.util.Date;

class MyArray {
  Object[] list = new Object[3];
  int index;
  
  public int add(Object instance) {
    if (index < list.length) {
      list[index++] = instance;
      return 0;
    } else {
      return -1;
    }
  }
  public int size(){
    return index;
  }
  public Object get(int index){
    return list[index];
  }
 

}

public class CollectionTest02 {

  public static void main(String[] args) {
    MyArray arr = new MyArray();
    System.out.println(arr.add("홍길동"));
    System.out.println(arr.add("임"));
    System.out.println(arr.add("장"));
    System.out.println(arr.add("유"));
  
    int size = arr.size();
    
    for(int i = 0; i < size; i++) {
      System.out.println(arr.get(i));
    }
  }

}

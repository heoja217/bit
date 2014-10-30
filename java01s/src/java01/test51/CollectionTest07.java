/* Iterator
 */
package java01.test51;

class MyLinkedList4 {
  class Iterator {
    /*
     * MyLinkedList4 linkedList;
     * 
     * public Iterator(MyLinkedList4 linkedList) { this.linkedList = linkedList;
     * }
     */

    Bucket cursor = start;

    public boolean hasNext() {
      if (cursor != end)
        return true;
      else
        return false;
    }

    public Object next() {
      Object value = cursor.value;
      cursor = cursor.next;
      return value;
    }
  }

  class Bucket {
    Object value;
    Bucket next;
  }

  Bucket start;
  Bucket end;
  int size;

  public MyLinkedList4() {
    start = new Bucket();
    end = start;
  }

  public Iterator iterator() {
    return new Iterator();
  }

  public int add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
    return ++size;
  }

  public int size() {
    return size;
  }

  private Bucket getBucketByIndex(int index) {
    Bucket cursor = start;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    } // for
    return cursor;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.size)
      return null;

    // Bucket cursor = getBucketByIndex(index);
    // return cursor.value;

    return getBucketByIndex(index).value;
  }

  public int insert(int index, Object value) {
    if (index < 0 || index >= this.size)
      return -1;

    Bucket temp = new Bucket();
    temp.value = value;

    if (index == 0) {
      temp.next = start;
      start = temp;

    } else {
      Bucket cursor = getBucketByIndex(index - 1);
      temp.next = cursor.next;
      cursor.next = temp;
    }
    size++;
    return 0;
  }

  public int remove(int index) {
    if (index < 0 || index >= this.size) {
      return -1;
    } // if

    if (index == 0) {
      start = start.next;
      

    } else {
      Bucket cursor = getBucketByIndex(index - 1);
      cursor.next = cursor.next.next;
    } // if
    size--;
    return 0;
  }


public static void testGet(MyLinkedList4 arr) {
  
}

public static void test Iterator(MyLinkedList4 arr){
  
}
public class CollectionTest07 {
  public static void printArray(MyLinkedList4 list) {
    MyLinkedList4.Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());

    }// for
  }

  // Iterator 적용 테스트
  public static void main(String[] args) {
    MyLinkedList4 arr = new MyLinkedList4();
    for (int i = 0; i < 10000; i++) {
      arr.add("==>" + i);
    }

    System.out.println("------------------");
    int size = arr.size();
    long start = System.currentTimeMillis();

    for (int i = 0; i < size; i++) {
      System.out.println(".");
    }
    long end = System.currentTimeMillis();
    System.out.println("\n소요시간" + (end - start));

    System.out.println("------------------");

    start = System.currentTimeMillis();
    MyLinkedList4.Iterator iterator = arr.iterator();
    while (iterator.hasNext()) {
      value = iterator.next();
      System.out.println(".");
    }

    end = System.currentTimeMillis();
    System.out.println("\n소요시간" + (end - start));

  }

  // Iterator 적용 테스트
  public static void main01(String[] args) {
    MyLinkedList4 arr = new MyLinkedList4();
    for (int i = 0; i < 10000; i++) {
      arr.add("==>" + i);
    }
    arr.add("00000");
    arr.add("11111");
    arr.add("22222");
    arr.add("33333");
    arr.add("44444");
    arr.add("55555");
    arr.add("66666");
    arr.add("77777");

    System.out.println("-----------------");
    printArray(arr);

  }
}

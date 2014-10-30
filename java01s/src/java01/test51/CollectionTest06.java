package java01.test51;

class MyLinkedList3 {
  class Bucket {
    Object value;
    Bucket next;
  }

  Bucket start;
  Bucket end;
  int size;

  public MyLinkedList3() {
    start = new Bucket();
    end = start;
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
  
  private Bucket getBucketByIndex(int index){
    Bucket cursor = start;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return getBucketByIndex(index).value;
  }

  public int insert(int index, Object value) {
    if (index < 0 || index >= this.size) {
      System.out.println("error");
      return -1;
    }
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
      System.out.println("error");
      return -1;
    }
    if (index == 0) {
      start = start.next;
    } else {
      Bucket cursor = getBucketByIndex(index);
      cursor.next = cursor.next.next;
    }
    size--;
    return 0;
  }
}

public class CollectionTest06 {
  public static void printArray(MyLinkedList3 list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }// for
  }

  public static void main(String[] args) {
    MyLinkedList3 arr = new MyLinkedList3();
    System.out.println("현재 크기:" + arr.add("00000"));
    System.out.println("현재 크기:" + arr.add("11111"));
    System.out.println("현재 크기:" + arr.add("22222"));
    System.out.println("현재 크기:" + arr.add("33333"));
    System.out.println("현재 크기:" + arr.add("44444"));
    System.out.println("현재 크기:" + arr.add("55555"));

    System.out.println("---------------------------");
    printArray(arr);

    System.out.println("-10---------------------------");
    arr.insert(-10, "10에 입력");
    System.out.println("30---------------------------");
    arr.insert(30, "30에 입력");
    System.out.println("0---------------------------");
    arr.insert(0, "!!!!!!");
    System.out.println("7---------------------------");
    arr.insert(7, "@@@@@@");
    System.out.println("4---------------------------");
    arr.insert(4, "######");

    System.out.println();
    System.out.println("=============================");
    printArray(arr);
    System.out.println();

    System.out.println("-30------------------------");
    arr.remove(-30);

    System.out.println("30------------------------");
    arr.remove(30);

    System.out.println("0------------------------");
    arr.remove(0);

    System.out.println("3------------------------");
    arr.remove(3);

    System.out.println("6------------------------"); 
    arr.remove(5);

    System.out.println();
    System.out.println("=============================");
    printArray(arr);
    System.out.println();
  }

}

package java01.test51;

class MyArray3 {
  Object[] list = new Object[10];
  int cursor;

  public int add(Object instance) {
    if (cursor < list.length) {
      list[cursor++] = instance;
      return 0;
    } else {
      return -1;
    }
  }

  public int size() {
    return cursor;
  }

  public Object get(int pos) {
    return list[pos];
  }

  public int remove(int pos) {
    if (pos >= 0 && pos < this.cursor) {
      for (int i = pos; i < this.cursor; i++) {
        if (i == (this.cursor - 1)) {
          list[i] = null;
          this.cursor--;
        } else {
          list[i] = list[i + 1];
        } // if
      } // for
      return 0;
    } else {
      return -1;
    } // if
  }

  public int insert(int pos, String value) {
    if (list.length == this.cursor) {
      return -1;
    }
    if (pos >= 0 && pos <= this.cursor) {
      for (int i = this.cursor++; i > pos; i--){
        list[i] = list[i - 1];
      }
      list[pos] = value;
      return 0;
    } else {
      System.out.println("인덱스로는 0부터 "
            + this.cursor + "의 값을 입력하시오.");
      return -1;
    }
  }
  /*

  public int insert(int pos, String value) {
    if (list.length == this.cursor) {
      System.out.println("배열이 꽉 찼습니다");
      return -1;
    }
    if (pos >= 0 && pos <= this.cursor) {
      for (int i = this.cursor++; i > pos; i--) {
        list[i] = list[i - 1];
      }
      list[pos] = value;
      return 0;
    } else {
      System.out.println("인덱스로는" + 0 + "부터 " + this.cursor + "사이의 값을 입력해주세요");
      return -1;
    } // if
  }*/

}

public class CollectionTest03 {

  public static void main(String[] args) {
    MyArray3 arr = new MyArray3();
    System.out.println(arr.add("00000"));
    System.out.println(arr.add("11111"));
    System.out.println(arr.add("22222"));
    System.out.println(arr.add("33333"));
    System.out.println(arr.add("44444"));
    System.out.println(arr.add("55555"));

    System.out.println("-----------------");
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }// for

    /*
     * arr.remove(3);
     * 
     * System.out.println("-----------------"); for (int i = 0; i < arr.size();
     * i++) { System.out.println(arr.get(i)); }// for
     */
    System.out.println(arr.size());
    System.out.println("6 -----------------");
    arr.insert(6, "666666");

    System.out.println("-30-----------------");
    arr.insert(-30, "xxxxx");
    System.out.println("9-----------------");
    arr.insert(9, "xxxxx");
    System.out.println("0-----------------");

    arr.insert(0, "xxxxx");
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }
    System.out.println("7-----------------");
    arr.insert(7, "xxxxx");
    System.out.println("6 -----------------");
    arr.insert(6, "xxxxx");
    System.out.println("6 -----------------");
    arr.insert(6, "xxxxx");
    System.out.println("6 -----------------");
    arr.insert(6, "xxxxx");
    /*
     * System.out.println(0+"부터 "+this cursor+"사이의 값을 입력해"+);
     */

    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }// for
  }

}

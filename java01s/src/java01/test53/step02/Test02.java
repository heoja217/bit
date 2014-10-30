// step2. Data를 외부로부터 입력받음
package java01.test53.step02;

import java01.test53.step03.Iterator;

public class Test02 {

  public static void main(String[] args) {
    Iterator iterator = new Iterator(args);
    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }

}

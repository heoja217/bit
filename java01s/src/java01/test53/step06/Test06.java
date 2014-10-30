// step. Iterator 외에도 EvenI~ ReverseI~ 도 사용가능하도록 수정
/* 
 */
package java01.test53.step06;

public class Test06 {

  public static void main(String[] args) throws Exception {

    String iteratorClassName = System.getProperty("iterator");

    Class clazz = Class.forName(iteratorClassName);
    Iterator iterator = (Iterator)clazz.newInstance();
    iterator.setList(args);
    // 000 111 222 333 444 555 666
    // VM -Diterator=java01.test53.RandomIterator
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
  }

}

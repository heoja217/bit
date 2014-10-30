// step5. Iterator 외에도 EvenI~ ReverseI~ 도 사용가능하도록 수정
/* 이들 클래스의 공통점을 뽑아 수퍼클래스 정의 => Generalization 수행
  Iterator 
       >GeneralIterator
       >EvenIterator
       >ReverseIterator 
 */
package java01.test53.step05;

public class Test05 {

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

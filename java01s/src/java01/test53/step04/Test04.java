// step4. Iterator 변경을 자유롭게 하기
/*
 1) Iterator 클래스 이름을 외부에서 받음
 2) 외부에서 받은 클래스로 Iterator 객체 사용
 3) 그 객체를 사용하여 값을 꺼냄.

 * 값을 외부로부터 받는 방법.
 1) 프로그램 파라미터(아규먼트)
 2) JVM 파라미터(아규먼트)
 ex) java -D파라미터명=값 Test04 파라미터값 파라미터값 파라미터값 ...

 */
package java01.test53.step04;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;

public class Test04 {

  public static void main(String[] args) throws Exception {

    String iteratorClassName = System.getProperty("iterator");
    // 클래스 이름 (패키지명 포함)으로 객체 생성
    // 1) 클래스를 로딩
    Class clazz = Class.forName(iteratorClassName);

    // 2) class 객체를 사용하여 인스턴스 생성
    Iterator iterator = (Iterator)clazz.newInstance();
    
    // 3) Iterator를 사용하기 전에 필요한 값을 설정
    iterator.setList(args);
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    System.out.println("-------------------");
    // Iterator 클래스의 메서드 이름 출력
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
      System.out.println(method.getName()); //public 메서드
    }
    
    //but 다른 Iterator는 사용이 불가능.
    
    
  }

  public static void main01(String[] args) {
    // -D 옵션으로 전달된 값을 꺼낼 때 System.getProperty(파라미터명)
    System.out.println(System.getProperty("iterator"));
    System.out.println(System.getProperty("aa"));
    System.out.println(System.getProperty("bb"));

    String key = null;
    Properties props = System.getProperties();
    Enumeration keyList = props.keys();
    while (keyList.hasMoreElements()) {
      key = (String) keyList.nextElement();
      System.out.println(key + "=> " + props.getProperty(key));
    }
  }

}

package java01.study.iterator;

public class Study {

  public static void main(String[] args) throws Exception {
    String iteratorClassName = System.getProperty("iterator");
    
    // 클래스 이름(패키지명 포함)으로 객체 생성하기
    // 1) 클래스를 로딩하라.
    Class clazz = Class.forName(iteratorClassName);
    
    // 2) Class 객체를 사용하여 인스턴스 생성
    Iterator iterator = (Iterator)clazz.newInstance();
    
    // 3) Iterator를 사용하기 전에 필요한 값을 설정한다.
    iterator.setList(args);
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
  }
}

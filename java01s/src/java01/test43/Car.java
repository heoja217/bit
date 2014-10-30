/* 추상 클래스 : 그 자체로 사용하지 않음 -> 인스턴스를 생성할 수 없다.
abstract calss명

- 일반클래스(concrete class)
   ㄴpackage member class
   ㄴinner class (중첩/내부 클래스)
     ㄴ top level inner class
     ㄴ memver inner class
     ㄴ local inner class
     ㄴ anonymous inner class
- 추상클래스
 */
package java01.test43;

// public (access modifier)와 abstract 키워드는 순서에 상관없음
abstract public class Car {
  String maker;
  int cc;
  java.util.Date releaseDate;
  int capacity; 
  
}

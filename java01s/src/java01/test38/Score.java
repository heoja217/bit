/* 생성자
 1) 리턴타입이 없어야함
 2) 메서드명 == 클래스명
 3) 파라미터가 없는 생성자 -> 기본default생성자
 4) 생성자를 만들지않으면 컴파일러가 자동으로 기본생성자를 만들어줌.
*/
package java01.test38;

public class Score {
  String name; // 인스턴스 변수 or 속성(attribute)
  int kor;
  int eng;
  int math;
  int sum;
  float aver;         
  
  //public Score() {}//생성자를 정의하지 않으면 컴파일러가 자동으로 추가
  
  public Score(String name, int kor, int eng, int math){
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    compute();
  }
  
  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3.0f;
  }
}

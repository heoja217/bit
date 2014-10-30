/*사용자 정의 데이터 타입 + 연산자 추가
*/
package java01.test37;

// Score : 학생의 이름과 국어 영어 수학 평균 합계를 저장하는 메모리의 데이터형.
public class Score {
  String name; // 인스턴스 변수 or 속성(attribute)
  int kor;
  int eng;
  int math;
  int sum;
  float aver;         
  // 연산자를 정의하는 문법 >>메서드
  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3.0f;
  }
}

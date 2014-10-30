package java01.test39;

public class Test39 {

  public static void main(String[] args) {

    Score s = new Score("홍길동", 100, 100, 100);
    // (): 호출할 생성자를 선택하는 명령어.
    //    생성자중에서 파라미터 값을 받지 않는 생성자(기본생성자)를 호출
    // 생성자는 나중에 따로 호출할수 없음. 반드시 new명령 다음에 즉시 호출.

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor  = 90;
    s2.eng = 90;
    s2.math = 90;
    s2.compute();
    
    System.out.println("이름:"+s.name);
    System.out.println("국어:"+s.kor);
    System.out.println("영어:"+s.eng);
    System.out.println("수학:"+s.math);
    System.out.println("합계:"+s.sum);
    System.out.println("평균:"+s.aver);
  }

}

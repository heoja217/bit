package java01;

import java.util.ArrayList;

public class Test13 {

  public static void main(String[] args) {
/*    int kor, eng, math, sci, soc;
    kor = 100;
    eng = 80;
    math = 100;
    sci = 90;
    soc =100;*/
    
  //int scores[] = new int[5];
    int[] scores = new int[5];
    scores = new int[3];
    scores[0] = 100;
    scores[1] = 90;
    scores[2] = 80;
    scores[4] = 70; // Runtime Exception
    
    //int[] scores; :error 같은 변수명 사용 불가
    /*
    
    // 배열 생성. 값을 초기화할땐 개수 지정하지 않음.
    scores = new int[]{100, 90, 100};
    for (int i = 0; i < scores.length; i++){
      System.out.println(scores[i]);
    }
    
    System.out.println("--------------------");
    ArrayList arr = new java.util.ArrayList();
    arr.add("홍길동");
    arr.add(100);
    arr.add(90);
    arr.add(80);
    arr.add(new java.util.Date());
    //arr[0] = "홍길동";
    
    for (int i = 0; i < arr.size; i++){
      System.out.println(arr.get[i]);
    }
    */
  }
}

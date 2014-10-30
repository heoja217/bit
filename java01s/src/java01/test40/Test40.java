/*
 서브클래스의 인스턴스 생성 과정
 */
package java01.test40;

public class Test40 {

  public static void main(String[] args) {

    Car c1 = new Car("현다이", "마구타", 1997);
    Car c2 = new Car("가이아", "M5", 2500);
    
    Truck t1 = new Truck();// 기본 생성자 호출
    
  /* 1)변수준비
[maker  ][model  ][ cc  ][diesel  ][releaseDate][capacity]
[maker  ][model  ][ cc  ][diesel  ][releaseDate][capacity][weight][autoDump]
      2)초기화 
[null(0)][null(0)][  0  ][false(0)][null(0)    ][   0    ][  0   ][false(0)]

     - byte, short, int, long => 0
     - float, double =>0.0
     - char '\u0000' 
     - boolean = false
     - 레퍼런스 => null
     == 모든 비트가 0으로 초기화
     3)초기화 문장 수행     
[null(0)][null(0)][ 800 ][false(0)][  null(0)  ][   5    ][  0   ][false(0)]
[null(0)][null(0)][ 800 ][false(0)][  null(0)  ][   5    ][1000.0][false(0)]
     4)생성자 함수 실행     
[ "미정" ][ "미정" ][ 800 ][false(0)][  null(0)  ][   5    ][1000.0][false(0)]
[ "미정" ][ "미정" ][ 800 ][false(0)][  null(0)  ][   5    ][1000.0][  true  ]

         

  */
  }

}



/*
3Amigo

*/
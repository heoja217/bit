package java01.test44;

public class Soldier extends Mover {
  int attack;
  int level;

  // Mover로부터 상속받은 move()메서드를 서브클래스의 역할에 맞게 재정의
  // 재정의하려는 클래스와 같은 시그너처signature를 갖는 메서드 생성
  //단 공개범위가 축소되어서는 안됨
  
/*  @Override // 수퍼 클래스의 메서드를 재정의하는지 검사 지시
  //public void move(){ 
  public void move(int direction){
    int distance = 1;
    switch (direction){
    case NORTH : y += distance; break;//북쪽
    case EAST : x += distance; break;//동쪽
    case SOUTH : y -= distance; break;//남쪽
    case WEST : x -= distance; break;//서쪽
    }
    System.out.println("walk..walk..." + "," + x + "," + y);
  }
*/
}

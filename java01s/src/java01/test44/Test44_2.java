package java01.test44;

public class Test44_2 {

  public static void main(String[] args) {
    Tank obj1 = new Tank();
    Soldier obj2 = new Soldier();
    Vulture obj3 = new Vulture();
    
    // 다형적 변수
    Vehicle obj4 = new Tank();
    Vehicle obj5 = new Vulture();
    // Vehicle obj6 = new Soldier(); //Error 수퍼클래스의 객체를 가리킬 수 없다
    
    Mover[] arrMover = new Mover[10];
    Unit[] arrUnit = new Unit[10];
    
    // 수퍼클래스의 참조변수로 서브클래스를 가리킬때 수퍼클래스의 메서드를 
    // 호출하더라도 서브클래스에 오버라이딩 메서드가 있다면 그 메서드를 호출
    Vehicle v1 = new Tank();
    v1.move(0); // Tank 호출

  }

}

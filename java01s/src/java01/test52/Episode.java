package java01.test52;
/// l****ocal history
public class Episode {
  static int global;
  int value;
  static void m() {
    global = 20;
    // this.vlaue = 20;//error! 클래스 메서드는 this변수가 없음.
    // this.m2(); //error!
  }

  void m2(){
    
  }

  public static void main(String[] args) {
    Episode p = new Episode();
    // static 이 붙은 메서드도 인스턴스 주소로 호출할 수 있다.
    // 그러나 클래스메서드에는 this라는 내부 변수가 없기때문에 instance주소를 전달할 방법이 없다.
    Episode.m();
    m();// 같은 클래스에 소속되어있으면 클래스명 생략 가능
    p.m();
    
  }

}

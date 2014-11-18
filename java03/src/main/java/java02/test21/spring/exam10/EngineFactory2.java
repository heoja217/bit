package java02.test21.spring.exam10;

public class EngineFactory2 {
  public Engine createEngine(String type) {
    if(type.equals("sedan")) {
      return new Engine("현대", 16);
    } else if(type.equals("sports")) {
      return new Engine("기아", 18);
    } else if(type.equals("SUV")) {
      return new Engine("벤츠", 20);
    } else{
      return new Engine("GM", 22);
    }
  }
}

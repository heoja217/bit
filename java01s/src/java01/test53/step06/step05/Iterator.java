package java01.test53.step05;

abstract public class Iterator {
  // list 인스턴스 변수를 자식클래스도 접근가능하도록 변경 
  protected String[] list;
   
  public void setList(String[] list) {
    this.list = list;
  }
  
  abstract public boolean hasNext();
  
  abstract public String next();
  
}

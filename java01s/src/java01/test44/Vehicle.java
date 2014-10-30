package java01.test44;

abstract public class Vehicle extends Mover{
  int capacity;
  @Override
  public void move(int direction){
    System.out.println("movemove");
  }
}

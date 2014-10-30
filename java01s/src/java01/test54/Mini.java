package java01.test54;

public class Mini implements Unit {

  @Override
  public void run() {
    System.out.println("run~");
  }

  @Override
  public void stop() {
    System.out.println("stop!");
  }

}

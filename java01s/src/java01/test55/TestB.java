package java01.test55;

public class TestB implements Gamer {
  int count;
  
  @Override
  public String who() {
    return "임꺽정";
  }

  @Override
  public void init() {}

  @Override
  public String play() {
    count++;
    return Gamer.SCISSORS;
  }

  @Override
  public void sendResult(int result) {}

}


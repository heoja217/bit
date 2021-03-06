package java01.test55;

public class TestA implements Gamer {
  int s;
  int r;
  int p;

  @Override
  public String who() {
    return "허정아";
  }

  @Override
  public void init() {
  }

  @Override
  public String play() {
    if (s > r && s > p) {
      return Gamer.ROCK;
    } else if (r > s && r > p) {
      return Gamer.PAPER;
    } else if (p > r && p > s) {
      return Gamer.SCISSORS;
    } else
      return Gamer.PAPER;
  }

  @Override
  public void sendResult(int result) {
    if (play() == Gamer.PAPER) {
      switch (result) {
      case 1: r++; break;
      case 0: p++; break;
      case -1:s++; break;
      }
    } else if (play() == Gamer.ROCK) {
      switch (result) {
      case 1: s++; break;
      case 0: r++; break;
      case -1:p++; break;
      }
    }else {
      switch (result) {
      case 1: p++; break;
      case 0: s++; break;
      case -1:r++; break;
      }
    }
  }
}

package java01.test53.step06;

import java01.test53.step05.Iterator;

public class TripleIterator2 extends Iterator {

  int cursor;

  @Override
  public boolean hasNext() {
    if (cursor < list.length)
      return true;
    else
      return false;
  }

  @Override
  public String next() {
    String value = list[cursor];
    cursor += 3;
    return value;
  }

}

package java01.study.iterator;

public class ReverseIterator {
  String[] list;
  int cursor;
  
  public ReverseIterator(String[] list) {
    this.list = list;
  }
  
  public boolean hasNext() {
    if (cursor >= 0)
      return true;
    else
      return false;
  }
  
  public String next() {
     return list[cursor--];   
  }
}

package java01.study.iterator;

public class EvenIterator {
  String[] list;
  int cursor;
  
  public EvenIterator(String[] list) {
    this.list = list;
  }
  
  public boolean hasNext() {
    if (cursor <= list.length)
      return true;
    else
      return false;
  }
  
  public String next() {
     return list[cursor+2];   
  }
}

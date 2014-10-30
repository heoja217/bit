/*

*/
package java02.test02;

import java.io.File;

public class Test06 {

  public static void main(String[] args) throws Exception {
    displayList(".");
  }
  
  public static void displayList(String filename) {

    System.out.println(filename);
    
    File f = new File(filename);
    if (f.isDirectory()){
      String[] files = f.list();
      for (String name : files) {
        displayList(f.getPath() + "/" + name);
      }
    }
    
  }

}

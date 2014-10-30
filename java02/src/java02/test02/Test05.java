/* File 기본 사용
*/
package java02.test02;

import java.io.File;

public class Test05 {

  public static void main(String[] args) throws Exception{
    File f = new File("../HelloWorld");
   
    String[] files = f.list();
    for (String name : files) {
      System.out.println(name);
    }
    /*
    .classpath
    bin
    .project
    src
    */
    System.out.println();
    // 결과 :/home/bit/javaide/workspace/java02/../HelloWorld


    System.out.println(f.getAbsolutePath());
    // 결과 :/home/bit/javaide/workspace/HelloWorld

    System.out.println(f.getCanonicalPath());
    // 결과 :../HelloWorld

    System.out.println(f.getPath());
    // 결과 :java01
    System.out.println(f.getName());
    // 결과 :..
    System.out.println(f.getParent());
  }

}

/* Object 클래스

 */

package java01.test48;

public class Student {
  String name;
  int age;
  
  public Student(String name, int age){
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + "," + age;
  }
}

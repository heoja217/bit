/* 드라이버 로딩

*/
package java02.test14;

import java.sql.DriverManager;

public class Jdbc01 {

  public static void main(String[] args) throws Exception {
    //방법 1. Class.forName() 사용
    Class.forName("com.mysql.jdbc.Driver");
    
    //방법 2. Driver클래스의 instance를 만든 후에 명시적으로 등록
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    // 다른 DBMS로 접속하려면 코드를 변경해야 함.
    
  }

}

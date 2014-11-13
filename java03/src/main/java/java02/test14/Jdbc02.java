/* Connection 객체 얻기
=> java.sql.Driver 구현체를 통해서 얻을수 있음.
=> DriverManager
*/
package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc02 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    try {
      //1 driver 구현체 로딩 
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("jdbc드라이버 로딩됨");
    //DriverManager에게 Connection 객체 부탁
    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb",//jdbc접속을 위한 URL정보. DBMS마다 약간씩 달므.
        "study",//사용자 아이디
        "study" //사용자 암호
        );
    System.out.println("DBMS 연결됨");
    }catch (Exception ex) {
      ex.printStackTrace();
      
    } finally  {
      try { con.close();} catch (Exception ex) {}
      System.out.println("DBMS와 연결 종료");
    }
  }

}
/*                                                       <<interface>>
                                                        java.sql.Driver
                                                              |
                                                              |  
 ①getConnection(url,id,pwd)                 ②connect()     com.mysql.jdbc
----------------------------->DriverManager ---------------> Driver
                                            <--------------   |
                                                 ⑤리턴       |③객체 생성
                                                           com.mysql.jdbc
                                                           LoadBalancedMySQLConnection

*/
/* Statement 객체 얻기 
=> DBMSdp SQL문을 보내는 역할을 수행한다.
=> java.sql.Connection 구현체를 통해서 얻을 수 있다.
 */
package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc03 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    try {
      // 1 driver 구현체 로딩
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("jdbc드라이버 로딩됨");
      // DriverManager에게 Connection 객체 부탁
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb",
      // jdbc접속을 위한 URL정보. DBMS마다 약간씩 다름 .
          "study",// 사용자 아이디
          "study" // 사용자 암호
      );
      System.out.println("DBMS 연결됨");
      stmt = con.createStatement();
      System.out.println("Statement객체 준비 완료 ");
    } catch (Exception ex) {
      ex.printStackTrace();

    } finally {
      try {
        stmt.close();
      } catch (Exception ex) {
      }
      System.out.println("Statement객체의 자원 해제");
      try {
        con.close();
      } catch (Exception ex) {
      }
      System.out.println("DBMS와 연결 종료");
    }
  }

}
/*
 * <<interface>> java.sql.Driver | | ①getConnection(url,id,pwd) ②connect()
 * com.mysql.jdbc ----------------------------->DriverManager --------------->
 * Driver <-------------- | ⑤리턴 |③객체 생성 com.mysql.jdbc
 * LoadBalancedMySQLConnection
 */
/* Insert실행!
 excuteUpdate()호출
 
 리눅스에서 한글이 깨지면 연결정보에 문자집합 설정.
 jdbc url에 설정!
 jdbc:mysql://host:port/schema?useUnicode=true&characterEncoding=utf8
 */
package java02.test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc07 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("jdbc드라이버 로딩됨");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb"+
          "?useUnicode=true&characterEncoding=utf8",
          "study",
          "study" 
      );
      System.out.println("DBMS 연결됨");
    
      stmt = con.createStatement();
      System.out.println("Statement객체 준비 완료 ");
      
      stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME,QTY,MKNO)" + 
      " values('넥서스',99, 6)");
      System.out.println("데이터 입력 완료 ");
      
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
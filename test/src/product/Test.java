package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
  static Scanner scanner;
  static ArrayList<Product> list = new ArrayList<Product>();
  static Connection con;
  static Statement stmt;
  static ResultSet rs;

  static String pName, input1;
  static int qty, input2;
  static int mkno, input3;
  
  public static void main(String[] args) {
    scanner = new Scanner(System.in);

    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("jdbc드라이버 로딩됨");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb"
          + "?useUnicode=true&characterEncoding=utf8", "study", "study");
      System.out.println("DBMS 연결됨");

      stmt = con.createStatement();
      System.out.println("Statement객체 준비 완료 ");

      loop: while (true) {
        try {
          String[] token = promptCommand();

          switch (token[0]) {
          case "add":
            doAdd(token);
            break;
    /*      case "list":
            doList();
            break;*/
          case "delete":
            doDelete(Integer.parseInt(token[1]));
            break;
          case "update":
            doUpdate(Integer.parseInt(token[1]));
            break;
          default:
            System.out.println("이 명령어를 지원하지 않습니다.");
          }

        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();

    } finally {
      try {
        scanner.close();
      } catch (Exception ex) {
      }
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

  private static void doUpdate(int index) throws  SQLException {
    excQuery(index); 

    String text = null;
    System.out.printf("제품명(%s):", input1);
    text = scanner.nextLine();
    if (text.length() > 0)
      pName = text;

    System.out.printf("수량(%d):", input2);
    text = scanner.nextLine();
    if (text.length() > 0)
    qty= Integer.parseInt(text);
    
    System.out.printf("제조사(%d):", input3);
    text = scanner.nextLine();
    if (text.length() > 0)
    mkno= Integer.parseInt(text);
    
    stmt.executeUpdate("update PRODUCTS set" +
        " PNAME='"+pName+"', QTY="+qty+", MKNO="+mkno+ 
        " where PNO="+index);
  }


  private static void doDelete(int index) throws SQLException {
    excQuery(index);


    System.out.print("\""+input1+"\"의 성적을 삭제하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      stmt.executeUpdate("delete from PRODUCTS" +
      " where PNO in("+index+")");
      System.out.println("데이터 삭제 완료.");
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("삭제 취소하였습니다.");
    }

  }

  private static void doAdd(String[] token) throws SQLException {
    String text = null;
    
    System.out.printf("제품명: ");
    text = scanner.nextLine();
    pName = text;

    System.out.printf("수량: ");
    text = scanner.nextLine();
    qty= Integer.parseInt(text);

    System.out.printf("제조사: ");
    text = scanner.nextLine();
    mkno= Integer.parseInt(text);

    System.out.print("저장하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME,QTY,MKNO)" + 
          "values('"+ pName +"'," + qty + "," + mkno + ")");
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("저장 취소하였습니다.");
    }

  }

  private static String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }
  
  private static void excQuery(int index) throws SQLException {
    rs = stmt.executeQuery("SELECT PNAME, QTY, MKNO FROM PRODUCTS where PNO="+index);
    
    if(rs.next()){
      input1 = rs.getString("PNAME");
      input2 = rs.getInt("QTY");
      input3 = rs.getInt("MKNO");
    }
    
  }


}

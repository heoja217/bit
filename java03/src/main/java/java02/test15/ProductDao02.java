/*Prepared Statement 사용하기
 => SQL문을 미리 준비하여 입력값을 파라미터로 전달한다
 => 이점 1) 서버에 SQL문을 보내기 전에 한번만 컴파일한다.
            => 만약 같은 SQL문을 한번에 여러번 실행하는 경우에는 속도가 빠름.
         2) 입력값을 파라미터로 전달하기 떄문에 =>바이너리 데이터 입력 가능하다.
         3) 코딩이 간결함.
*/
package java02.test15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao02 {
  public ProductDao02() {}

  public Product selectOne(int no) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb", 
          "study", 
          "study");
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT PNO,PNAME,QTY,MKNO FROM PRODUCTS"
          + " WHERE PNO=" + no);
      if (rs.next()) {
        Product product = new Product();
        product.setNo(rs.getInt("PNO"));
        product.setName(rs.getString("PNAME"));
        product.setQuantity(rs.getInt("QTY"));
        product.setMakerNo(rs.getInt("MKNO"));
        return product;
      } else {
        return null;
      }
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {rs.close();} catch (Exception ex) {}
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public void update(Product product) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb" + 
            "?useUnicode=true&characterEncoding=utf8", 
          "study",
          "study");
      stmt = con.prepareStatement("UPDATE PRODUCTS SET PNAME=?,QTY=? WHERE PNO=?");
     
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getQuantity());
      stmt.setInt(3, product.getNo());
      stmt.executeUpdate();
              
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public void delete(int no) {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb" + 
            "?useUnicode=true&characterEncoding=utf8", 
          "study",
          "study");
      stmt = con.createStatement();
      stmt.executeUpdate("DELETE FROM PRODUCTS"
          + " WHERE PNO=" + no);
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public List<Product> selectList() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb", 
          "study", 
          "study");
      stmt = con.createStatement();
      rs = stmt.executeQuery(
          "SELECT PNO,PNAME,QTY,MKNO FROM PRODUCTS");
      
      ArrayList<Product> list = new ArrayList<Product>();
      Product product = null;
      
      while (rs.next()) {
        product = new Product();
        product.setNo(rs.getInt("PNO"));
        product.setName(rs.getString("PNAME"));
        product.setQuantity(rs.getInt("QTY"));
        product.setMakerNo(rs.getInt("MKNO"));
        list.add(product);
      }
      
      return list;
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {rs.close();} catch (Exception ex) {}
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
  
  public void insert(Product product) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb" + 
            "?useUnicode=true&characterEncoding=utf8", 
          "study",
          "study");
      stmt = con.prepareStatement("INSERT INTO PRODUCTS(PNAME,QTY,MKNO) VALUES(?,?,?)");
      
      // ?를 in-parameter라고 부른다.
      // 인파라미터의 인덱스는 1부너...
      stmt.setString(1, product.getName());
      stmt.setInt(2, product.getQuantity());
      stmt.setInt(3, product.getMakerNo());
      
      stmt.executeUpdate();
      
    } catch (Exception ex) {
      throw new RuntimeException(ex);
      
    } finally {
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
    }
  }
}



















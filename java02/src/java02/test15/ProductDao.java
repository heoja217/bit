/* DAO(Data Access Object)
 - 데이터의 퍼시스턴스(Persistence) 담당
   => 데이터의 보관(등록,조회,변경,삭제) 
 * 
 */
package java02.test15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class ProductDao {
  
  public ProductDao() {}
  
  public Product selectOne(int no) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb",
          "study",
          "study" 
      );
      stmt = con.createStatement();
      //
      rs = stmt.executeQuery("SELECT PNO, PNAME, QTY FROM PRODUCTS "
          + "WHERE PNO=" + no);
      if(rs.next()) {
        Product product = new Product();
        product.setNo(rs.getInt("PNO"));
        product.setName(rs.getString("PNAME"));
        product.setQuantity(rs.getInt("QTY"));
        product.setMakerNo(rs.getInt("MKNO"));
        }else return null;
    } catch (Exception ex) {
      throw new RuntimeException(ex);

    } finally {
      try {rs.close();} catch (Exception ex) {}
      try {stmt.close();} catch (Exception ex) {}
      try {con.close();} catch (Exception ex) {}
   
  }
    return null;
  }
  
  public void update(Product product) {
    
  }
  
  public void change(int no, Product product) {
  }
  
  public void delete(int no) {
  }
  
  public List<Product> sekectList() {
    return null;
  }
  
  public void insert(Product product) {
  }
  
  public static void main(String[] args) {
    ProductDao dao = new ProductDao();
    Product product = dao.selectOne(1);
    
    System.out.println(product);
   }
}



















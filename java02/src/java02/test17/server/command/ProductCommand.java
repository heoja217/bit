package java02.test17.server.command;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java02.test17.server.Product;
import java02.test17.server.ProductDao;
import java02.test17.server.annotation.Command;
import java02.test17.server.annotation.Component;

@Component
public class ProductCommand {
  ProductDao productDao;
  Scanner scanner;
  
  public void setProductDao(ProductDao productDao) {
    this.productDao = productDao;
  }
  
  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
  
  @Command("add")
  public void add(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
   
    try {
      Product product = new Product();

      product.setName((String)params.get("name"));
      product.setQuantity(Integer.parseInt((String)params.get("qty")));
      product.setMakerNo(Integer.parseInt((String)params.get("mkno")));

      productDao.insert(product);
      out.println("저장하였습니다.");
      out.println();
    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버 오류");
      out.println();
    }
  }
  
  @Command("delete")
  public void delete(Map<String, Object> params) {

    PrintStream out = (PrintStream)params.get("out");
    @SuppressWarnings("unchecked")

    int no = Integer.parseInt((String)params.get("no"));
    Product product = productDao.selectOne(no);
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
    }
    
    productDao.delete(no);
    out.println("삭제하였습니다.");
    out.println();

  }
  
  @Command("list")
  public void list(Map<String, Object> params) {
    @SuppressWarnings("unchecked")
    int pageNo = 0;
    int pageSize = 0;

    if ((String)params.get("pageNo") != null){
      pageNo = Integer.parseInt((String)params.get("pageNo"));        
      pageSize = 3;
    }
    if ((String)params.get("pageSize") != null) {
      pageSize = Integer.parseInt((String)params.get("pageSize"));
    }

    PrintStream out = (PrintStream)params.get("out");
    for (Product product : productDao.selectList(pageNo, pageSize)) {
      out.printf("%-3d %-20s %7d %-3d\n", 
          product.getNo(), 
          product.getName(), 
          product.getQuantity(), 
          product.getMakerNo());
    }
    out.println();
  }
  
  @Command("update")
  public void update(Map<String, Object> params) {
    @SuppressWarnings("unchecked")

    PrintStream out = (PrintStream)params.get("out");
    
    Product product = productDao.selectOne(Integer.parseInt((String)params.get("no")));
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
    }

    try {
      product = new Product();
      product.setNo(Integer.parseInt((String) params.get("no")));
      product.setName((String) params.get("name"));
      product.setQuantity(Integer.parseInt((String) params.get("qty")));
      product.setMakerNo(Integer.parseInt((String) params.get("mkno")));

      productDao.update(product);
      // update?no=18&name=ttt&qty=20&mkno=6
      out.println("변경하였습니다.");
      out.println();
    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버 오류");
      out.println();
    }
  }
  
  @Command("view")
  public void view(Map<String, Object> params) throws Exception {
    @SuppressWarnings("unchecked")
    
    Product product = productDao.selectOne(Integer.parseInt((String)params.get("no")));

    PrintStream out = (PrintStream)params.get("out");
    
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
    }
    
    out.println("제품번호: " + Integer.parseInt((String)params.get("no")));
    out.println("제품명: " + product.getName());
    out.println("수량: " + product.getQuantity());
    out.println("제조사 번호: " + product.getMakerNo());
    out.println();
  }
}









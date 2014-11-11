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
  
  private HashMap<String,String> parseQueryString(String query) {
    // ex) name=pname&qty=20&mkno=6
    // ==> {"name=pname","qty=20","mkno=6"}
    String[] entryList = query.split("&");
    HashMap<String, String> tempMap = new HashMap<>(); 
    String[] token = null;
    for (String entry : entryList) {
      token = entry.split("=");
      tempMap.put(token[0], token[1]);
    }
    return tempMap;
  }
  
  @Command("add")
  public void add(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    ArrayList<String> options = (ArrayList<String>) params.get("options");
   
    try {

      HashMap<String, String> valueMap = parseQueryString(options.get(0));

      Product product = new Product();

      product.setName(valueMap.get("name"));
      product.setQuantity(Integer.parseInt(valueMap.get("qty")));
      product.setMakerNo(Integer.parseInt(valueMap.get("mkno")));

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
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    

    HashMap<String, String> valueMap = parseQueryString(options.get(0));

    Product product = productDao.selectOne(Integer.parseInt(valueMap.get("no")));
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
    }
    
    productDao.delete(Integer.parseInt(valueMap.get("no")));
    out.println("삭제하였습니다.");
    out.println();

  }
  
  @Command("list")
  public void list(Map<String, Object> params) {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    int pageNo = 0;
    int pageSize = 0;
    
    if (options.size() > 0){
      pageNo = Integer.parseInt(options.get(0));        
      pageSize = 3;
    }
    if (options.size() > 1) {
      pageSize = Integer.parseInt(options.get(1));
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
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");

    HashMap<String, String> valueMap = parseQueryString(options.get(0));


    PrintStream out = (PrintStream)params.get("out");
    
    Product product = productDao.selectOne(Integer.parseInt(valueMap.get("no")));
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
    }

    Product tempProduct = null;
    
    try {
      tempProduct = product.clone();
    } catch (CloneNotSupportedException ex) {
      throw new RuntimeException(ex);
    }
    tempProduct.setName(valueMap.get("name"));
    tempProduct.setQuantity(Integer.parseInt(valueMap.get("qty")));
    tempProduct.setMakerNo(Integer.parseInt(valueMap.get("mkno")));
    
    productDao.update(tempProduct);
    //update?no=18&name=ttt&qty=20&mkno=6
  }
  
  @Command("view")
  public void view(Map<String, Object> params) throws Exception {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    int no = Integer.parseInt(options.get(0));
    
    Product product = productDao.selectOne(no);

    PrintStream out = (PrintStream)params.get("out");
    
    if (product == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
    }
    
    out.println("제품번호: " + no);
    out.println("제품명: " + product.getName());
    out.println("수량: " + product.getQuantity());
    out.println("제조사 번호: " + product.getMakerNo());
    out.println();
  }
}









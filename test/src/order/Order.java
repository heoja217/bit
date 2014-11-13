package order;

import java.sql.Date;

public class Order {
  public Order() {}
  
  protected int orderNo;
  protected Date date;
  protected int quantity;
  protected int productNo;
  protected String userid;
  
  public Order(int orderNo, Date date, int quantity, int productNo,
      String userid) {
    super();
    this.orderNo = orderNo;
    this.date = date;
    this.quantity = quantity;
    this.productNo = productNo;
    this.userid = userid;
  }
  
  public int getOrderNo() {
    return orderNo;
  }
  public void setOrderNo(int orderNo) {
    this.orderNo = orderNo;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getProductNo() {
    return productNo;
  }
  public void setProductNo(int productNo) {
    this.productNo = productNo;
  }
  public String getUserid() {
    return userid;
  }
  public void setUserid(String userid) {
    this.userid = userid;
  }
  
  
  
  

}

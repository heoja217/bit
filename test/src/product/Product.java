package product;

public class Product {
  private int pno;
  private String pName;
  private int qty;
  private int mkno;

  public Product() {
  }

  public Product(String pName, int qty, int mkno) {
    this.pName = pName;
    this.qty = qty;
    this.mkno = mkno;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public int getMkno() {
    return mkno;
  }

  public void setMkno(int mkno) {
    this.mkno = mkno;
  }

  public int getPno() {
    return pno;
  }

  public Product(int pno, String pName, int qty, int mkno) {
    this.pno = pno;
    this.pName = pName;
    this.qty = qty;
    this.mkno = mkno;
  }

  @Override
  public Product clone() throws CloneNotSupportedException {
    return (Product) super.clone();
  }



}
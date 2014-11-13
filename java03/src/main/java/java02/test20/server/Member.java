/* Value Object 
 => Class 문법을 사용하여 사용자 정의 데이터타입 만들기
1) Serializable 인터페이스 구현
SerialVersionUID 
2)
3)
4)
5) equals()/hashCode() 메서드 오버라이딩.
6) toString() 오버라이딩 
*/
package java02.test20.server;

import java.io.Serializable;

public class Member implements Serializable , Cloneable{
  private static final long serialVersionUID = 1L;
  
  protected String id;
  protected String pw;
  protected String email;
  protected String name;
  protected String tel;
  protected String fax;
  protected String addr;
  protected String phot;
  protected int addno;
  

  public Member() {}
  
  public Member(String id, String pw, String email, String name, String tel,
      String fax, String addr, String phot, int addno) {
    this.id = id;
    this.pw = pw;
    this.email = email;
    this.name = name;
    this.tel = tel;
    this.fax = fax;
    this.addr = addr;
    this.phot = phot;
    this.addno = addno;
  }

  @Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getPhot() {
    return phot;
  }

  public void setPhot(String phot) {
    this.phot = phot;
  }

  public int getAddno() {
    return addno;
  }

  public void setAddno(int addno) {
    this.addno = addno;
  }

}


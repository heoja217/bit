package java01.test49;

public class MyKey {
  String password;
  int specialNo;
  int secretNo;
  
  public MyKey(String password, int specialNo, int secretNo){
    this.password = password;
    this.specialNo = specialNo;
    this.secretNo = secretNo;
  }
  
  @Override
  public String toString() {
    return "MyKey [password=" + password + ", specialNo=" + specialNo
        + ", secretNo=" + secretNo + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + secretNo;
    result = prime * result + specialNo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MyKey other = (MyKey) obj;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (secretNo != other.secretNo)
      return false;
    if (specialNo != other.specialNo)
      return false;
    return true;
  }
  
}

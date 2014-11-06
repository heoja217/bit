package java02.test13;

public class Test02 {

	public static void main(String[] args) {
	  MyClass p= new MyClass() {
		  @Override
		  public void m() {
			  super.m();
			  System.out.println("ok");
		  }
	  }	  
	}
}

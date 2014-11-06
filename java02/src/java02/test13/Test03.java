package java02.test13;

public class Test03 {

	public static void main(String[] args) {
		class MyClass2 extends Object implements MyInterface {
			@Override
			public void m2() {
				System.out.println("하하하");
			}
		}
		
		//1 클래스명+키워드 제거
		/*extends Object implements MyInterface {
			@Override
			public void m2() {
				System.out.println("하하하");
			}
		}
		*/
		//2 Object 생략
		/*implements MyInterface {
			@Override
			public void m2() {
				System.out.println("하하하");
			}
		}	*/
		
		//3 implements 생략
		/*MyInterface {
			@Override
			public void m2() {
				System.out.println("하하하");
			}
		}	
		*/
		//4 class MyInterface {
		new MyInterface() {
			@Override
			public void m2() {
				System.out.println("하하하");
			}
		}.m2();
	}
}

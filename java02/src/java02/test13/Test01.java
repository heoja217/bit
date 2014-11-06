/* Inner class
1) top level 
  => 작은 크기의 클래스들을 묶고 싶을 때 사용
  => 작은 크기의 클래스들을 패키지에 나열하면 관리가 
2)	
3) 
4)	
 */
package java02.test13;

//0) 패키지 멤버 클래스는 public 또는 default 접근 제어만 가능
// private, protected nononononono
// 이너 클래스는 특정 클래스의 멤버이기 때문에 메서드나 변수처럼 모든 접근제어를 지정 가능!
public class Test01 {
	static int i;
	int j;

	static void x() {
		i = 100;
		// j = 100;// error => static 메서드나 블럭은 내장변수 this가 없다.
	}

	void y() {
		i = 100;// 인스턴스 메서드나 블록은 클래스변수에 바로 접근 가능.
		j = 100;// 인스턴스 메서드나 블록은 this 있음
	}

	// 1) top level inner class
	// static으로 선언된 inner class
	// static이기 때문에 다른 클래스에서도 사용 가능.
	static class TopLevelInnerClass {
		// static 영역에서는 오로지 바깥 클래스의 static 멤버(변수, 메서드)만 접근할 수 있다.
		public void test() {
			i = 10;
			// j = 10;// error 바깥클래스의 인스턴스 주소를 알 수 없음
		}
	}

	// 2) member inner class

	class MemberInnerClass {
		public void test() {
			// 멤버 이너클래스는 내부적으로 바깥 클래스의 인스턴스주소를 가지고 있음
			// 바깥클래스의인스턴스 주소 => 바깥클래스명.this
			i = 200;

			// member 이너클래스에서는 바깥클래스의 인스턴스 멤버를 사용할 수 있다.
			j = 300;
			// 위 코드는 컴파일시 다음과같이 바뀜.
			Test01.this.j = 300;
			// 만약 이너클래스에 위와같은 이름을 가진 변수가 있다면 구분을 위해 개발자가 명시적으로 선언해야 함.
		}
	}

	public static void main(String[] args) {
		// 3) local inner class
		class LocalInnerClass {
			public void test() {
				i = 20;

				// static 블록은 바깥 클래스의 인스턴스주소를 가리킬 수 없다1
				// Test01.this.j = 20; //error~
			}
		}
	}
	public void instanceMethod(){
		class LocalInnerClass{
			public void test(){
				i = 20;
				Test01.this.j = 20;
			}
		}
	}
}

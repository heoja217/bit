package java02.test13;

// static 클래스 import
//1. 모든 정보 입력
//import java02.test13.Test01.TopLevelInnerClass;
//2. import static 구문을 사용하여 static 멤버를 모두 지정

//* import 구문은 컴파일시 클래스 위치를 알리기 위한 구문으로서 컴파일 후 사라져요사라져요사라져...

import static java02.test13.Test01.*;

public class InnerClassUser {
	public static void main(String[] args) {
		//top level inner class 사용
		//방법 1
		Test01.TopLevelInnerClass p = new Test01.TopLevelInnerClass();
		
		//방법 2
		TopLevelInnerClass p2 = new TopLevelInnerClass();
		
		
		//2)
		Test01.MemberInnerClass p3 = null;
	//	p3 = new Test01.MemberInnerClass();// error
	
		Test01 outer =new Test01();
		p3 = outer.new MemberInnerClass(); //=> 잘 안써요ㅎ...
		//member inner class는 일반적으로 그 클래스에서만 사용... 
	}

}

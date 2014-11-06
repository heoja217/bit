// 특정 명령어블럭을 Thread로 분리하기
// 1) Thread 클래스를 상속받아 만듦
/*
new Thread() ──start()─→ Runnable 상태 ──sleep()─→  Not Runnable
								└cpu를 받을 수 있는 상태     └cpu ㄴㄴ
  								│↑
								│ X
 			run()코드 모두 수행 ↓│
							  Death
	
*/
package java02.test12;

public class Test02 {
	static class MyThread extends Thread {
		//병행으로 수행할 명령어는 run()메서드에 넣는다...
		@Override
		public void run() {
			double d = 3.14;;
			double d2 = 12.56;
			d /= d2;
			for(int i = 0; i < 1000; i++) {
				System.out.println("> " + i);
			}
		}
	}
	
	// Runnable 인터페이스 구현
	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			double d = 3.14;;
			double d2 = 12.56;
			d /= d2;
			for(int i = 0; i < 1000; i++) {
				System.out.println("@@ " + i);
			}
		}
	}

	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++) {
			double d = 3.14;
			double d2 = 12.56;
			d /= d2;
			System.out.println("main: " + i);
		}
		
		MyThread t = new MyThread();
		t.start();
		
		Thread t2 = new Thread(new MyRunnable());
		t2.start();
		
		for(int i = 0; i < 1000; i++) {
			double d = 3.14;;
			double d2 = 12.56;
			d /= d2;
			System.out.println("main2: " + i);
		}
	}

}

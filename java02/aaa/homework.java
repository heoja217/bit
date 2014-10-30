package homework;

import java.util.Scanner;


public class homework {

	//----------------------------------
	
	public static void main(String[] args) { // main이에요.

	
		while(true) {
			System.out.print("명령> ");
			Scanner scanner = new Scanner(System.in);
			String keyborad = scanner.nextLine();
			
			switch(keyborad) { // 이게 명령어 창 => 함수로 떨어지게 해요.
			
			case "help":
				showMenu();
				break;
				
			case "exit":
				exit();
				break;
				
			default : 
				System.out.println("잘못된 명령어 입니다.");
				System.out.println(" ");
				
			} // swithch
			
		} // while
		
	} // public static void main
	
	//----------------------------------
	
	static class Score { // 생성자

		String name;
		int kor;
		int eng;
		int math;

		public Score() {}

		public Score(String n, int k, int e, int m) {
			name = n;
			kor = k;
			eng = e;
			math = m;
		}
	} // Score
	
	//----------------------------------
	
	public static void showMenu() { // help
		System.out.println("list");
		System.out.println("view 인덱");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("delete 인덱스");
		System.out.println("update 인덱스");
		System.out.println("exit");
		System.out.println("");
	}
	
	//----------------------------------
	
	public static void exit(){ // exit
		System.out.println("종료합니다.");
		System.exit(0);
	}
	
	//----------------------------------
	
	
}

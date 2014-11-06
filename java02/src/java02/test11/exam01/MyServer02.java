//ServerSocket 사용법

package java02.test11.exam01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class MyServer02 {

	public static void main(String[] args) throws Exception {
		// 클라이언트와 통신을 담당할 객체 생성
		System.out.println("서버 소켓 생성");
		ServerSocket ss = new ServerSocket(8888);
		// 대기열에 있는(연결을 대기하고있는) 클라이언트 중에서 하나 선택하기
		// -> 선택한 클라이언트와의 통신을 담당할 소켓객체 리턴
		
		System.out.println("클라이언트의 연결을 기다리는 중...");
		
		Socket socket = ss.accept();

		System.out.println("대기중인 클라이언트와 연결됨");
		
		// 소켓을 통해 읽고 쓰기 위한 입/출력 스트림 업기
		Scanner in = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());
		
		String line = in.nextLine();

		System.out.println(line);
		String message = prompt();
		
		out.println(message);
		
		in.close();
		out.close();
		socket.close();
		ss.close();
	}

	private static String prompt() {
		System.out.println(">");
		
		Scanner keyboard = new Scanner(System.in);
		String message = keyboard.nextLine();
		keyboard.close();
		
		return message;
	}

}

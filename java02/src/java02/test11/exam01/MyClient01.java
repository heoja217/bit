package java02.test11.exam01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient01 {

	public static void main(String[] args) throws Exception {
		System.out.println("서버를 불러오는 중...");
		Socket socket = new Socket("192.168.0.67", 8888);
		//67 
		System.out.println("서버와 연결 성공!");

		Scanner in = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());

		
		String message = prompt();
		
		out.println(message);
		
		String line = in.nextLine();
		
		System.out.println(line);
		
		in.close();
		out.close();
		socket.close();
	
	}
	
	private static String prompt() {
		System.out.println(">");
		
		Scanner keyboard = new Scanner(System.in);
		String message = keyboard.nextLine();
		keyboard.close();
		
		return message;
	}


}

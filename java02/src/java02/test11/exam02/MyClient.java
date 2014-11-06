//
package java02.test11.exam02;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("서버를 불러오는 중...");
		Socket socket = new Socket("192.168.0.125", 8888);
		// 나: 145 //67 142 125
		System.out.println("서버와 연결 성공!");

		Scanner in = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());
		String message = null;
		String line = null;
		
		while (true) {
			message = prompt();
			out.println(message);
			line = in.nextLine();
			System.out.println(line);

			if (line.equalsIgnoreCase("goodbye")) {
				System.out.println("끊었습니당");
				break;
			}
		}

		in.close();
		out.close();
		socket.close();

		keyboard.close();
	}

	private static String prompt() {
		System.out.print(">");

		String message = keyboard.nextLine();

		return message;
	}

}

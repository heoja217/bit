//여러 클라이언트와 대화 나누기?
//ㄴㄴ

package java02.test11.exam01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		System.out.println("서버 소켓 생성");
		ServerSocket ss = new ServerSocket(8888);

		System.out.println("클라이언트의 연결을 기다리는 중...");
		
		while (true) {

			Socket socket = ss.accept();

			System.out.println("대기중인 클라이언트와 연결됨");

			Scanner in = new Scanner(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());

			String line = null;
			String message = null;

			while (true) {
				line = in.nextLine();
				System.out.println(line);

				if (line.equalsIgnoreCase("quit")) {
					System.out.println("goodbye");
					break;
				}
				message = prompt();
				out.println(message);
			}

			in.close();
			out.close();

			socket.close();
		}


	}

	private static String prompt() {
		System.out.println(">");

		String message = keyboard.nextLine();

		return message;
	}

}

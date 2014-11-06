// 1:1 chat client program  
//192.168.0.
package java02.test11.exam03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	static Scanner keyboard = new Scanner(System.in);
	static String name;
	static String serverAddress;

	public static void main(String[] args) throws Exception {
		Socket socket = null;
		PrintStream out = null;
		Scanner in = null;

		try {
			System.out.print("이름 : ");

			name = keyboard.nextLine();

			System.out.println("서버 주소 : ");
			serverAddress = keyboard.nextLine();

			System.out.println("서버를 불러오는 중...");
			socket = new Socket(serverAddress, 8888);
			// 나: 145 //67 142 125
			System.out.println("서버와 연결 성공!");

			in = new Scanner(socket.getInputStream());
			out = new PrintStream(socket.getOutputStream());

			ChatReaderThread readerThread = new ChatReaderThread(in);
			readerThread.start();

			String message = null;
			String line = null;

			out.println("hello " + name);
			while (true) {
				message = prompt();
				out.println(message);

				if (message.equalsIgnoreCase("guit"))
					break;
			}

		} catch (Exception e) {

		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
			try {
				out.close();
			} catch (Exception e) {
			}
			try {
				socket.close();
			} catch (Exception e) {
			}
			try {
				keyboard.close();
			} catch (Exception e) {
			}
		}
	}

	private static String prompt() {
		System.out.print(">");
		String message = keyboard.nextLine();
		return message;
	}

}

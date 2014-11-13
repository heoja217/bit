package java02.test20.client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ProductMgtClient {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    
    Socket socket = null;
    Scanner in = null;
    PrintStream out = null;
    
    String command = null;
    String message = null;
    
    while (true) {
      System.out.print("명령> ");
      command = keyboard.nextLine();
      
      if (command.startsWith("exit")) {
        break;
      }
      try {
        socket = new Socket("192.168.0.150", 8888);
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        out.println(command);
        while (true) {
          message = in.nextLine();
          if (message.equals("")) {
            break;
          }
          System.out.println(message);
        }
      } catch (Exception ex) {
        System.out.println("명령어 실행 중 오류 발생!");

      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
//        update?no=20&name=ohora2&qty=200&mkno=1    
    try {keyboard.close();} catch (Exception e) {}
  }
  //add?id=u11&pw=11&email=2222222&name=333333&tel=4444&fax=55&addr=66&phot=888&addno=5
//update?id=u11&pw=11&email=222&name=33&tel=44&fax=55&addr=66&phot=77&addno=5
}















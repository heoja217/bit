package order;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderApp {
  static Scanner scanner;
  static ArrayList<Order> list = new ArrayList<>();
  public static void main(String[] args) {
    scanner = new Scanner(System.in);
    
    loop :
    while (true) {
      System.out.print("명령>");
      String[] token = scanner.nextLine().split(" ");
      
      switch(token[0]) {
        case "add" : 
        add(token); 
          break;
        case "list" :
          list(token); 
          break;
        case "view" :
          view(token)
        
          
      
       
    }
    
    
  }

}
  private static void list(String[] token) {
    // TODO Auto-generated method stub
    
  }
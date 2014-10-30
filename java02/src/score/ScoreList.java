package score;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreList {

  static class Score implements Serializable{
    String name;
    int kor;
    int eng;
    int math;
    
    Score() {}
    
    Score(String n, int k, int e, int m) {
      name = n;
      kor = k;
      eng = e;
      math = m;
    }
  }
  
    
  static ArrayList<Score> list = new ArrayList<Score>();
  static Score score;
  static Scanner scanner = new Scanner(System.in);

  
  public static void help() {
    System.out.println("list");
    System.out.println("view 인덱스");
    System.out.println("add 이름 국어 영어 수학");
    System.out.println("delete 인덱스");
    System.out.println("update 인덱스");
    System.out.println("exit");
    System.out.println("");
  }
  
  public static void list() {
    for(int i = 0; i < list.size(); i++){
      score = list.get(i);
      System.out.println(i + " " + score.name + " " 
          + score.kor + " " + score.eng + " " + score.math);
    }
  }
  
  public static void view(int index) {
    score = list.get(index);
    int sum = score.kor + score.eng + score.math;
    float avg = sum / 3.0f;
    System.out.println("인덱스 :" + index);
    System.out.println("이름 :" + score.name);
    System.out.println("국어 :" + score.kor);
    System.out.println("영어 :" + score.eng);
    System.out.println("수학 :" + score.math);
    System.out.println("합계 :" + sum);
    System.out.println("평균 :" + avg);
  }
  
  public static void add(String name, int kor, int eng, int math) {
    list.add(new Score(name, kor, eng, math));
    System.out.println("저장되었습니다.");
  }

 public static void delete(int index) {
   if (index >= list.size() && index < 0){
     System.out.println("index error");
     return;
   }
   System.out.println("Delete?");
   String a = scanner.nextLine();
   if (a.equalsIgnoreCase("y")){
     list.remove(index);  
   }else if (a.equalsIgnoreCase("y")){
     System.out.println("cancel");
   }
 }
 public static void update(int index) {
   if (index >= list.size() && index < 0){
     System.out.println("index error");
     return;
   }
   score = list.get(index);
   String sn, sk, se, sm;
   
   System.out.println("이름 (" + score.name + ") ?");
   sn = scanner.nextLine();
   System.out.println("국어(" + score.kor + ") ?");
   sk = scanner.nextLine();
   System.out.println("영어(" + score.eng + ") ?");
   se = scanner.nextLine();
   System.out.println("수학(" + score.math + ") ?");
   sm = scanner.nextLine();
  
   System.out.println("update?");
   String a = scanner.nextLine();
   if (a.equalsIgnoreCase("y")){
     if(!sn.equals("")) score.name = sn;
     if(!sk.equals("")) score.kor = Integer.parseInt(sk);
     if(!se.equals("")) score.eng = Integer.parseInt(se);
     if(!sm.equals("")) score.math = Integer.parseInt(sm);
   }else if (a.equalsIgnoreCase("y")){
     System.out.println("cancel");
   }
 }
 
 public static void exit() throws IOException {
   FileOutputStream out = new FileOutputStream("score.dat");
   ObjectOutputStream out2 = new ObjectOutputStream(out);
   out2.writeObject(list);

   out2.close();
   out.close();
   
   System.out.println("종료합니다.");
   System.exit(0);
   
 }

  public static void main(String[] args) throws Exception {
    File f = new File("score.dat");
    if (f.exists()) {
      FileInputStream in = new FileInputStream("score.dat");
      ObjectInputStream in2 = new ObjectInputStream(in);
      
      list = (ArrayList<Score>) in2.readObject();
      
      in2.close();
      in.close();
    }
    
    while (true) {
 
      System.out.print("명령> ");
      String keyborad = scanner.nextLine();
      String str[] = keyborad.split(" ");
      
      switch (str[0]) { // 이게 명령어 창 => 함수로 떨어지게 해요.

      case "help":
        help();
        break;

      case "list":
        list();
        break;
      case "view":
        view(Integer.parseInt(str[1]));
        break;

      case "add":
        add(str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]),
            Integer.parseInt(str[4]));
        break;

      case "delete":
        delete(Integer.parseInt(str[1]));
        break;

      case "update":
        update(Integer.parseInt(str[1]));
        break;

      case "exit":
        exit();
        break;

      default:
        System.out.println("잘못된 명령어 입니다.");
        System.out.println(" ");
      }
    }
  }

}

package java02.test02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Home1 {
  static class Score implements Serializable { // 생성자

    String name;
    int kor;
    int eng;
    int math;

    public Score() {
    }

    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;

    }
  } // Score

  static ArrayList<Score> list = new ArrayList<Score>();
  static Score score;
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws Exception {
    File f = new File("score.dat");
    if (f.isFile()) {
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

      case "help":
        showMenu();
        break;

      case "exit":
        exit();
        break;

      default:
        System.out.println("잘못된 명령어 입니다.");
        System.out.println(" ");

      } // switch

    } // while

  } // public static void main

  // ----------------------------------

  public static void list() {
    for(int i = 0; i < list.size(); i++){
      score = list.get(i);
      System.out.println(i + " " + score.name + " " +
          score.kor + " " + score.eng + " " + score.math);
    }
  }
  public static void view(int index) {
    score = list.get(index);
    int sum = score.kor + score.eng + score.math;
    int average = sum / 3;
    System.out.println("인덱스 :" + index);
    System.out.println("이름 :" + score.name);
    System.out.println("국어 :" + score.kor);
    System.out.println("영어 :" + score.eng);
    System.out.println("수학 :" + score.math);
    System.out.println("합계 :" + sum);
    System.out.println("평균 :" + average);
  }

  public static void add(String name, int kor, int eng, int math) {
    list.add(new Score(name, kor, eng, math));
    System.out.println("저장되었습니다.");
  }

  public static void update(int index) {
    if (index >= list.size()) {
      System.out.println("존재하지 않는 인덱스 입니다.");
      return;
    }
    score = list.get(index);
    String name, kor, eng, math;
    System.out.println("이름 (" + score.name + ") ?");
    name = scanner.nextLine();
    System.out.println("국어(" + score.kor + ") ?");
    kor = scanner.nextLine();
    System.out.println("영어(" + score.eng + ") ?");
    eng = scanner.nextLine();
    System.out.println("수학(" + score.math + ") ?");
    math = scanner.nextLine();
    System.out.print("정말 변경하시겠습니까?(y/n)");
    String a = scanner.nextLine();
    if (a.equalsIgnoreCase("y")) {
      if (!name.equals(""))
        score.name = name;
      if (!kor.equals(""))
        score.kor = Integer.parseInt(kor);
      if (!eng.equals(""))
        score.eng = Integer.parseInt(eng);
      if (!math.equals(""))
        score.math = Integer.parseInt(math);
    } else if (a.equalsIgnoreCase("n")) {
      System.out.println("변경 취소하였습니다.");
    }
  }

  public static void delete(int index) {
    if (index >= list.size()) {
      System.out.println("존재하지 않는 인덱스 입니다.");
      return;
    }
    System.out.print("정말 삭제하시겠습니까?(y/n)");
    String a = scanner.nextLine();
    if (a.equalsIgnoreCase("y")) {
      list.remove(index);
      System.out.println("삭제하였습니다.");
    } else if (a.equalsIgnoreCase("n")) {
      System.out.println("삭제 취소하였습니다.");
    }
  }

  public static void showMenu() { // help
    System.out.println("list");
    System.out.println("view 인덱스");
    System.out.println("add 이름 국어 영어 수학");
    System.out.println("delete 인덱스");
    System.out.println("update 인덱스");
    System.out.println("exit");
    System.out.println("");
  }

  // ----------------------------------

  public static void exit() throws IOException { // exit
    FileOutputStream out = new FileOutputStream("score.dat");
    ObjectOutputStream out2 = new ObjectOutputStream(out);
    out2.writeObject(list);

    out2.close();
    out.close();

    System.out.println("종료합니다.");
    System.exit(0);
  }

  // ----------------------------------
}
package java63.test03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
public class Test03 {
  static ArrayList<Score> list = new ArrayList<Score>();
 
  static class Score implements Serializable {
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
  }
 
  public static void help() {
    System.out.println("-------명령어 모음 --------");
    System.out.println("         list           ");
    System.out.println("         add            ");
    System.out.println("         view           ");
    System.out.println("         update         ");
    System.out.println("         delete         ");
    System.out.println("         exit           ");
    System.out.println("------------------------");
  }
 
  public static void view(int index) {
    Score score = new Score();
    score = (Score) list.get(index);
    int sum = score.kor + score.eng + score.math;
    float total = sum / 3.0f;
    System.out.println(" 배열 : [" + index + "] 번째");
    System.out.println(" 이름 : " + score.name);
    System.out.println(" 국어 : " + score.kor);
    System.out.println(" 영어 : " + score.eng);
    System.out.println(" 수학 : " + score.math);
    System.out.println(" 합계 : " + sum);
    System.out.println(" 평균 : " + total);
  }
 
  public static Object add(String name, int kor, int eng, int math) {
    Score score = new Score(name, kor, eng, math);
    list.add(new Score(name, kor, eng, math));
 
    System.out.println("저장 되었습니다.");
    return list;
  }
 
  public static void list() {
    Score score = new Score();
    for (int i = 0; i < list.size(); i++) {
      score = (Score) list.get(i);
      System.out.print("[" + i + "] " + " 이름 : " + score.name);
      System.out.print(" 국어 : " + score.kor);
      System.out.print(" 영어 : " + score.eng);
      System.out.print(" 수학 : " + score.math);
      System.out.println();
    }
  }
 
  public static void update(int index) {
    if (index >= list.size()) {
      System.out.println("존재 하지 않는 배열입니다.");
      return;
    }
    Scanner scanner = new Scanner(System.in);
    String name, kor, eng, math;
    System.out.print(list.get(index).name + " 을 변경할 값을 입력하시요! ==> ");
    name = scanner.nextLine();
    System.out.print(list.get(index).kor + " 을 변경할 값을 입력하시요! ==> ");
    kor = scanner.nextLine();
    System.out.print(list.get(index).eng + " 을 변경할 값을 입력하시요! ==> ");
    eng = scanner.nextLine();
    System.out.print(list.get(index).math + " 을 변경할 값을 입력하시요! ==> ");
    math = scanner.nextLine();
    System.out.println("변경 하시겠습니끼?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      if (!name.equals(""))
        list.get(index).name = name;
      if (!kor.equals(""))
        list.get(index).kor = Integer.parseInt(kor);
      if (!eng.equals(""))
        list.get(index).eng = Integer.parseInt(eng);
      if (!math.equals(""))
        list.get(index).math = Integer.parseInt(math);
 
      System.out.println("변경 완료!");
    } else {
      System.out.println("변경을 취소하였습니다.");
    }
  }
 
  public static void delete(int index) {
    if (index >= list.size()) {
      System.out.println("존재하지 않는 배열입니다. 확인 부탁드립니다.");
      return;
    }
    System.out.println(list.get(index).name+"의 성적을 삭제 하시겠습니까?(y/n)");
    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();
 
    if (answer.equalsIgnoreCase("y")) {
      list.remove(index);
      System.out.println(index + "번째 행 삭제완료");
    } else {
      System.out.println("삭제 취소 되었습니다.");
    }
 
  }
 
  public static void exit() throws Exception {
    FileOutputStream out = new FileOutputStream("score.dat");
    ObjectOutputStream out2 = new ObjectOutputStream(out);
 
    out2.writeObject(list);
    // 닫을 때 꺼꾸로 닫는다.
    out2.close();
    out.close();
    System.out.println("종료되었습니다.");
    System.exit(0);
  }
 
  public static void main(String[] args){
    try {
      File file = new File("score.dat");
      if(file.exists()) {
        FileInputStream in = new FileInputStream("score.dat");
        ObjectInputStream in2 = new ObjectInputStream(in);
        list = (ArrayList<Score>) in2.readObject();
        in2.close();
        in.close();
      }
      while (true) {
        System.out.println("명령 > ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] command = str.split(" ");
        switch (command[0]) {
          case "help": {
            help();
            break;
          }
          case "add": {
            add(command[1], Integer.parseInt(command[2]),
                Integer.parseInt(command[3]),
                Integer.parseInt(command[4]));
            break;
          }
          case "list": {
            list();
            break;
          }
          case "delete": {
            delete(Integer.parseInt(command[1]));
            break;
          }
          case "update": {
            update(Integer.parseInt(command[1]));
            break;
          }
          case "view": {
            view(Integer.parseInt(command[1]));
            break;
          }
          case "exit": {
            exit();
            break;
          }
          default: {
            System.out.println("명령어가 없습니다.");
          }
        }
      }
      
    } catch (NoSuchElementException e) {
        System.out.println("Scanner입력이 없습니다.");
    } catch (NumberFormatException e2){
        System.out.println("입력 방식이 옳지 않습니다.");
    } catch (IndexOutOfBoundsException e3){      
        System.out.println("배열의 범위를 초과하였습니다.");
    } catch (Exception e4 ){
        System.out.println("에러발생 ");
      
    }
  }
}
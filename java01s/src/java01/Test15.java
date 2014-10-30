/*프로그램 아규먼트
 java -cp ./bin:/okok/a:/test/a/b 클래스명 값1 값2 값3 ...\n
 main()의 args 파라미터를 사용
*/

package java01;

public class Test15 {

  public static void main(String[] args) {
    System.out.println("프로그램 아규먼트 개수 :"+ args.length);
    System.out.println("프로그램 아규먼트 값 :");
    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
    }
  }

}

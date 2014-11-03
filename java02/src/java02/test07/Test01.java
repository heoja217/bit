/* 애노테이션이 붙은 클래스를 찾아 자동 로딩하기
 - 클래스를 찾을 때 ClassFinder를 사용한다.
 */
package java02.test07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java02.test07.annotation.Component;
import java02.test07.util.ClassFinder;

public class Test01 {
	Scanner scanner;
	ScoreDao scoreDao;
	HashMap<String, Command> commandMap;

	public void init() throws Exception {
		commandMap = new HashMap<String, Command>();

		// 클래스가 들어 있는 폴더를 뒤져서
		// @Component 애노테이션이 붙은 클래스를 로딩한다.
		// 그 로딩된 클래스의 인스턴스를 생성하여
		// commandMap에 저장한다.

		// 1) 폴더를 뒤져서 클래스 이름(패키지명 + 클래스명)을 알아낸다.
		ClassFinder classFinder = new ClassFinder("test07");
		classFinder.find("./bin");
		List<String> classNames = classFinder.getClassList();

		// 2) 클래스를 로딩한다.
		Class clazz = null;
		Command command = null;
		Component component = null;

		for (String className : classNames) {
			clazz = Class.forName(className);
			/*
			 * 클래스를 로딩한 후 그 로딩한 클래스를 다루는 객체를 리턴. clazz1 =
			 * Class.forName("ListCommand"); clazz2 = ListCommand.class
			 */
			// 3) 로딩된 클래스 중에서 @Component 애노테이션이 붙은 클래스만
			// 인스턴스를 생성한다.
			component = (Component) clazz.getAnnotation(Component.class);
			/*
			 * Type ㄴ클래스 ㄴ인터페이스 ㄴ애노테이션 ㄴ ... (Component.class)(Component 클래스
			 * 객체주소) 모든 타입에는 .class라는 이름의 스태틱변수가 존재함. (= new Class) -> 그 클래스에대한
			 * 타입의 정보를 다루는 Class(java.lang.Class)라는 도구가 들어있음
			 */

			// 타입 정보를 알려주면 클래스에 애노테이션 정보를 리턴
			if (component != null) {
				// command = (Command) clazz.newInstance();
				commandMap
						.put(component.value(), (Command) clazz.newInstance());
			}

		}

		scoreDao = new ScoreDao();
		try {
			scoreDao.load();
		} catch (Exception e) {
			System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
		}

		scanner = new Scanner(System.in);
	}

	public void service() {
		Command command = null;
		loop: while (true) {
			try {
				String[] token = promptCommand();
				command = commandMap.get(token[0]);

				if (command == null) {
					System.out.println("해당 명령을 지원하지 않습니다.");
					continue;
				}

				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("scoreDao", scoreDao);
				params.put("scanner", scanner);

				ArrayList<String> options = new ArrayList<String>();
				for (int i = 1; i < token.length; i++) {
					options.add(token[i]);
				}
				params.put("options", options);

				command.service(params);

				if (token[0].equals("exit"))
					break loop;

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
			}
		}
	}

	public void destroy() {
		scanner.close();
	}

	private String[] promptCommand() {
		System.out.print("명령>");
		String[] token = scanner.nextLine().split(" ");
		return token;
	}

	public static void main(String[] args) throws Exception {
		Test01 app = new Test01();
		app.init();
		app.service();
		app.destroy();
	}

}

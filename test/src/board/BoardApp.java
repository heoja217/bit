package board;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import board.BoardDao;
import board.annotation.Command;
import board.annotation.Component;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

public class BoardApp {

	static class CommandInfo {
		public Object instance;
		public Method method;
	}

	Scanner scanner;
	BoardDao boardDao;
	HashMap<String, CommandInfo> commandMap;

	public void init() throws Exception {


		scanner = new Scanner(System.in);

		commandMap = new HashMap</* 귀찮다. 컴파일러 너가 알아서 추측해서 적어라 */>();

		Reflections reflections = new Reflections("board");
		Set<Class<?>> clazzList = reflections
				.getTypesAnnotatedWith(Component.class);

		Object command = null;
		Component component = null;
		Method method = null;
		CommandInfo commandInfo = null;
		Command commandAnno = null;

		for (Class clazz : clazzList) {
			component = (Component) clazz.getAnnotation(Component.class);
			command = clazz.newInstance();

			// @Component 애노테이션이 붙은 클래스에서
			// @Command가 붙은 메서드를 모두 찾는다.
			// 그 메서드와 인스턴스를 CommandInfo에 담아서
			// CommandMap에 등록한다.
			Set<Method> methods = ReflectionUtils.getMethods(clazz,
					ReflectionUtils.withAnnotation(Command.class));

			for (Method m : methods) {
				commandAnno = m.getAnnotation(Command.class);
				commandInfo = new CommandInfo();
				commandInfo.instance = command;
				commandInfo.method = m;
				commandMap.put(commandAnno.value(), commandInfo);
			}

			try {
				method = clazz.getMethod("setBoardDao", BoardDao.class);
				// System.out.println(
				// clazz.getName() + "." + method.getName());
				method.invoke(command, boardDao);
			} catch (Exception e) {
			}

			try {
				method = clazz.getMethod("setScanner", Scanner.class);
				// System.out.println(
				// clazz.getName() + "." + method.getName());
				method.invoke(command, scanner);
			} catch (Exception e) {
			}
		}

	}

	public void service() {
		CommandInfo commandInfo = null;
		loop: while (true) {
			try {
				String[] token = promptCommand();
				commandInfo = commandMap.get(token[0]);

				if (commandInfo == null) {
					System.out.println("해당 명령을 지원하지 않습니다.");
					continue;
				}

				HashMap<String, Object> params = new HashMap<String, Object>();

				ArrayList<String> options = new ArrayList<String>();
				for (int i = 1; i < token.length; i++) {
					options.add(token[i]);
				}
				params.put("options", options);

				commandInfo.method.invoke(commandInfo.instance, params);

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
		BoardApp app = new BoardApp();
		app.init();
		app.service();
		app.destroy();
	}

}

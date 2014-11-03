package java02.test09.command;

import java.util.ArrayList;

import java.util.Map;
import java02.test09.Score;
import java02.test09.ScoreDao;
import java02.test09.annotation.Command;
import java02.test09.annotation.Component;


@Component("add")
public class AddCommand {
	ScoreDao scoreDao;

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	// 이 메서드는 add 명령을 처리하는 기능을 수행한다.
	// 따라서 Command애노테이션을 붙임
	
	@Command
	public void yaho(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		ArrayList<String> options = (ArrayList<String>) params.get("options");

		Score score = new Score(options.get(0),
				Integer.parseInt(options.get(1)), Integer.parseInt(options
						.get(2)), Integer.parseInt(options.get(3)));

		scoreDao.add(score);
		System.out.println("저장하였습니다.");
	}
			
}


/*
Set<Method> methods = 	ReflictionUtils getMethod(AddCommand.class, 
		ReflectionUtils.withAnnotation(Command.class));
for(Method m : methods) {
	System.out.println("==>" + m.getName());
}

*/
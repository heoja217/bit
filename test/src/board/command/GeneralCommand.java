package board.command;

import java.util.Map;

import board.BoardDao;
import board.annotation.Command;
import board.annotation.Component;

@Component
public class GeneralCommand {
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Command("load")
  public void doload(Map<String, Object> params) throws Exception {
		boardDao = new BoardDao();
		try {
			boardDao.load();
		} catch (Exception e) {
			System.out.println("데이터 로딩 중 오류가 발생하였습니다.");
		}
  }
  
  @Command("save")
  public void doSave(Map<String, Object> params) throws Exception {
		try {
			boardDao.save();
		} catch (Exception e) {
			System.out.println("데이터 저장 중 오류가 발생했습니다.");
		}
  }
	  
  @Command("exit")
  public void doExit() {
  }
  
  @Command("help")
  public void doHelp(Map<String, Object> params) throws Exception {
    System.out.println("list");
    System.out.println("view 인덱스");
    System.out.println("add 이름 국어 영어 수학");
    System.out.println("delete 인덱스");
    System.out.println("update 인덱스");
    System.out.println("exit");
  }
  
  
}

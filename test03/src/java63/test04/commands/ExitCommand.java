package java63.test04.commands;

import java.util.Map;

import java63.test04.ScoreDao;

public class ExitCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "exit";
  } 
  
  @Override
  public void service(Map<String,Object> params) throws Exception {
    try {
      ScoreDao scoreDao = (ScoreDao) params.get("scoreDao");
      scoreDao.save();
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류가 발생하였습니다.");
    }
  }

}

package java63.test04.commands;

import java.util.Map;

import java63.test04.ScoreDao;

public class LoadCommand implements Command {

  @Override
  public String getCommandInfo() {
    return "load";
  }

  @Override
  public void service(Map<String, Object> params) throws Exception {
    try {
      ScoreDao scoreDao = (ScoreDao) params.get("scoreDao");
      scoreDao.load();
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류가 발생하였습니다");
    }

  }

}

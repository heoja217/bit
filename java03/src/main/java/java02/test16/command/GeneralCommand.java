package java02.test16.command;

import java.util.Map;
import java02.test16.MemberDao;
import java02.test16.annotation.Command;
import java02.test16.annotation.Component;

@Component
public class GeneralCommand {
  MemberDao memberDao;
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Command("exit")
  public void doExit(Map<String, Object> params) throws Exception {
    System.out.println("안녕히 가세요.");
  }
  
  @Command("help")
  public void doHelp(Map<String, Object> params) throws Exception {
    System.out.println("list");
    System.out.println("view ID");
    System.out.println("add");
    System.out.println("delete ID");
    System.out.println("update ID");
    System.out.println("exit");
  }
  
  
}










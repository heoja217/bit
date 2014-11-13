package java02.test20.server.command;

import java.io.PrintStream;
import java.util.Map;
import java02.test20.server.MemberDao;
import java02.test20.server.annotation.Command;
import java02.test20.server.annotation.Component;

@Component
public class GeneralCommand {
  MemberDao productDao;
  
  public void setProductDao(MemberDao productDao) {
    this.productDao = productDao;
  }

  @Command("help")
  public void help(Map<String, Object> params) throws Exception {
    PrintStream out = (PrintStream)params.get("out");
    out.println("list");
    out.println("view 제품번호");
    out.println("add");
    out.println("delete 제품번호");
    out.println("update 제품번호");
    out.println();
  }
  
  
}










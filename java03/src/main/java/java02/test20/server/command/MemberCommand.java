package java02.test20.server.command;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java02.test20.server.Member;
import java02.test20.server.MemberDao;
import java02.test20.server.annotation.Command;
import java02.test20.server.annotation.Component;

@Component
public class MemberCommand {
  MemberDao memberDao;
  Scanner scanner;

  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }
  
  @Command("add")
  public void add(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    try {
      Member member = new Member();
      member.setId((String)params.get("id"));
      member.setPw((String)params.get("pw"));
      member.setEmail((String)params.get("email"));
      member.setName((String)params.get("name"));
      member.setTel((String)params.get("tel"));
      member.setFax((String)params.get("fax"));
      member.setAddr((String)params.get("addr"));
      member.setPhot((String)params.get("phot"));
      member.setAddno(Integer.parseInt((String)params.get("addno")));
      
      memberDao.insert(member);
      out.println("저장하였습니다.");
      out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
      out.println();
    }
  }
  
  @Command("delete")
  public void delete(Map<String, Object> params) {
    PrintStream out = (PrintStream) params.get("out");
    String id = (String)params.get("id");
    
    Member member = memberDao.selectOne(id);
    if (member == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
      return;
    }
    
    memberDao.delete(id);
    out.println("삭제하였습니다.");
    out.println();
  }
  
  @Command("list")
  public void list(Map<String, Object> params) {
    int pageNo = 0;
    int pageSize = 0;
    
    if (params.get("pageNo") != null) {
      pageNo = Integer.parseInt((String)params.get("pageNo"));
      pageSize = 3;
    }
    
    if (params.get("pageSize") != null) {
      pageSize = Integer.parseInt((String)params.get("pageSize"));
    }
    
    PrintStream out = (PrintStream)params.get("out");
    
    for (Member member : memberDao.selectList(pageNo, pageSize)) {
      out.printf("%-10s %-10s %25s %-15s\n", 
          member.getId(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel());
    }
    out.println();
  }
  
  @Command("update")
  public void update(Map<String, Object> params) {
    PrintStream out = (PrintStream)params.get("out");
    
    try {
      Member member = new Member();
      member.setId((String)params.get("id"));
      member.setPw((String)params.get("pw"));
      member.setEmail((String)params.get("email"));
      member.setName((String)params.get("name"));
      member.setTel((String)params.get("tel"));
      member.setFax((String)params.get("fax"));
      member.setAddr((String)params.get("addr"));
      member.setPhot((String)params.get("phot"));
      member.setAddno(Integer.parseInt((String)params.get("addno")));
      
      memberDao.update(member);
      out.println("변경하였습니다.");
      out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
      out.println();
    }
  }
  
  @Command("view")
  public void view(Map<String, Object> params) throws Exception {
    String id = (String)params.get("id");
    
    Member member = memberDao.selectOne(id);
    
    PrintStream out = (PrintStream)params.get("out");
    
    if (member == null) {
      out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
      out.println();
      return;
    }
    
    out.println("password: " + member.getPw());
    out.println("Email: " + member.getEmail());
    out.println("이름: " + member.getName());
    out.println("Tel: " + member.getTel());
    out.println("Fax: " + member.getFax());
    out.println("주소: " + member.getAddr());
    out.println("사진: " + member.getPhot());
    out.println("주소번호: " + member.getAddno());
  }
}









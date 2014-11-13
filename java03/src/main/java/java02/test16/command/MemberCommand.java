package java02.test16.command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java02.test16.Member;
import java02.test16.MemberDao;
import java02.test16.annotation.Command;
import java02.test16.annotation.Component;

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
    Member member = new Member();
    
    System.out.print("ID:");
    member.setId(scanner.nextLine());

    System.out.print("password:");
    member.setPw(scanner.nextLine());
    System.out.print("E-mail:");
    member.setEmail(scanner.nextLine());
    System.out.print("Name:");
    member.setName(scanner.nextLine());
    System.out.print("Tel:");
    member.setTel(scanner.nextLine());
    System.out.print("Fax:");
    member.setFax(scanner.nextLine());
    System.out.print("Address:");
    member.setAddr(scanner.nextLine());
    System.out.print("Photo:");
    member.setPhot(scanner.nextLine());
    System.out.print("addressNumber:");
    member.setAddno(Integer.parseInt(scanner.nextLine()));
    
    memberDao.insert(member);
    System.out.println("저장하였습니다.");
  }
  
  @Command("delete")
  public void delete(Map<String, Object> params) {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");
    
    String id = options.get(0);
    
    Member member = memberDao.selectOne(id);
    if (member == null) {
      System.out.println("해당 아이디의 멤버 정보를 찾을 수 없습니다.");
      return;
    }
    
    System.out.print(member.getName() + "을 삭제하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      memberDao.delete(id);
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("삭제 취소하였습니다.");
    }
  }
  
  @Command("list")
  public void list(Map<String, Object> params) {
    for (Member member : memberDao.selectList()) {
      System.out.printf("%-10s %-10s %25s %-15s\n", 
          member.getId(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel());
    }
  }
  
  @Command("update")
  public void update(Map<String, Object> params) {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");

    String id = options.get(0);
    
    Member member = memberDao.selectOne(id);
    if (member == null) {
      System.out.println("해당 아이디의 멤버 정보를 찾을 수 없습니다.");
      return;
    }
    
    Member tempMember = null;
    
    try {
      tempMember = member.clone();
    } catch (CloneNotSupportedException ex) {
      throw new RuntimeException(ex);
    }
    
    String text = null;


    System.out.printf("password(%s):", member.getPw());
    text = scanner.nextLine();
    if (text.length() > 0)
      tempMember.setPw(text);
    
    System.out.printf("E-mail:(%s):", member.getEmail());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setEmail(text);
    
    System.out.printf("Name:(%s):", member.getName());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setName(text);
    
    System.out.printf("Tel:(%s):", member.getTel());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setTel(text);
    
    System.out.printf("Fax:(%s):", member.getFax());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setFax(text);
    
    System.out.printf("Address:(%s):", member.getAddr());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setAddr(text);
    
    System.out.printf("Photo:(%s):", member.getPhot());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setPhot(text);
    
    System.out.printf("Post Number:(%d):", member.getAddno());
    text = scanner.nextLine();
    if (text.length() > 0)
    tempMember.setAddno(Integer.parseInt(text));
    
    System.out.print("정말 변경하시겠습니까?(y/n)");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
      memberDao.update(tempMember);
      System.out.println("변경하였습니다.");
    } else {
      System.out.println("변경 취소하였습니다.");
    }
  }
  
  @Command("view")
  public void view(Map<String, Object> params) throws Exception {
    @SuppressWarnings("unchecked")
    ArrayList<String> options = 
        (ArrayList<String>)params.get("options");

    String id = options.get(0);
     
    Member member = memberDao.selectOne(id);
    if (member == null) {
      System.out.println("해당 아이디의 멤버 정보를 찾을 수 없습니다.");
      return;
    }
    System.out.println("password: " + member.getPw());
    System.out.println("Email: " + member.getEmail());
    System.out.println("이름: " + member.getName());
    System.out.println("Tel: " + member.getTel());
    System.out.println("Fax: " + member.getFax());
    System.out.println("주소: " + member.getAddr());
    System.out.println("사진: " + member.getPhot());
    System.out.println("주소번호: " + member.getAddno());
  }
}









package board.command;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import board.Board;
import board.BoardDao;
import board.annotation.Command;
import board.annotation.Component;

@Component
public class BoardCommand {
	BoardDao boardDao;
	Scanner scanner;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	@Command("add")
	public void ohora(Map<String, Object> params) throws Exception {

		Board board = new Board();

		String text = null;
		System.out.printf("제목: ");
		text = scanner.nextLine();
		if (text.length() > 0)
			board.setTitle(text);
		
		String fullContent = "";
		System.out.println("내용: ");
		while (text.length() > 0) {
			text = scanner.nextLine();
			fullContent += text;
			
			board.setContent(fullContent);
		}

		System.out.printf("암호: ");
		text = scanner.nextLine();
		if (text.length() > 0)
			board.setPassword(text);

		System.out.print(board.getTitle() + "을 저장하시겠습니까?(y/n)");
		if (scanner.nextLine().equalsIgnoreCase("y")) {

			boardDao.add(board);
			System.out.println("저장하였습니다.");
		} else {
			System.out.println("저장 취소하였습니다.");
		}

	}

	@Command("delete")
	public void execute(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		ArrayList<String> options = (ArrayList<String>) params.get("options");

		int index = Integer.parseInt(options.get(0));

		Board board = boardDao.getData(index);
		if (board == null) {
			System.out.println("해당 인덱스의 게시물 정보를 찾을 수 없습니다.");
			return;
		}

		System.out.print(board.getTitle() + "를 삭제하시겠습니까?(y/n)");
		if (scanner.nextLine().equalsIgnoreCase("y")) {
			boardDao.delete(index);
			System.out.println("삭제하였습니다.");
		} else {
			System.out.println("삭제 취소하였습니다.");
		}
	}

	@Command("list")
	public void doList(Map<String, Object> params) throws Exception {
		int index = 0;
		for (Board board : boardDao.getList()) {
			System.out.printf("%-3d %-10s %10s\n", index, board.getDate(), 
					board.getTitle());
			index++;
		}
	}

	@Command("update")
	public void doUpdate(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		ArrayList<String> options = (ArrayList<String>) params.get("options");

		int index = Integer.parseInt(options.get(0));
		Board board = boardDao.getData(index);
		if (board == null) {
			System.out.println("해당 인덱스의 게시물 정보를 찾을 수 없습니다.");
			return;
		}

		Board tempBoard = board.clone();

		String text = null;
		System.out.printf("제목(%s):", board.getTitle());
		text = scanner.nextLine();
		if (text.length() > 0)
			tempBoard.setTitle(text);

		System.out.print("정말 변경하시려면 암호를 입력해 주세요. : ");
		if (scanner.nextLine().equalsIgnoreCase(board.getPassword())) {
			boardDao.change(index, tempBoard);
			System.out.println("변경하였습니다.");
		} else {
			if (scanner.nextLine().equalsIgnoreCase(board.getPassword())) {
				boardDao.change(index, tempBoard);
				System.out.println("변경하였습니다.");
			} else {
				System.out.println("변경 취소하였습니다.");
			}
		}
	}

	@Command("view")
	public void doView(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		ArrayList<String> options = (ArrayList<String>) params.get("options");

		int index = Integer.parseInt(options.get(0));

		Board board = boardDao.getData(index);
		if (board == null) {
			System.out.println("해당 인덱스의 성적 정보를 찾을 수 없습니다.");
			return;
		}

		System.out.println("인덱스: " + index);
		System.out.println("제목: " + board.getTitle());
		System.out.println("날짜: " + board.getDate());
	}
}

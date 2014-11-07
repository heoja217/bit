package board;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import board.Board;

public class BoardDao {
	ArrayList<Board> list = new ArrayList<Board>();
	String filename;

	public BoardDao() {
		filename = "board.dat";
	}

	public BoardDao(String filename) {
		this.filename = filename;
	}

	public void load() throws Exception {
		Scanner dataScanner = null;
		try {
			dataScanner = new Scanner(new FileReader(filename));

			while (true) {
				try {
					list.add(new Board(dataScanner.nextLine()));
				}catch (NoSuchElementException e) {
					break;
				}
			}
		} catch (Exception e) {
			list.clear();
			throw e;
		} finally {
			try {
				dataScanner.close();
			} catch (Exception e) {
			}
		}
	}

	public void save() throws Exception {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(filename));
			
			for (Board board : list) {
				
				out.write(board.getTitle() + "," + board.getContent() + ","
						+ board.getPassword() + "," + board.getDate() + "\n");

			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
			}
		}

	}

	private boolean isValid(int index) {
		if (index < 0 || index >= list.size()) {
			return false;
		} else {
			return true;
		}
	}

	public Board getData(int index) {
		if (isValid(index)) {
			return list.get(index);
		} else {
			return null;
		}
	}

	public void change(int index, Board data) {
		list.set(index, data);
	}

	public void delete(int index) {
		list.remove(index);

	}

	public List<Board> getList() {
		return list;
	}

	public void add(Board data) {
		list.add(data);
	}

}

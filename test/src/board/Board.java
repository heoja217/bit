package board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private String title;
	private String content;
	private String password;
	private String date;

	public Board() {
		newDate();
	}

	public Board(String t, String c, String p) {
		title = t;
		content = c;
		password = p;
		newDate();
	}

	public Board(String csv) {
		String[] token = csv.split(",");
		this.title = token[0];
		this.content = token[1];
		this.password = token[2];
		this.date = token[3];
	}

	@Override
	public Board clone() throws CloneNotSupportedException {
		return (Board) super.clone();
	}

	public void newDate() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = dateFormat.format(new Date());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}

}

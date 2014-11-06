package java02.test11.exam04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient01 extends Frame {
	TextArea content = new TextArea();
	TextField input = new TextField(45);
	TextField serverAddr = new TextField();
	TextField name = new TextField(10);
	Button sendBtn = new Button("보내기");
	Button connectBtn = new Button("연결");

	public ChatClient01() {
		// 윈도우 준비
		Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(new Label("이름: "));
		toolbar.add(name);
		toolbar.add(new Label("서버: "));
		serverAddr.setColumns(15);
		toolbar.add(serverAddr);
		toolbar.add(connectBtn);

		this.add(toolbar, BorderLayout.NORTH);

		this.add(content, BorderLayout.CENTER);

		Panel bottom = new Panel(new FlowLayout(FlowLayout.LEFT));
		bottom.add(input);
		bottom.add(sendBtn);

		this.add(bottom, BorderLayout.SOUTH);

		// 리스너 등록
		// 1) 윈도우 이벤트를 처리할 리스너 객체 등록
		// WindowListener 인터페이스를 구현한 객체여야 한다
		this.addWindowListener(new MyWindowListener());
		connectBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("연결버튼 클릭!");
			}
		});
		sendBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("보내기버튼 클릭!");
			}
		});
	}

	public static void main(String[] args) {
		ChatClient01 wnd = new ChatClient01();
		wnd.setSize(400, 600);
		wnd.setVisible(true);
	}

	class MyWindowListener extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

}
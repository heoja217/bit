package java02.test12;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.scene.Parent;

public class Test01 {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("1) main() 호출 스레드: " + t.getName());

		ThreadGroup g = t.getThreadGroup();
		System.out.println("2) main() 스레드가 소속된 그룹: " + g.getName());

		ThreadGroup parent = g.getParent();
		System.out.println("3) main TG의 상위 그룹: " + parent.getName());

		// parent = parent.getParent();
		// System.out.println("4) system TG의 상위그룹: " + parent.getName());
		
		browseThreadInfo(parent, 0);

	}

	public static void browseThreadInfo(ThreadGroup tg, int level) {
		displaySpaces(level);
		System.out.println("└─[" + tg.getName() + "]");

		ThreadGroup[] groups = new ThreadGroup[10];
		int groupCount = 0;

		groupCount = tg.enumerate(groups, false);
		for (int i = 0; i < groupCount; i++) {
			browseThreadInfo(groups[i], level + 1);
		}

		Thread[] threads = new Thread[10];
		int threadCount = 0;
		threadCount = tg.enumerate(threads, false);
		for (int i = 0; i < threadCount; i++) {
			displaySpaces(level + 1);
			System.out.println("└─>" + threads[i].getName());
		}
	}

	public static void displaySpaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print("  ");
	}
}

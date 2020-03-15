package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//윈도우 종료 클래스
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // 윈도 종료
		}
	}
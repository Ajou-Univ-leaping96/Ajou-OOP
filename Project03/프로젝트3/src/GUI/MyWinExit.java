package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//������ ���� Ŭ����
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // ���� ����
		}
	}
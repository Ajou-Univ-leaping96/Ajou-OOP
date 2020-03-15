package 실습;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.Timer.*;

public class AnonymousInnerClassTest 
{
	public static void main(String[] args)
	{
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
	
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock
{
	public void start(int interval, boolean beep)
	{
		//start라는 메소드 내의 이너로컬 클래스를 정의하여 ActionListener 라는 인터페이스를 구현하도록 함
		class InnerLocalListener implements java.awt.event.ActionListener{
			public void actionPerformed(ActionEvent event) 
			{
				System.out.println("At the tone, the time is " + new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		}
		
		InnerLocalListener listener = new InnerLocalListener(); 
		
	Timer t = new Timer(interval, listener); //외부의 Timer클래스에 접근해 인스턴스화 하는 부분
	t.start(); 
	}
}

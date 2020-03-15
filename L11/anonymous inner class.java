//코드를 그대로 수행함
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
		ActionListener listener = new ActionListener() //익명의 listener 객체의 클래스를  아래에서 정의
		{
			public void actionPerformed(ActionEvent event) //즉석에서 actionPerformed 메소드를 정의=> 인터페이스 구현
			{
				System.out.println("At the tone, the time is " + new Date());
				if (beep) Toolkit.getDefaultToolkit().beep();
			}
		};
	Timer t = new Timer(interval, listener); //외부의 Timer클래스에 접근해 인스턴스화 하는 부분
	t.start(); 
	}
}
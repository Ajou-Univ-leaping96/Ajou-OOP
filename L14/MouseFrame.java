package 실습;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * A frame containing a panel for testing mouse operations
 */
public class MouseFrame extends JFrame {
	// 컨테이너와 마우스컴포넌트 변수
	Container C_Button;
	Container C_Mouse;
	MouseComponent M;

	public MouseFrame() {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeMouse();

			}
		};

		// 컨테이너 두개 생성
		C_Button = getContentPane();
		C_Mouse = getContentPane();
		// 마우스 컴포넌트 생성
		M = new MouseComponent();

		// 모두삭제하는 버튼 생성
		JButton b = new JButton("모두삭제");

		// 컨테이너에 버튼 (listener인터페이스 구현된)추가
		C_Button.add(b, BorderLayout.SOUTH);
		b.addActionListener(listener);

		// 마우스 컴포넌트는 다른 컨테이너에 추가
		C_Mouse.add(M);
		pack();
	}

	// 전체 사각형 지우는 메소드
	void removeMouse() {
		C_Mouse.remove(M);
		System.out.println("모두삭제");
		M = new MouseComponent();
		C_Mouse.add(M);
		C_Mouse.revalidate();
	}
}
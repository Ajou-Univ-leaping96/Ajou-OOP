package GUI_test;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ComFrame extends JFrame implements ActionListener {
//콤포넌트 생성
	private JLabel a = new JLabel("레이블");
	private JButton b = new JButton("입력");
	private JTextField tf = new JTextField(20);

	public ComFrame() {
		setLayout(new FlowLayout());
// JLabel, JButton, JTextField 등록
		add(a);
		add(tf);
		add(b);
//이벤트를 버튼에 등록.."b 소방관 아저씨 등록"
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// 소방관 아저씨가 불을 꺼야죠
// TODO Auto-generated method stub
//이벤트 처리
		if (e.getSource() == b) {
			a.setText(tf.getText());// JTextField의 문자열을 JLabel로 set
		}
	}
}

public class SwingComFrameMain {
	public static void main(String[] args) {
		JFrame f = new ComFrame();// 이부분이 수정 클래스 이름이 같아야 해요
		f.setSize(300, 300);
		f.show();
	}
}
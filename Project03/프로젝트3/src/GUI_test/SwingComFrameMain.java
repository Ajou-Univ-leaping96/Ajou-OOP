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
//������Ʈ ����
	private JLabel a = new JLabel("���̺�");
	private JButton b = new JButton("�Է�");
	private JTextField tf = new JTextField(20);

	public ComFrame() {
		setLayout(new FlowLayout());
// JLabel, JButton, JTextField ���
		add(a);
		add(tf);
		add(b);
//�̺�Ʈ�� ��ư�� ���.."b �ҹ�� ������ ���"
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// �ҹ�� �������� ���� ������
// TODO Auto-generated method stub
//�̺�Ʈ ó��
		if (e.getSource() == b) {
			a.setText(tf.getText());// JTextField�� ���ڿ��� JLabel�� set
		}
	}
}

public class SwingComFrameMain {
	public static void main(String[] args) {
		JFrame f = new ComFrame();// �̺κ��� ���� Ŭ���� �̸��� ���ƾ� �ؿ�
		f.setSize(300, 300);
		f.show();
	}
}
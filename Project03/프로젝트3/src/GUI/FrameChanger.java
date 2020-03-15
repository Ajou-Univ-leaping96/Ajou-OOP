package GUI;

import cse.oop.seats.*;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Calendar;

import javax.swing.*;

//�ʱ�ȭ�� ������
class FirstFrame extends JFrame implements ActionListener {

	FirstFrame() {
		super("�ʱ�ȭ��");
		setVisible(true);
		setSize(300, 300);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setLocationRelativeTo(null);
		addWindowListener(new MyWinExit());

		// �����̳� ����
		Container C = getContentPane();

		// �гλ���
		JPanel p = new JPanel();

		// ��ư���� & �׼Ǹ����� �߰�
		JButton goto_R = new JButton("�����ϱ�");
		JButton goto_C = new JButton("����Ȯ��&���");
		goto_R.addActionListener(this);
		goto_C.addActionListener(this);

		// �гο� ��ư�߰�
		p.add(goto_R);
		p.add(goto_C);

		C.add(p);
		pack();
	}

	/*
	// ������ ���� Ŭ����
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // ���� ����
		}
	}
	*/

	// ��ưŬ�� �̺�Ʈ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("�����ϱ�")) {
			new ReserveFrame();
			this.setVisible(false);
		} else if (str.equals("����Ȯ��&���")) {
			new CancleFrame();
			this.setVisible(false);
		}

	}
}// ù ��° ������ ��

//�����ϱ� ������
class ReserveFrame extends JFrame implements ActionListener {
	JTextField yearTf;
	JTextField monthTf;
	JTextField dayTf;

	int year, month, day, row, col; // ���డ�ɽð��� ����ϱ����� ���ڵ�

	JLabel[] isCan; // �ð����� ��ȿ���� ǥ���ϱ� ���� ��

	ReserveFrame() {
		super("�����ϱ�");
		setVisible(true);
		setLocation(0, 0);

		addWindowListener(new MyWinExit());

		// �����̳� ����
		Container C = getContentPane();

		// ����� �г�
		JPanel Time = new JPanel();
		Time.setLayout(new FlowLayout());

		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		String cur_Year = Integer.toString(year);
		String cur_Month = Integer.toString(month);
		String cur_Day = Integer.toString(day);

		int Year_set, Month_set, Day_set; // ��ư ������ �޾��� ����ϰ�

		yearTf = new JTextField(cur_Year, 4);
		monthTf = new JTextField(cur_Month, 2);
		dayTf = new JTextField(cur_Day, 2);
		Time.add(yearTf);
		Time.add(new JLabel("��"));
		Time.add(monthTf);
		Time.add(new JLabel("�� "));
		Time.add(dayTf);
		Time.add(new JLabel("�� "));
		JButton setTime = new JButton("��¥����");
		setTime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input_Year, input_Month, input_Day;
				input_Year = yearTf.getText();
				input_Month = monthTf.getText();
				input_Day = dayTf.getText();

				year = Integer.parseInt(input_Year);
				month = Integer.parseInt(input_Month);
				day = Integer.parseInt(input_Day);
				System.out.println("�Է¹��� �� �� ��: " + year + " / " + month + " / " + day);
				// year month day row col ��� �ԷµǾ�������� ���ɽð��� ����
				if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
					int[] time;
					time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
					for (int i = 0; i < time.length; i++) {
						if (time[i] == 1) {
							// System.out.println((i+1) +"�� �ð���� �����մϴ�");
							// i������ ���డ�ɹ�ư�� �����ϴٰ� ǥ��
							isCan[i].setText("����");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.GREEN);
						} else if (time[i] == 0) {
							isCan[i].setText("�Ұ���");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.RED);
						}
					}
				}
			}

		});
		Time.add(setTime);
		C.add(Time, BorderLayout.NORTH);

		// �¼� �г�
		JPanel Seats = new JPanel();
		Seats.setLayout(new GridLayout(5, 5));
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				JButton seat = new JButton("< " + i + " ," + j + " >");
				int input_row = i;
				int input_col = j;
				seat.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// Ŭ���ϸ� row�� col�� �ش� �¼��� ��� ���� set�ϴ� �̺�Ʈ�ڵ鷯
						row = input_row;
						col = input_col;
						// System.out.println("�Է¹��� ��/�� : " + row + "," + col);

						// year month day row col ��� �ԷµǾ�������� ���ɽð��� ����
						if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
							int[] time;
							time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
							for (int i = 0; i < time.length; i++) {
								if (time[i] == 1) {
									// System.out.println((i+1) +"�� �ð���� �����մϴ�");
									// i������ ���డ�ɹ�ư�� �����ϴٰ� ǥ��
									isCan[i].setText("����");
									isCan[i].setOpaque(true);
									isCan[i].setBackground(Color.GREEN);
								} else if (time[i] == 0) {
									isCan[i].setText("�Ұ���");
									isCan[i].setOpaque(true);
									isCan[i].setBackground(Color.RED);
								}
							}
						}
					}

				});
				Seats.add(seat);
			}
		}
		C.add(Seats, BorderLayout.CENTER);

		// ���ɽð��� �г�
		JPanel CanTime = new JPanel();
		CanTime.setLayout(new GridLayout(0, 1));
		JButton[] canTime = new JButton[9];
		canTime[0] = new JButton("9-10");
		canTime[1] = new JButton("10-11");
		canTime[2] = new JButton("11-12");
		canTime[3] = new JButton("12-13");
		canTime[4] = new JButton("13-14");
		canTime[5] = new JButton("14-15");
		canTime[6] = new JButton("15-16");
		canTime[7] = new JButton("16-17");
		canTime[8] = new JButton("17-18");

		// �׼Ǹ������߰� =>Ŭ���ϸ� ��ȭ���� ����
		for (int i = 0; i < canTime.length; i++) {
			int start = i + 9;
			int finish = start + 1;
			canTime[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					int result = JOptionPane.showConfirmDialog(null, "�̽ð���� �����ϰڽ��ϱ�?", "��������",
							JOptionPane.OK_CANCEL_OPTION);

					if (result == 0) { // OK=0 , Cancel=2 ����
						/*
						System.out.println(year);
						System.out.println(month);
						System.out.println(day);
						System.out.println(row);
						System.out.println(col);
						System.out.println(start);
						System.out.println(finish);
						*/
						
						//���������
						Manager.MakeReserve_GUI(year, month, day, row, col, start, finish);
					}

					// year month day row col ��� �ԷµǾ�������� ���ɽð��� ����
					if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
						int[] time;
						time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
						for (int i = 0; i < time.length; i++) {
							if (time[i] == 1) {
								// System.out.println((i+1) +"�� �ð���� �����մϴ�");
								// i������ ���డ�ɹ�ư�� �����ϴٰ� ǥ��
								isCan[i].setText("����");
								isCan[i].setOpaque(true);
								isCan[i].setBackground(Color.GREEN);
							} else if (time[i] == 0) {
								isCan[i].setText("�Ұ���");
								isCan[i].setOpaque(true);
								isCan[i].setBackground(Color.RED);
							}
						}
					}
				}

			});
		}

		isCan = new JLabel[9];
		for (int i = 0; i < isCan.length; i++) {
			isCan[i] = new JLabel("�¼������ʿ�");
		}

		for (int i = 0; i < canTime.length; i++) {
			CanTime.add(canTime[i]);
			CanTime.add(isCan[i]);
		}

		C.add(CanTime, BorderLayout.AFTER_LINE_ENDS);

		// ����Ϸ� ��ư
		JButton exit = new JButton("����Ϸ�");
		exit.addActionListener(this);
		C.add(exit, BorderLayout.SOUTH);

		pack();

	}
	
	/*
	// ������ ���� Ŭ����
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // ���� ����
		}
	}
	*/

	// ����Ϸ� ��ưŬ�� �̺�Ʈ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("����Ϸ�")) {
			new FirstFrame();
			this.setVisible(false);
		}
	}

}// ���� ������ ��

//����&��� ������
class CancleFrame extends JFrame implements ActionListener {
	JTextField yearTf;
	JTextField monthTf;
	JTextField dayTf;

	int year, month, day, row, col; // ���డ�ɽð��� ����ϱ����� ���ڵ�

	JLabel[] isCan; // �ð����� ��ȿ���� ǥ���ϱ� ���� ��

	CancleFrame() {
		super("���ຸ��&���");
		setVisible(true);
		setLocation(0, 0);

		addWindowListener(new MyWinExit());

		// �����̳� ����
		Container C = getContentPane();

		// ����� �г�

		JPanel Time = new JPanel();
		Time.setLayout(new FlowLayout());

		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		String cur_Year = Integer.toString(year);
		String cur_Month = Integer.toString(month);
		String cur_Day = Integer.toString(day);

		int Year_set, Month_set, Day_set; // ��ư ������ �޾��� ����ϰ�

		yearTf = new JTextField(cur_Year, 4);
		monthTf = new JTextField(cur_Month, 2);
		dayTf = new JTextField(cur_Day, 2);
		Time.add(yearTf);
		Time.add(new JLabel("��"));
		Time.add(monthTf);
		Time.add(new JLabel("�� "));
		Time.add(dayTf);
		Time.add(new JLabel("�� "));
		JButton setTime = new JButton("��¥����");
		setTime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input_Year, input_Month, input_Day;
				input_Year = yearTf.getText();
				input_Month = monthTf.getText();
				input_Day = dayTf.getText();

				year = Integer.parseInt(input_Year);
				month = Integer.parseInt(input_Month);
				day = Integer.parseInt(input_Day);
				System.out.println("�Է¹��� �� �� ��: " + year + " / " + month + " / " + day);
				// year month day row col ��� �ԷµǾ�������� ���ɽð��� ����
				if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
					int[] time;
					time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
					for (int i = 0; i < time.length; i++) {
						if (time[i] == 1) {
							// System.out.println((i+1) +"�� �ð���� �����մϴ�");
							// i������ ���డ�ɹ�ư�� �����ϴٰ� ǥ��
							isCan[i].setText("�������");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.GRAY);
						} else if (time[i] == 0) {
							isCan[i].setText("��������");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.CYAN);
						}
					}
				}

			}

		});
		Time.add(setTime);
		C.add(Time, BorderLayout.NORTH);

		// �¼� �г�
		JPanel Seats = new JPanel();
		Seats.setLayout(new GridLayout(5, 5));
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				JButton seat = new JButton("< " + i + " ," + j + " >");
				int input_row = i;
				int input_col = j;
				seat.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// Ŭ���ϸ� row�� col�� �ش� �¼��� ��� ���� set�ϴ� �̺�Ʈ�ڵ鷯
						row = input_row;
						col = input_col;
						// System.out.println("�Է¹��� ��/�� : " + row + "," + col);

						// year month day row col ��� �ԷµǾ�������� ���ɽð��� ����
						if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
							int[] time;
							time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
							for (int i = 0; i < time.length; i++) {
								if (time[i] == 1) {
									// System.out.println((i+1) +"�� �ð���� �����մϴ�");
									// i������ ���డ�ɹ�ư�� �����ϴٰ� ǥ��
									isCan[i].setText("�������");
									isCan[i].setOpaque(true);
									isCan[i].setBackground(Color.GRAY);
								} else if (time[i] == 0) {
									isCan[i].setText("��������");
									isCan[i].setOpaque(true);
									isCan[i].setBackground(Color.CYAN);
								}
							}
						}

					}

				});
				Seats.add(seat);
			}
		}
		C.add(Seats, BorderLayout.CENTER);

		// ���ɽð��� �г�
		JPanel CanTime = new JPanel();
		CanTime.setLayout(new GridLayout(0, 1));
		JButton[] canTime = new JButton[9];
		canTime[0] = new JButton("9-10");
		canTime[1] = new JButton("10-11");
		canTime[2] = new JButton("11-12");
		canTime[3] = new JButton("12-13");
		canTime[4] = new JButton("13-14");
		canTime[5] = new JButton("14-15");
		canTime[6] = new JButton("15-16");
		canTime[7] = new JButton("16-17");
		canTime[8] = new JButton("17-18");

		// �׼Ǹ������߰� =>Ŭ���ϸ� ��ȭ���� ����
		for (int i = 0; i < canTime.length; i++) {
			int start = i + 9;
			int finish = start + 1;
			canTime[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					int result = JOptionPane.showConfirmDialog(null, "�� ������ ����ϰڽ��ϱ�?", "����Ȯ��",
							JOptionPane.OK_CANCEL_OPTION);

					if (result == 0) { // OK=0 , Cancel=2 ����
						/*
						System.out.println(year);
						System.out.println(month);
						System.out.println(day);
						System.out.println(row);
						System.out.println(col);
						System.out.println(start);
						System.out.println(finish);
						*/
						// ����ϴ� �Լ�
						Manager.DeleteReserve_GUI(year, month, day, row, col, start, finish);
					}

					// year month day row col ��� �ԷµǾ�������� ���ɽð��� ����
					if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
						int[] time;
						time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
						for (int i = 0; i < time.length; i++) {
							if (time[i] == 1) {
								// System.out.println((i+1) +"�� �ð���� �����մϴ�");
								// i������ ���డ�ɹ�ư�� �����ϴٰ� ǥ��
								isCan[i].setText("�������");
								isCan[i].setOpaque(true);
								isCan[i].setBackground(Color.GRAY);
							} else if (time[i] == 0) {
								isCan[i].setText("��������");
								isCan[i].setOpaque(true);
								isCan[i].setBackground(Color.CYAN);
							}
						}
					}

				}

			});
		}

		isCan = new JLabel[9];
		for (int i = 0; i < isCan.length; i++) {
			isCan[i] = new JLabel("�¼������ʿ�");
			isCan[i].setOpaque(true);
		}

		for (int i = 0; i < canTime.length; i++) {
			CanTime.add(canTime[i]);
			CanTime.add(isCan[i]);
		}

		C.add(CanTime, BorderLayout.AFTER_LINE_ENDS);

		// ����Ϸ� ��ư
		JButton exit = new JButton("��ҿϷ�");
		exit.addActionListener(this);
		C.add(exit, BorderLayout.SOUTH);

		pack();

	}

	/*
	// ������ ���� Ŭ����
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // ���� ����
		}
	}
	*/

	// ����Ϸ� ��ưŬ�� �̺�Ʈ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("��ҿϷ�")) {
			new FirstFrame();
			this.setVisible(false);
		}
	}

}// �� ��° ������ ��

//���� �Լ�
public class FrameChanger {
	public static void main(String[] args) {
		new FirstFrame();
	}
}
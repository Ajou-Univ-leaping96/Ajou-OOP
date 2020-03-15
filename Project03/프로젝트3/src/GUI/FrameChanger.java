package GUI;

import cse.oop.seats.*;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Calendar;

import javax.swing.*;

//초기화면 프레임
class FirstFrame extends JFrame implements ActionListener {

	FirstFrame() {
		super("초기화면");
		setVisible(true);
		setSize(300, 300);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setLocationRelativeTo(null);
		addWindowListener(new MyWinExit());

		// 컨테이너 생성
		Container C = getContentPane();

		// 패널생성
		JPanel p = new JPanel();

		// 버튼생성 & 액션리스너 추가
		JButton goto_R = new JButton("예약하기");
		JButton goto_C = new JButton("예약확인&취소");
		goto_R.addActionListener(this);
		goto_C.addActionListener(this);

		// 패널에 버튼추가
		p.add(goto_R);
		p.add(goto_C);

		C.add(p);
		pack();
	}

	/*
	// 윈도우 종료 클래스
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // 윈도 종료
		}
	}
	*/

	// 버튼클릭 이벤트 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("예약하기")) {
			new ReserveFrame();
			this.setVisible(false);
		} else if (str.equals("예약확인&취소")) {
			new CancleFrame();
			this.setVisible(false);
		}

	}
}// 첫 번째 프레임 끝

//예약하기 프레임
class ReserveFrame extends JFrame implements ActionListener {
	JTextField yearTf;
	JTextField monthTf;
	JTextField dayTf;

	int year, month, day, row, col; // 예약가능시간을 출력하기위한 인자들

	JLabel[] isCan; // 시간대의 유효성을 표현하기 위한 라벨

	ReserveFrame() {
		super("예약하기");
		setVisible(true);
		setLocation(0, 0);

		addWindowListener(new MyWinExit());

		// 컨테이너 생성
		Container C = getContentPane();

		// 년월일 패널
		JPanel Time = new JPanel();
		Time.setLayout(new FlowLayout());

		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		String cur_Year = Integer.toString(year);
		String cur_Month = Integer.toString(month);
		String cur_Day = Integer.toString(day);

		int Year_set, Month_set, Day_set; // 버튼 누를시 받아진 년월일값

		yearTf = new JTextField(cur_Year, 4);
		monthTf = new JTextField(cur_Month, 2);
		dayTf = new JTextField(cur_Day, 2);
		Time.add(yearTf);
		Time.add(new JLabel("년"));
		Time.add(monthTf);
		Time.add(new JLabel("월 "));
		Time.add(dayTf);
		Time.add(new JLabel("일 "));
		JButton setTime = new JButton("날짜설정");
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
				System.out.println("입력받은 년 월 일: " + year + " / " + month + " / " + day);
				// year month day row col 모두 입력되어있을경우 가능시간대 갱신
				if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
					int[] time;
					time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
					for (int i = 0; i < time.length; i++) {
						if (time[i] == 1) {
							// System.out.println((i+1) +"번 시간대는 가능합니다");
							// i번대의 예약가능버튼을 가능하다고 표시
							isCan[i].setText("가능");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.GREEN);
						} else if (time[i] == 0) {
							isCan[i].setText("불가능");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.RED);
						}
					}
				}
			}

		});
		Time.add(setTime);
		C.add(Time, BorderLayout.NORTH);

		// 좌석 패널
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
						// 클릭하면 row와 col을 해당 좌석의 행과 열로 set하는 이벤트핸들러
						row = input_row;
						col = input_col;
						// System.out.println("입력받은 행/렬 : " + row + "," + col);

						// year month day row col 모두 입력되어있을경우 가능시간대 갱신
						if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
							int[] time;
							time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
							for (int i = 0; i < time.length; i++) {
								if (time[i] == 1) {
									// System.out.println((i+1) +"번 시간대는 가능합니다");
									// i번대의 예약가능버튼을 가능하다고 표시
									isCan[i].setText("가능");
									isCan[i].setOpaque(true);
									isCan[i].setBackground(Color.GREEN);
								} else if (time[i] == 0) {
									isCan[i].setText("불가능");
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

		// 가능시간대 패널
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

		// 액션리스너추가 =>클릭하면 대화상자 생성
		for (int i = 0; i < canTime.length; i++) {
			int start = i + 9;
			int finish = start + 1;
			canTime[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					int result = JOptionPane.showConfirmDialog(null, "이시간대로 예약하겠습니까?", "최종예약",
							JOptionPane.OK_CANCEL_OPTION);

					if (result == 0) { // OK=0 , Cancel=2 리턴
						/*
						System.out.println(year);
						System.out.println(month);
						System.out.println(day);
						System.out.println(row);
						System.out.println(col);
						System.out.println(start);
						System.out.println(finish);
						*/
						
						//예약생성함
						Manager.MakeReserve_GUI(year, month, day, row, col, start, finish);
					}

					// year month day row col 모두 입력되어있을경우 가능시간대 갱신
					if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
						int[] time;
						time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
						for (int i = 0; i < time.length; i++) {
							if (time[i] == 1) {
								// System.out.println((i+1) +"번 시간대는 가능합니다");
								// i번대의 예약가능버튼을 가능하다고 표시
								isCan[i].setText("가능");
								isCan[i].setOpaque(true);
								isCan[i].setBackground(Color.GREEN);
							} else if (time[i] == 0) {
								isCan[i].setText("불가능");
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
			isCan[i] = new JLabel("좌석선택필요");
		}

		for (int i = 0; i < canTime.length; i++) {
			CanTime.add(canTime[i]);
			CanTime.add(isCan[i]);
		}

		C.add(CanTime, BorderLayout.AFTER_LINE_ENDS);

		// 예약완료 버튼
		JButton exit = new JButton("예약완료");
		exit.addActionListener(this);
		C.add(exit, BorderLayout.SOUTH);

		pack();

	}
	
	/*
	// 윈도우 종료 클래스
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // 윈도 종료
		}
	}
	*/

	// 예약완료 버튼클릭 이벤트 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("예약완료")) {
			new FirstFrame();
			this.setVisible(false);
		}
	}

}// 예약 프레임 끝

//보기&취소 프레임
class CancleFrame extends JFrame implements ActionListener {
	JTextField yearTf;
	JTextField monthTf;
	JTextField dayTf;

	int year, month, day, row, col; // 예약가능시간을 출력하기위한 인자들

	JLabel[] isCan; // 시간대의 유효성을 표현하기 위한 라벨

	CancleFrame() {
		super("예약보기&취소");
		setVisible(true);
		setLocation(0, 0);

		addWindowListener(new MyWinExit());

		// 컨테이너 생성
		Container C = getContentPane();

		// 년월일 패널

		JPanel Time = new JPanel();
		Time.setLayout(new FlowLayout());

		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		String cur_Year = Integer.toString(year);
		String cur_Month = Integer.toString(month);
		String cur_Day = Integer.toString(day);

		int Year_set, Month_set, Day_set; // 버튼 누를시 받아진 년월일값

		yearTf = new JTextField(cur_Year, 4);
		monthTf = new JTextField(cur_Month, 2);
		dayTf = new JTextField(cur_Day, 2);
		Time.add(yearTf);
		Time.add(new JLabel("년"));
		Time.add(monthTf);
		Time.add(new JLabel("월 "));
		Time.add(dayTf);
		Time.add(new JLabel("일 "));
		JButton setTime = new JButton("날짜설정");
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
				System.out.println("입력받은 년 월 일: " + year + " / " + month + " / " + day);
				// year month day row col 모두 입력되어있을경우 가능시간대 갱신
				if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
					int[] time;
					time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
					for (int i = 0; i < time.length; i++) {
						if (time[i] == 1) {
							// System.out.println((i+1) +"번 시간대는 가능합니다");
							// i번대의 예약가능버튼을 가능하다고 표시
							isCan[i].setText("예약없음");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.GRAY);
						} else if (time[i] == 0) {
							isCan[i].setText("예약있음");
							isCan[i].setOpaque(true);
							isCan[i].setBackground(Color.CYAN);
						}
					}
				}

			}

		});
		Time.add(setTime);
		C.add(Time, BorderLayout.NORTH);

		// 좌석 패널
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
						// 클릭하면 row와 col을 해당 좌석의 행과 열로 set하는 이벤트핸들러
						row = input_row;
						col = input_col;
						// System.out.println("입력받은 행/렬 : " + row + "," + col);

						// year month day row col 모두 입력되어있을경우 가능시간대 갱신
						if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
							int[] time;
							time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
							for (int i = 0; i < time.length; i++) {
								if (time[i] == 1) {
									// System.out.println((i+1) +"번 시간대는 가능합니다");
									// i번대의 예약가능버튼을 가능하다고 표시
									isCan[i].setText("예약없음");
									isCan[i].setOpaque(true);
									isCan[i].setBackground(Color.GRAY);
								} else if (time[i] == 0) {
									isCan[i].setText("예약있음");
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

		// 가능시간대 패널
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

		// 액션리스너추가 =>클릭하면 대화상자 생성
		for (int i = 0; i < canTime.length; i++) {
			int start = i + 9;
			int finish = start + 1;
			canTime[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					int result = JOptionPane.showConfirmDialog(null, "이 예약을 취소하겠습니까?", "최종확인",
							JOptionPane.OK_CANCEL_OPTION);

					if (result == 0) { // OK=0 , Cancel=2 리턴
						/*
						System.out.println(year);
						System.out.println(month);
						System.out.println(day);
						System.out.println(row);
						System.out.println(col);
						System.out.println(start);
						System.out.println(finish);
						*/
						// 취소하는 함수
						Manager.DeleteReserve_GUI(year, month, day, row, col, start, finish);
					}

					// year month day row col 모두 입력되어있을경우 가능시간대 갱신
					if (year != 0 && month != 0 && day != 0 && row != 0 && col != 0) {
						int[] time;
						time = Manager.ShowReserve_ToMake_GUI(year, month, day, row, col);
						for (int i = 0; i < time.length; i++) {
							if (time[i] == 1) {
								// System.out.println((i+1) +"번 시간대는 가능합니다");
								// i번대의 예약가능버튼을 가능하다고 표시
								isCan[i].setText("예약없음");
								isCan[i].setOpaque(true);
								isCan[i].setBackground(Color.GRAY);
							} else if (time[i] == 0) {
								isCan[i].setText("예약있음");
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
			isCan[i] = new JLabel("좌석선택필요");
			isCan[i].setOpaque(true);
		}

		for (int i = 0; i < canTime.length; i++) {
			CanTime.add(canTime[i]);
			CanTime.add(isCan[i]);
		}

		C.add(CanTime, BorderLayout.AFTER_LINE_ENDS);

		// 예약완료 버튼
		JButton exit = new JButton("취소완료");
		exit.addActionListener(this);
		C.add(exit, BorderLayout.SOUTH);

		pack();

	}

	/*
	// 윈도우 종료 클래스
	public class MyWinExit extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // 윈도 종료
		}
	}
	*/

	// 예약완료 버튼클릭 이벤트 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("취소완료")) {
			new FirstFrame();
			this.setVisible(false);
		}
	}

}// 세 번째 프레임 끝

//메인 함수
public class FrameChanger {
	public static void main(String[] args) {
		new FirstFrame();
	}
}
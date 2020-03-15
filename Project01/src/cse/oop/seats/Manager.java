package cse.oop.seats;

import java.util.Scanner;

public class Manager {
	static int ReserveCount = 0;
	static Reservation R[] = new Reservation[100]; // ���డ���� ���� �ִ� �Ǽ��� 100���� ����
	static Scanner in = new Scanner(System.in);

	public static void MakeReserve() {
		int row, col;
		int year, month, day, hour, min;
		boolean valid;

		// �¼�
		while (true) {
			System.out.println("Enter Seat info! ex)row col .... 3 5 =>3�� 5��");
			row = in.nextInt();
			col = in.nextInt();
			valid = Seat.checkValidity(row, col);
			if (valid == false) {
				System.out.println("Error: enter Seat info again!");
			} else {
				Seat s = new Seat(row, col);
				// ���۽ð�
				while (true) {
					System.out.println("Enter start time info!");
					year = in.nextInt();
					month = in.nextInt();
					day = in.nextInt();
					hour = in.nextInt();
					min = in.nextInt();
					valid = Time.checkValidity(year, month, day, hour, min);
					if (valid == false)
						System.out.println("Error: enter time info again!");
					else {
						Time st = new Time(year, month, day, hour, min);
						// ����ð�
						while (true) {
							System.out.println("Enter finish time info!");
							year = in.nextInt();
							month = in.nextInt();
							day = in.nextInt();
							hour = in.nextInt();
							min = in.nextInt();
							valid = Time.checkValidity(year, month, day, hour, min);
							if (valid == false)
								System.out.println("Error: enter time info again!");
							else {
								Time ft = new Time(year, month, day, hour, min);
								if (st.getDay() != ft.getDay() || st.getYear() != ft.getYear()
										|| st.getMonth() != ft.getMonth()) {
									System.out.println("���� : ���۽ð��� ����ð��� ��¥�� �������� �ʽ��ϴ�!!");

								} else {
									/* �̺κп� ��ġ�� �ð� �������� �Լ� �߰��ؾߵ� */
									for (int i = 0; i < ReserveCount; i++) {
										if (!R[i].isNull() && R[i].Start.getYear() == st.getYear()
												&& R[i].Start.getMonth() == st.getMonth()
												&& R[i].Start.getDay() == st.getDay()) {
											// ��� ���� ������ �ش� �¼��� ���������� ��¥�� ���೯¥�� �����Ұ��
											if (st.getOnlyhour() > R[i].Start.getOnlyhour()
													&& st.getOnlyhour() < R[i].Finish.getOnlyhour()) {
												System.out.println("���۽ð��� �ٸ� ���౸���� �߰��� �ֽ��ϴ�!! �޴��� �̵��մϴ�");
												return;
											}
											if (ft.getOnlyhour() > R[i].Start.getOnlyhour()
													&& st.getOnlyhour() < R[i].Finish.getOnlyhour()) {
												System.out.println("����ð��� �ٸ� ���౸���� �߰��� �ֽ��ϴ�!! �޴��� �̵��մϴ�");
												return;
											}
										}
									}
									// Reservation ����
									Reservation r = new Reservation(s, st, ft);
									R[ReserveCount] = r;
									ReserveCount++;
									return;
								}

							}

						}
					}

				}

			}
		}

	}

	public static void DeleteReserve() {
		Reservation tempR[] = new Reservation[100];
		int row, col, indexNum;
		indexNum = 1;
		System.out.println("����� �¼���ȣ�� �Է��ϼ���!");
		row = in.nextInt();
		col = in.nextInt();
		if (Seat.checkValidity(row, col)) {

			System.out.println("���� ��Ȳ�Դϴ� �Ʒ����� ����� ���� ��ȣ�� �Է��ϼ���!");
			for (int i = 0; i < ReserveCount; i++) { // ��� ���� ������ �ش� �¼��� ���������� ���
				if (!R[i].isNull() && R[i].position.getRow() == row && R[i].position.getCol() == col) {
					System.out.println(indexNum + ". " + R[i].Start.toString() + " ~ " + R[i].Finish.toString());
					tempR[indexNum] = R[i];
					indexNum++;
				}
			}
			indexNum = 0;
			System.out.println("\n ����� �����ȣ:");

			indexNum = in.nextInt();
			for (int i = 0; i < ReserveCount; i++) { // ��� ���� ������ ������ ���������� ����
				if (tempR[indexNum] == R[i]) {
					R[i].setNull();
					indexNum++;
				}
			}
			System.out.println("������ ��ҵǾ����ϴ�!");
			return;
		} 
		else {
			System.out.println("�߸��� �¼� ������ �Է��߽��ϴ�.\n �޴��� �̵��մϴ�");
			return;
		}
	}

	public static void ShowReserve() {
		for (int i = 0; i < ReserveCount; i++) {
			if (!R[i].isNull())
				System.out.println(R[i].toString());
		}
	}

}

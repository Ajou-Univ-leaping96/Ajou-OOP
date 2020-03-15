/*
package cse.oop.seats;

import java.util.Scanner;

public class ReservationTest {

	public static void main(String[] args) {
		int row, col;
		int year, month, day, hour, min;
		boolean valid;

		while (true) {
			Scanner in = new Scanner(System.in);
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
					System.out.println(s.toString());
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
							System.out.println(st.toString());
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
									System.out.println(ft.toString());
									if (st.getDay() != ft.getDay() || st.getYear() != ft.getYear()
											|| st.getMonth() != ft.getMonth()) {
										System.out.println("���� : ���۽ð��� ����ð��� ��¥�� �������� �ʽ��ϴ�!!");
									} else {
										// Reservation ����
										Reservation r = new Reservation(s.toString(), st.toDate(), st.getReserveTime(), ft.getReserveTime());
										System.out.println(r.toString());
										return ;
									}

								}

							}
						}

					}

				}
			}

		}

	}
}
*/

package cse.oop.seats;

import java.util.Scanner;

public class Manager {
	static int ReserveCount = 0;
	static Reservation R[] = new Reservation[100]; // 예약가능한 누적 최대 건수를 100개로 가정
	static Scanner in = new Scanner(System.in);

	public static void MakeReserve() {
		int row, col;
		int year, month, day, hour, min;
		boolean valid;

		// 좌석
		while (true) {
			System.out.println("Enter Seat info! ex)row col .... 3 5 =>3행 5열");
			row = in.nextInt();
			col = in.nextInt();
			valid = Seat.checkValidity(row, col);
			if (valid == false) {
				System.out.println("Error: enter Seat info again!");
			} else {
				Seat s = new Seat(row, col);
				// 시작시간
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
						// 종료시간
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
									System.out.println("에러 : 시작시간과 종료시간의 날짜가 동일하지 않습니다!!");

								} else {
									/* 이부분에 겹치는 시간 에러검출 함수 추가해야됨 */
									for (int i = 0; i < ReserveCount; i++) {
										if (!R[i].isNull() && R[i].Start.getYear() == st.getYear()
												&& R[i].Start.getMonth() == st.getMonth()
												&& R[i].Start.getDay() == st.getDay()) {
											// 모든 예약 정보중 해당 좌석의 예약정보와 날짜가 예약날짜와 동일할경우
											if (st.getOnlyhour() > R[i].Start.getOnlyhour()
													&& st.getOnlyhour() < R[i].Finish.getOnlyhour()) {
												System.out.println("시작시간이 다른 예약구간의 중간에 있습니다!! 메뉴로 이동합니다");
												return;
											}
											if (ft.getOnlyhour() > R[i].Start.getOnlyhour()
													&& st.getOnlyhour() < R[i].Finish.getOnlyhour()) {
												System.out.println("종료시간이 다른 예약구간의 중간에 있습니다!! 메뉴로 이동합니다");
												return;
											}
										}
									}
									// Reservation 생성
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
		System.out.println("취소할 좌석번호를 입력하세요!");
		row = in.nextInt();
		col = in.nextInt();
		if (Seat.checkValidity(row, col)) {

			System.out.println("예약 현황입니다 아래에서 취소할 예약 번호를 입력하세요!");
			for (int i = 0; i < ReserveCount; i++) { // 모든 예약 정보중 해당 좌석의 예약정보만 출력
				if (!R[i].isNull() && R[i].position.getRow() == row && R[i].position.getCol() == col) {
					System.out.println(indexNum + ". " + R[i].Start.toString() + " ~ " + R[i].Finish.toString());
					tempR[indexNum] = R[i];
					indexNum++;
				}
			}
			indexNum = 0;
			System.out.println("\n 취소할 예약번호:");

			indexNum = in.nextInt();
			for (int i = 0; i < ReserveCount; i++) { // 모든 예약 정보중 선택한 예약정보만 삭제
				if (tempR[indexNum] == R[i]) {
					R[i].setNull();
					indexNum++;
				}
			}
			System.out.println("예약이 취소되었습니다!");
			return;
		} else {
			System.out.println("잘못된 좌석 정보를 입력했습니다.\n 메뉴로 이동합니다");
			return;
		}
	}

	public static void ShowReserve() {
		for (int i = 0; i < ReserveCount; i++) {
			if (!R[i].isNull())
				System.out.println(R[i].toString());
		}
	}

	// 년월일 행렬 가지고 예약가능시간대 출력함수
	public static int[] ShowReserve_ToMake_GUI(int year, int month, int day, int row, int col) {
		int[] time = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		for (int i = 0; i < ReserveCount; i++) { // 모든 예약 정보중 해당 좌석의 예약정보를 확인
			if (!R[i].isNull() && R[i].position.getRow() == row && R[i].position.getCol() == col) {

				// 해당 날짜의 예약정보로 일c축
				if (R[i].Start.getYear() == year && R[i].Start.getMonth() == month && R[i].Start.getDay() == day) {
					// 총 8가지의 시간대를 검사, 가능하면 1 불가능이면 0으로 표시
					for (int num = 0, criteria = 9; num < 9; num++, criteria++) {
						if (R[i].Start.getOnlyhour() == criteria && R[i].Finish.getOnlyhour() == criteria + 1) {
							time[num] = 0;
						}
					}
				}

			}
		}
		return time; // time이라는 배열이 가능시간대의 표현이다.
	}

	// 년월일 행렬 + 가능시간대로 예약생성함수
	public static void MakeReserve_GUI(int year, int month, int day, int row, int col, int start, int finish) {
		int min = 0;
		boolean valid;
		valid = Seat.checkValidity(row, col);
		if (valid == false) {
			System.out.println("좌석입력 오류로 예약을 생성할수없습니다");
			return;
		}
		valid = Time.checkValidity(year, month, day, start, min);
		if (valid == false) {
			System.out.println("시작시간 오류로 예약을 생성할수 없습니다");
			return;
		}
		valid = Time.checkValidity(year, month, day, finish, min);
		if (valid == false) {
			System.out.println("종료시간 오류로 예약을 생성할수 없습니다");
			return;
		}
		// 좌석
		Seat s = new Seat(row, col);
		// 시작시간
		Time st = new Time(year, month, day, start, min);
		// 종료시간
		Time ft = new Time(year, month, day, finish, min);
		// Reservation 생성
		Reservation r = new Reservation(s, st, ft);
		R[ReserveCount] = r;
		ReserveCount++;
		// System.out.println("예약생성완료");
		return;

	}

// 년월일 행렬 가지고 취소가능시간대 출력함수 => 예약show를 비틀면되어서 안만들어도된다

// 년월일 행렬 + 시간으로 예약취소함수
	public static void DeleteReserve_GUI(int year, int month, int day, int row, int col, int start, int finish) {
		
		int min =0;
		
		boolean valid = Seat.checkValidity(row, col);
		if (valid == false) {
			System.out.println("좌석입력 오류로 예약을 생성할수없습니다");
			return;
		}
		valid = Time.checkValidity(year, month, day, start, min);
		if (valid == false) {
			System.out.println("시작시간 오류로 예약을 생성할수 없습니다");
			return;
		}
		valid = Time.checkValidity(year, month, day, finish, min);
		if (valid == false) {
			System.out.println("종료시간 오류로 예약을 생성할수 없습니다");
			return;
		}

		Reservation tempR[] = new Reservation[100];
		for (int i = 0; i < ReserveCount; i++) { // 모든 예약 정보중 해당 좌석의 예약정보를 확인
			if (!R[i].isNull() && R[i].position.getRow() == row && R[i].position.getCol() == col) {

				// 해당 날짜와 시간의 예약정보로 일축 =>1개만 찾는다
				if (R[i].Start.getYear() == year && R[i].Start.getMonth() == month && R[i].Start.getDay() == day
						&& R[i].Start.getOnlyhour() == start && R[i].Finish.getOnlyhour() == finish) {
					R[i].setNull();
					// System.out.println("예약삭제 완료");

				}

			}
		}

	}

}

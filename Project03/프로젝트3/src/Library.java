import java.util.Scanner;
import cse.oop.seats.*;

public class Library {
// java > util > DateTime ....에 있는거를 가져다가 여기에 둬!

	// Manager m = new Manager();

	public static void main(String[] args) {
		while (true) {
			int select;
			System.out.printf("================================== \n");
			System.out.printf("수행할 작업을 선택하세요 : \n\n");
			System.out.printf("1. 좌석 예약하기 \n\n");
			System.out.printf("2. 예약 취소하기\n\n");
			System.out.printf("3. 전체 예약보기\n\n");
			System.out.printf("4. 종료\n");
			System.out.printf("================================== \n");
			Manager m = new Manager();
			Scanner in = new Scanner(System.in);
			select = in.nextInt();
			switch (select) {
			case 1: //예약추가 기능
				Manager.MakeReserve();
				continue;
			case 2: //예약삭제 기능
				Manager.DeleteReserve();
				continue;
			case 3: // 전체출력 기능
				Manager.ShowReserve();
				continue;
			case 4: // 프로그램 종료 기능
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				continue;
			}

		}
	}
}

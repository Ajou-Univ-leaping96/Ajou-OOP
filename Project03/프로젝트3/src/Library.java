import java.util.Scanner;
import cse.oop.seats.*;

public class Library {
// java > util > DateTime ....�� �ִ°Ÿ� �����ٰ� ���⿡ ��!

	// Manager m = new Manager();

	public static void main(String[] args) {
		while (true) {
			int select;
			System.out.printf("================================== \n");
			System.out.printf("������ �۾��� �����ϼ��� : \n\n");
			System.out.printf("1. �¼� �����ϱ� \n\n");
			System.out.printf("2. ���� ����ϱ�\n\n");
			System.out.printf("3. ��ü ���ຸ��\n\n");
			System.out.printf("4. ����\n");
			System.out.printf("================================== \n");
			Manager m = new Manager();
			Scanner in = new Scanner(System.in);
			select = in.nextInt();
			switch (select) {
			case 1: //�����߰� ���
				Manager.MakeReserve();
				continue;
			case 2: //������� ���
				Manager.DeleteReserve();
				continue;
			case 3: // ��ü��� ���
				Manager.ShowReserve();
				continue;
			case 4: // ���α׷� ���� ���
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
			}

		}
	}
}

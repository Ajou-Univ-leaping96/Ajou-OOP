package project02;

public class AccessTable {

	public final int MAX_DATA = 1000;
	public AccessData[] Table = new AccessData[MAX_DATA];
	private int count = 0;

	public AccessTable(String root) {
		AccessData ad = new AccessData(root, 3);
		Table[0] = ad;
		count++;
	}

	// �����Լ�
	public void insert(String path, int mode) {
		AccessData ad = new AccessData(path, mode);
		Table[count] = ad;
		count++;
	}

	// ���� �Լ�
	public void delete(String path) {
		for(int i=0; i<count; i++) {
			if(Table[i].getPath().equals(path)) {
				Table[i].setPath(" ");
				Table[i].setMode(3);
			}
		}
	}
	
	//���ٱ����� �ٲ��ִ� �Լ�
	public void chAccess(String path, int mode) {
		for(int i=0; i<count; i++) {
			if(Table[i].getPath().equals(path)) {
				Table[i].setMode(mode);
				System.out.println("��庯�� �Ϸ�");
				return;
			}
		}
		System.out.println("��庯�� ����");
	}
	
	//������ �������� ã���ִ� �Լ�
	public int searchAccess(String path) {
		for(int i=0; i<count; i++) {
			if(Table[i].getPath().equals(path)) {
				return Table[i].getMode();
			}
		}
		return 0;
	}
	

	//�б������ �ִ��� Ȯ���ϴ��Լ�
	public boolean check_R(String path) {
			for(int i=0; i<count; i++) {
			if(Table[i].getMode() ==3 || Table[i].getMode()  ==1 )
				return true;
		}
		return false;
	}
	

	//��������� �ִ��� Ȯ���ϴ��Լ�
	public boolean check_W(String path) {
		for(int i=0; i<count; i++) {
			if(Table[i].getMode()== 3 || Table[i].getMode() == 2)
				return true;
		}
		return false;
	}


}

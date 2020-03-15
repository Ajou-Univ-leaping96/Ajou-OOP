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

	// 삽입함수
	public void insert(String path, int mode) {
		AccessData ad = new AccessData(path, mode);
		Table[count] = ad;
		count++;
	}

	// 삭제 함수
	public void delete(String path) {
		for(int i=0; i<count; i++) {
			if(Table[i].getPath().equals(path)) {
				Table[i].setPath(" ");
				Table[i].setMode(3);
			}
		}
	}
	
	//접근권한을 바꿔주는 함수
	public void chAccess(String path, int mode) {
		for(int i=0; i<count; i++) {
			if(Table[i].getPath().equals(path)) {
				Table[i].setMode(mode);
				System.out.println("모드변경 완료");
				return;
			}
		}
		System.out.println("모드변경 오류");
	}
	
	//권한이 무엇인지 찾아주는 함수
	public int searchAccess(String path) {
		for(int i=0; i<count; i++) {
			if(Table[i].getPath().equals(path)) {
				return Table[i].getMode();
			}
		}
		return 0;
	}
	

	//읽기권한이 있는지 확인하는함수
	public boolean check_R(String path) {
			for(int i=0; i<count; i++) {
			if(Table[i].getMode() ==3 || Table[i].getMode()  ==1 )
				return true;
		}
		return false;
	}
	

	//쓰기권한이 있는지 확인하는함수
	public boolean check_W(String path) {
		for(int i=0; i<count; i++) {
			if(Table[i].getMode()== 3 || Table[i].getMode() == 2)
				return true;
		}
		return false;
	}


}

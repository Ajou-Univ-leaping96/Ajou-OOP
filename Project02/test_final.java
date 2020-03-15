package project02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test_final {
	static AccessTable Access;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String root_path = "C:\\test\\"; // 루트 폴더 주소

		File root = new File(root_path); // 루트 폴더 객체
		root.mkdir(); // 루트폴더 생성
		Access = new AccessTable(root_path); // 접근권한 테이블 생성, 루트폴더는 +rw로 초기설정

		String cwd_path = root_path; // 현재 폴더를 루트로 설정

		// 무한반복부
		while (true) {
			System.out.printf("%% ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받는 객체
			StringTokenizer st = new StringTokenizer(br.readLine()); // 한문장 입력받음
			// 띄어쓰기에 따라 최대 4개 입력으로 나눈다
			String args_0 = st.nextToken(); // 최소 1개입력
			String args_1 = null;
			String args_2 = null;
			String args_3 = null;

			if (st.hasMoreTokens()) {
				args_1 = st.nextToken();
			}
			if (st.hasMoreTokens()) {
				args_2 = st.nextToken();
			}
			if (st.hasMoreTokens()) {
				args_3 = st.nextToken();
			}

			// 1. 일반파일 생성
			if (args_0.equals("new")) {

				// 현재 작업폴더가 쓰기권한 있는지 확인
				if (!Access.check_W(cwd_path)) {
					System.out.println("현재 폴더가 쓰기권한이 없습니다.");
					continue;
				}

				String access = args_1; // 권한
				String name = args_2; // 파일이름
				String content = args_3; // 쓸내용

				try {
					File file = new File(cwd_path + name); // 파일객체

					// 파일생성
					file.createNewFile();

					// writer 객체
					FileWriter fw = new FileWriter(file, true);

					// content를 파일에다 쓴다
					fw.write(content);
					fw.flush();
					fw.close();

					// 권한테이블에 추가
					int mode = AccessToMode(access);
					Access.insert(cwd_path + name, mode);

					System.out.println("파일생성 성공. ( 경로 " + cwd_path + " ) ");

				} catch (IOException e) {
					System.out.println("파일 생성 에러");
				}

			}
			// 2. 파일/디렉토리 삭제
			else if (args_0.equals("del")) {

				// 현재 작업폴더가 쓰기권한 있는지 확인
				if (!Access.check_W(cwd_path)) {
					System.out.println("현재 폴더가 쓰기권한이 없습니다.");
					continue;
				}
				File cwd = new File(cwd_path); // 현재폴더 객체 생성
				File[] List = cwd.listFiles(); // 현재폴더 리스트 작성
				String name = args_1; // 지울파일이름
				File file = new File(cwd_path + name);// 지울파일객체 생성
				if (file.exists()) { // 파일존재여부확인
					if (file.isDirectory()) { // 파일이 폴더면
						deleteFolder(file.getPath());
						System.out.println(file.getPath() + " 폴더삭제 완료");
					} else {
						file.delete();
						System.out.println(file.getPath() + " 파일삭제 완료");
					}

				} else
					System.out.println("파일이 존재하지 않습니다.");
			}

			// 3. 디레토리 생성
			else if (args_0.equals("mkdir")) {

				// 현재 작업폴더가 쓰기권한 있는지 확인
				if (!Access.check_W(cwd_path)) {
					System.out.println("현재 폴더가 쓰기권한이 없습니다.");
					continue;
				}

				String access = args_1; // 권한
				String name = args_2; // 폴더이름
				File dir = new File(cwd_path + name); // 폴더객체

				if (!dir.exists()) {// 폴더가 이미 존재하지 않을경우
					try {
						dir.mkdir(); // 폴더 생성
						System.out.println("폴더가 생성되었습니다.");
						// 권한테이블에 추가
						int mode = AccessToMode(access);
						Access.insert(cwd_path + name, mode);

					} catch (Exception e) {
						e.getStackTrace();
					}
				} else {
					System.out.println("이미 폴더가 생성되어 있습니다.");
				}

			}
			
			// 4. 파일/디렉토리 보기
						else if (args_0.equals("show")) {

							// 현재 작업폴더가 쓰기권한 있는지 확인
							if (!Access.check_R(cwd_path)) {
								System.out.println("현재 폴더가 읽기권한이 없습니다.");
								continue;
							}
							String name = args_1;
							File showen = new File(cwd_path + name);
							
							if (!showen.isDirectory()) { // 파일일 경우
								File cwd = new File(cwd_path);
								File[] fileList = cwd.listFiles();
								for (int i = 0; i < fileList.length; i++) {
									File f = fileList[i];
									if (f.getName().equals(name)) {
										if (f.exists()) {
											try {
												Scanner reader = new Scanner(f);
												while (reader.hasNextLine()) {
													System.out.println(reader.nextLine());
												}

											} catch (FileNotFoundException e) {
												// TODO: handle exception
											}
											break;
										}
									}
									if (i == fileList.length) {
										System.out.println("문서가 없습니다.");
										break;
									}
								}
							}
							else { // 폴더일경우
								System.out.println("==문서 리스트를 출력합니다.==");
								System.out.println("파일명          권한");

								File[] dirList = showen.listFiles();

								for (int i = 0; i < dirList.length; i++) {
									File f = dirList[i];
									if (f.isFile()) {// 파일이 있다면 파일 이름 출력
										System.out.printf("%-15s %-15s \n", f.getName(), Access.searchAccess(cwd_path + f.getName()));
									}
								}
								if (dirList.length < 1) {
									System.out.println("문서가 없습니다.");
								}
							}
						}
			
			// 5. 디렉토리 이동(하위 또는 상위)
						else if(args_0.equals("chdir")) {
							File cwd = new File(cwd_path);
							//부모폴더로 이동
							if(args_1.equals(".."))
								
								cwd_path = cwd.getParent();
							//자식폴더로 이동
							else {
								String child = args_1;
								File[] fileList = cwd.listFiles();
								for (int i = 0; i < fileList.length; i++) {
									File f = fileList[i];
									if (f.isDirectory() && f.getName().equals(child)) {
										cwd_path = cwd_path+child+"\\";
									}
								}
							}
							
						}

			// 6. 파일의 접근권한 설정
			else if (args_0.equals("chmod")) {
				String access = args_1;
				String name = args_2;
				int mode = AccessToMode(access);
				Access.chAccess(cwd_path + name, mode);

			}

			// 7. 현재 작업 디레토리 위치보기
			else if (args_0.equals("cwd")) {
				System.out.println("현재폴더의 경로는 : " + cwd_path + "  입니다");
			}

			// 8. 현재 디렉토리의 파일목록 출력
			else if (args_0.equals("ls")) {
				File cwd = new File(cwd_path); // 현재폴더 객체 생성
				File[] List = cwd.listFiles(); // 현재폴더 파일리스트 작성
				System.out.println("==현재폴더 리스트를 출력합니다.==");
				for (int i = 0; i < List.length; i++) {
					File f = List[i];
					if (f.isFile()) {// 파일이 있다면 파일 이름 출력
						System.out.printf("%-15s %-15s\n", f.getName(),
								ModeToAccess(Access.searchAccess(cwd_path + f.getName())));
					} else if (f.isDirectory()) {// 폴더라면 폴더출력
						System.out.printf("%-15s %-15s <폴더>\n", f.getName(),
								ModeToAccess(Access.searchAccess(cwd_path + f.getName())));
					}
				}
				if (List.length < 1) {
					System.out.println("문서가 없습니다.");
				}
			}

			// 9. 프로그램 종료
			else if (args_0.equals("exit")) {
				break;
			}

			// 작업중

		}
		System.out.println("--시스템 종료--");
	}

	// 폴더삭제 메소드
	public static void deleteFolder(String path) {

		File folder = new File(path);
		try {
			if (folder.exists()) {
				File[] folder_list = folder.listFiles(); // 파일리스트 얻어오기

				for (int i = 0; i < folder_list.length; i++) {
					if (folder_list[i].isFile()) {
						folder_list[i].delete();
						System.out.println(folder_list[i].getPath() + " 삭제되었습니다.");
					} else {
						deleteFolder(folder_list[i].getPath()); // 재귀함수호출
						System.out.println(folder_list[i].getPath() + " 삭제되었습니다.");
					}
					folder_list[i].delete();
				}
				folder.delete(); // 폴더 삭제
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// 모드숫자를 access문자열로 바꾸는 메소드
	// 예시) 3 => +rw
	public static String ModeToAccess(int mode) {
		if (mode == 1)
			return "+r";
		else if (mode == 2)
			return "+w";
		else if (mode == 3)
			return "+rw";
		else
			System.out.println("비트에러");
		return "null";
	}

	// access문자를 mode숫자로 바꾸는 메소드
	public static int AccessToMode(String access){
		if (access.equals("+r"))
			return 1;
		else if (access.equals("+w"))
			return 2;
		else if (access.equals("+rw"))
			return 3;
		else 
			System.out.println("모드에러");
		return 0;
		
	}

}

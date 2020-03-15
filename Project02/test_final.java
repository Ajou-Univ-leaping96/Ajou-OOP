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
		String root_path = "C:\\test\\"; // ��Ʈ ���� �ּ�

		File root = new File(root_path); // ��Ʈ ���� ��ü
		root.mkdir(); // ��Ʈ���� ����
		Access = new AccessTable(root_path); // ���ٱ��� ���̺� ����, ��Ʈ������ +rw�� �ʱ⼳��

		String cwd_path = root_path; // ���� ������ ��Ʈ�� ����

		// ���ѹݺ���
		while (true) {
			System.out.printf("%% ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // �Է¹޴� ��ü
			StringTokenizer st = new StringTokenizer(br.readLine()); // �ѹ��� �Է¹���
			// ���⿡ ���� �ִ� 4�� �Է����� ������
			String args_0 = st.nextToken(); // �ּ� 1���Է�
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

			// 1. �Ϲ����� ����
			if (args_0.equals("new")) {

				// ���� �۾������� ������� �ִ��� Ȯ��
				if (!Access.check_W(cwd_path)) {
					System.out.println("���� ������ ��������� �����ϴ�.");
					continue;
				}

				String access = args_1; // ����
				String name = args_2; // �����̸�
				String content = args_3; // ������

				try {
					File file = new File(cwd_path + name); // ���ϰ�ü

					// ���ϻ���
					file.createNewFile();

					// writer ��ü
					FileWriter fw = new FileWriter(file, true);

					// content�� ���Ͽ��� ����
					fw.write(content);
					fw.flush();
					fw.close();

					// �������̺� �߰�
					int mode = AccessToMode(access);
					Access.insert(cwd_path + name, mode);

					System.out.println("���ϻ��� ����. ( ��� " + cwd_path + " ) ");

				} catch (IOException e) {
					System.out.println("���� ���� ����");
				}

			}
			// 2. ����/���丮 ����
			else if (args_0.equals("del")) {

				// ���� �۾������� ������� �ִ��� Ȯ��
				if (!Access.check_W(cwd_path)) {
					System.out.println("���� ������ ��������� �����ϴ�.");
					continue;
				}
				File cwd = new File(cwd_path); // �������� ��ü ����
				File[] List = cwd.listFiles(); // �������� ����Ʈ �ۼ�
				String name = args_1; // ���������̸�
				File file = new File(cwd_path + name);// �������ϰ�ü ����
				if (file.exists()) { // �������翩��Ȯ��
					if (file.isDirectory()) { // ������ ������
						deleteFolder(file.getPath());
						System.out.println(file.getPath() + " �������� �Ϸ�");
					} else {
						file.delete();
						System.out.println(file.getPath() + " ���ϻ��� �Ϸ�");
					}

				} else
					System.out.println("������ �������� �ʽ��ϴ�.");
			}

			// 3. ���丮 ����
			else if (args_0.equals("mkdir")) {

				// ���� �۾������� ������� �ִ��� Ȯ��
				if (!Access.check_W(cwd_path)) {
					System.out.println("���� ������ ��������� �����ϴ�.");
					continue;
				}

				String access = args_1; // ����
				String name = args_2; // �����̸�
				File dir = new File(cwd_path + name); // ������ü

				if (!dir.exists()) {// ������ �̹� �������� �������
					try {
						dir.mkdir(); // ���� ����
						System.out.println("������ �����Ǿ����ϴ�.");
						// �������̺� �߰�
						int mode = AccessToMode(access);
						Access.insert(cwd_path + name, mode);

					} catch (Exception e) {
						e.getStackTrace();
					}
				} else {
					System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
				}

			}
			
			// 4. ����/���丮 ����
						else if (args_0.equals("show")) {

							// ���� �۾������� ������� �ִ��� Ȯ��
							if (!Access.check_R(cwd_path)) {
								System.out.println("���� ������ �б������ �����ϴ�.");
								continue;
							}
							String name = args_1;
							File showen = new File(cwd_path + name);
							
							if (!showen.isDirectory()) { // ������ ���
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
										System.out.println("������ �����ϴ�.");
										break;
									}
								}
							}
							else { // �����ϰ��
								System.out.println("==���� ����Ʈ�� ����մϴ�.==");
								System.out.println("���ϸ�          ����");

								File[] dirList = showen.listFiles();

								for (int i = 0; i < dirList.length; i++) {
									File f = dirList[i];
									if (f.isFile()) {// ������ �ִٸ� ���� �̸� ���
										System.out.printf("%-15s %-15s \n", f.getName(), Access.searchAccess(cwd_path + f.getName()));
									}
								}
								if (dirList.length < 1) {
									System.out.println("������ �����ϴ�.");
								}
							}
						}
			
			// 5. ���丮 �̵�(���� �Ǵ� ����)
						else if(args_0.equals("chdir")) {
							File cwd = new File(cwd_path);
							//�θ������� �̵�
							if(args_1.equals(".."))
								
								cwd_path = cwd.getParent();
							//�ڽ������� �̵�
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

			// 6. ������ ���ٱ��� ����
			else if (args_0.equals("chmod")) {
				String access = args_1;
				String name = args_2;
				int mode = AccessToMode(access);
				Access.chAccess(cwd_path + name, mode);

			}

			// 7. ���� �۾� ���丮 ��ġ����
			else if (args_0.equals("cwd")) {
				System.out.println("���������� ��δ� : " + cwd_path + "  �Դϴ�");
			}

			// 8. ���� ���丮�� ���ϸ�� ���
			else if (args_0.equals("ls")) {
				File cwd = new File(cwd_path); // �������� ��ü ����
				File[] List = cwd.listFiles(); // �������� ���ϸ���Ʈ �ۼ�
				System.out.println("==�������� ����Ʈ�� ����մϴ�.==");
				for (int i = 0; i < List.length; i++) {
					File f = List[i];
					if (f.isFile()) {// ������ �ִٸ� ���� �̸� ���
						System.out.printf("%-15s %-15s\n", f.getName(),
								ModeToAccess(Access.searchAccess(cwd_path + f.getName())));
					} else if (f.isDirectory()) {// ������� �������
						System.out.printf("%-15s %-15s <����>\n", f.getName(),
								ModeToAccess(Access.searchAccess(cwd_path + f.getName())));
					}
				}
				if (List.length < 1) {
					System.out.println("������ �����ϴ�.");
				}
			}

			// 9. ���α׷� ����
			else if (args_0.equals("exit")) {
				break;
			}

			// �۾���

		}
		System.out.println("--�ý��� ����--");
	}

	// �������� �޼ҵ�
	public static void deleteFolder(String path) {

		File folder = new File(path);
		try {
			if (folder.exists()) {
				File[] folder_list = folder.listFiles(); // ���ϸ���Ʈ ������

				for (int i = 0; i < folder_list.length; i++) {
					if (folder_list[i].isFile()) {
						folder_list[i].delete();
						System.out.println(folder_list[i].getPath() + " �����Ǿ����ϴ�.");
					} else {
						deleteFolder(folder_list[i].getPath()); // ����Լ�ȣ��
						System.out.println(folder_list[i].getPath() + " �����Ǿ����ϴ�.");
					}
					folder_list[i].delete();
				}
				folder.delete(); // ���� ����
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// �����ڸ� access���ڿ��� �ٲٴ� �޼ҵ�
	// ����) 3 => +rw
	public static String ModeToAccess(int mode) {
		if (mode == 1)
			return "+r";
		else if (mode == 2)
			return "+w";
		else if (mode == 3)
			return "+rw";
		else
			System.out.println("��Ʈ����");
		return "null";
	}

	// access���ڸ� mode���ڷ� �ٲٴ� �޼ҵ�
	public static int AccessToMode(String access){
		if (access.equals("+r"))
			return 1;
		else if (access.equals("+w"))
			return 2;
		else if (access.equals("+rw"))
			return 3;
		else 
			System.out.println("��忡��");
		return 0;
		
	}

}

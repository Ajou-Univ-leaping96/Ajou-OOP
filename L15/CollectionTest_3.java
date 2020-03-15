package 실습;

// Fig. 16.2: CollectionTest.java
// Collection interface demonstrated via an ArrayList object.
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CollectionTest {

	//배열을 리스트로 전환하는 함수
	public static List<String> mkList(String[] colors) {
		List<String> list = new ArrayList<String>();
		for (String color : colors)
			list.add(color);
		return list;
	}

	//리스트를 받아 중복된 원소가 제거된 리스트를 반환하는 함수
	public static List<String> remove_overlap(List<String> list) {
		Iterator<String> iterator = list.iterator();
		List<String> ModifiedList = new ArrayList<String>(); // 새로운 리스트 생성
		while (iterator.hasNext())// 기존 리스트를 하나씩 훑으면서
		{
			String A = iterator.next();
			// ModifiedList가 가지지 않은 원소만 add한다, 중복된 원소는 자동으로 add안하게됨
			if (!ModifiedList.contains(A))
				ModifiedList.add(A);
		}
		return ModifiedList;// 기존 리스트를 ModifiedList로 대체한다 => 중복이 제거된 리스트로 변경
		// 이런 방법도 있음 return list.stream().distinct().collect(Collectors.toList());
	}
	
	//리스트 원소를 출력하는 함수
	public static void printList(List<String> list) {
				System.out.println("ArrayList: ");

				for (int count = 0; count < list.size(); count++)
					System.out.printf("%s ", list.get(count));
				System.out.println("");
	}
	
	

	public static void main(String[] args) {
		// 1. colors 배열을 초기화 (중복원소 포함)
		String[] colors = { "MAGENTA", "RED", "WHITE", "BLUE", "CYAN", "RED", "GOLD", "SILVER", "PURPLE", "CYAN",
				"MAGENTA" };
		// 2. ﻿colors 배열을 linked list로 변경 
		List<String> list = mkList(colors);

		// 3. ﻿linked list에서 중복 원소를 제거 
		list = remove_overlap(list);
		
		// 4. 결과 list를 출력한다
		printList(list);

		// 5. 결과 list를 정렬한다. (Collections의 sort 알고리즘을 이용한다) 이름순으로 정렬했음
		Collections.sort(list);

		// 6. 정렬된 리스트를 출력한다. => 4번의 함수를 이용
		System.out.println("정렬된 리스트(이름순) : ");
		printList(list);
		
	}
} // end class CollectionTest

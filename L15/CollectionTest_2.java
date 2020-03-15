package 실습;
// Fig. 16.2: CollectionTest.java
// Collection interface demonstrated via an ArrayList object.
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CollectionTest 
{
   public static void main(String[] args)
   {
      //1. colors 배열을 초기화 (중복원소 포함)
      String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN", "RED", "GOLD", "SILVER", "PURPLE", "CYAN", "MAGENTA"};
      
      //2. ﻿colors 배열을 linked list로 변경	=> 추후에 함수화
      List<String> list = new ArrayList<String>();      
      
      for (String color : colors)
         list.add(color); // adds color to end of list      
      
      //3. ﻿linked list에서 중복 원소를 제거	=> 추후 함수화
      Iterator<String> iterator = list.iterator();
      List<String> ModifiedList = new ArrayList<String>(); //새로운 리스트 생성
      while(iterator.hasNext())//기존 리스트를 하나씩 훑으면서
      {
    	  String A = iterator.next();
    	//ModifiedList가 가지지 않은 원소만 add한다, 중복된 원소는 자동으로 add안하게됨
    	  if(!ModifiedList.contains(A))
    			  ModifiedList.add(A);
      }
      list = ModifiedList;//기존 리스트를 ModifiedList로 대체한다 => 중복이 제거된 리스트로 변경
      //이런 방법도 있음list = list.stream().distinct().collect(Collectors.toList());

      //4. 결과 list를 출력한다	=> 추후 함수화
      System.out.println("ArrayList: ");

      for (int count = 0; count < list.size(); count++)
         System.out.printf("%s ", list.get(count));
      System.out.println("");

      //5. 결과 list를 정렬한다. (Collections의 sort 알고리즘을 이용한다) 이름순으로 정렬했음
      Collections.sort(list);
      
      
      //6. 정렬된 리스트를 출력한다. => 4번의 함수를 이용
      System.out.println("정렬된 리스트(이름순) : ");
      for (int count = 0; count < list.size(); count++)    
    	  System.out.printf("%s ", list.get(count));
   }
} // end class CollectionTest

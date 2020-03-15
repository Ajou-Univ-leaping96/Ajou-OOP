public class CardGame
{
	
static int rank[] = new int[52];
static String suit[] = new String[52];

public static void main(String[] args)
{
	
int aRank; // 첫 번째 카드의 값
int bRank; // 두 번째 카드의 값
String aSuit; // 첫 번째 카드의 종류
String bSuit; // 두 번째 카드의 종류
int result; // 비교 값을 저장

String Card1 = null;
String Card2 = null ;


initialize(); //두개 배열을 초기화하는 함수
System.out.println("카드 전체 목록을 출력합니다");
printCards();
shuffle();
System.out.println("\n 셔플완료된 카드 전체 목록을 출력합니다");
printCards();


// A 비교할 카드 두개를 설정하고 assign
System.out.println("\n 셔플이 완료된 상태에서 맨 앞카드와 맨 뒷카드를 비교합니다");
aRank = rank[0];
aSuit = suit[0];
bRank = rank[51];
bSuit = suit[51];

System.out.println("\n" + aSuit + " " + aRank + " VS " + bSuit + " " + bRank);
System.out.println("---------------------------------------------------------\n");
result = compareCards(aRank, aSuit, bRank, bSuit);
// B 비교결과를 출력하는 부분 

if ((aRank == 1 || aRank == 11 || aRank == 12 || aRank == 13 )&& 
(bRank == 1 || bRank == 11 || bRank == 12 || bRank == 13 ))
{
	if (aRank == 1)
		Card1 = "Ace";
	
	if (aRank == 11)
		Card1 = "Jack";
	
	if (aRank == 12)
		Card1 = "Queen";
	
	if (aRank == 13)
		Card1 = "King";
	

	//
	
	if (bRank == 1)
		Card2 = "Ace";
	
	if (bRank == 11)
		Card2 = "Jack";
	
	if (bRank == 12)
		Card2 = "Queen";
	
	if (bRank == 13)
		Card2 = "King";
	
	//
	if(result == 0)	
		System.out.println(Card1 + " of " +aSuit + " wins " + Card2 + " of " + bSuit);

	if(result == 1)
		System.out.println(Card2 + " of " + bSuit+ " wins " + Card1 + " of " + aSuit);
	
}

else if (aRank != 1 && aRank != 11 && aRank != 12 && aRank != 13 && 
(bRank == 1 || bRank == 11 || bRank == 12 || bRank == 13) )
{
	
	if (bRank == 1)
		Card2 = "Ace";
	
	if (bRank == 11)
		Card2 = "Jack";
	
	if (bRank == 12)
		Card2 = "Queen";
	
	if (bRank == 13)
		Card2 = "King";
	
	//
	if(result == 0)	
		System.out.println(aRank + " of " +aSuit + " wins " + Card2 + " of " + bSuit);

	if(result == 1)
		System.out.println(Card2 + " of " + bSuit+ " wins " + aRank + " of " + aSuit);
	
}

else if (bRank != 1 && bRank != 11 && bRank != 12 && bRank != 13 && 
(aRank == 1 || aRank == 11 || aRank == 12 || aRank == 13) )
{
	if (aRank == 1)
		Card1 = "Ace";
	
	if (aRank == 11)
		Card1 = "Jack";
	
	if (aRank == 12)
		Card1 = "Queen";
	
	if (aRank == 13)
		Card1 = "King";
	


	//
	if(result == 0)	
		System.out.println(Card1 + " of " +aSuit + " wins " + bRank + " of " + bSuit);

	if(result == 1)
		System.out.println(bRank + " of " + bSuit+ " wins " + Card1 + " of " + aSuit);
	
}


else
{
	if(result == 0)	
		System.out.println(aRank + " of " +aSuit + " wins " + bRank + " of " + bSuit);

	if(result == 1)
		System.out.println(bRank + " of " + bSuit+ " wins " + aRank + " of " + aSuit);
	
}
	



}

public static void initialize()
{
	
	
	for (int i = 0; i < rank.length; i++) 
		{
		rank[i] = i+1; //배열 rank의 원소에 각각 1부터 52에 해당하는 숫자 순서대로 임시지정
		suit[i] = "Spade"; //suit의 모든 원소를 spade 값으로 임시지정
		}
		
	for(int i =13 ; i <26 ; i++)
		{
		rank[i] = rank[i]-13; //rank[13]~rank[25]에 해당하는 숫자를 1~13으로 수정
		suit[i] = "Diamond"; //suit[13]~rank[25]에 해당하는 문자열을 diamond로 수정
		}
	
	for(int i =26 ; i <39 ; i++)
		{
		rank[i] = rank[i]-26; //rank[26]~rank[38]에 해당하는 숫자를 1~13으로 수정
		suit[i] = "Heart"; //suit[26]~rank[38]에 해당하는 문자열 heart로 수정
		}
	
	for(int i =39 ; i <52 ; i++)
		{
		rank[i] = rank[i]-39; //rank[39]~rank[51]에 해당하는 숫자를 1~13으로 수정
		suit[i] = "Club"; //suit[39]~suit[51]에 해당하는 문자열을 club로 수정
		}

}




public static void shuffle()
{
	int TempRank; //임시rank값
	String TempSuit;//임시suit값
	
	for(int i=0 ; i<rank.length ; i++) //0번째 칸부터 51번째 칸까지의 모든 원소에게 한번씩 실행
	{
	int RandomNum = (int) (Math.random() * 51); //임의의 51 이하의 정수를 RandomNum 에 입력
	
	
	//i번째 칸 원소의 rank와 suit를 임시저장
	TempRank = rank[i]; 
	TempSuit = suit[i]; 
	
	//i번째 칸 원소의 rank와 suit값을 RandomNum번째 값으로 대체
	rank[i] = rank[RandomNum]; 
	suit[i] = suit[RandomNum]; 
	
	
	 //RandomNum번째 원소를 아까 임시저장한 값으로 대체
	rank[RandomNum] = TempRank;
	suit[RandomNum] = TempSuit;

	}
	//결과적으로 1번째부터 52번째 원소를 차례대로 임의의 다른 원소와 Swap하는 함수이다
}




public static void printCards()
{
	//배열[0]~배열[51]까지  해당하는 rank와 suit를 짝지어서 출력하는 함수이다.
	for(int count=0 ; count <rank.length ; count++ ) 
	System.out.println("종류 : " + suit[count] + " 숫자 :" + rank[count] );
}

public static int compareCards(int aRank, String aSuit,int bRank, String bSuit)
{
	int result=0; //결과 (앞카드가 크면 0 뒤카드가 크면 1로 약속함), 일단 0으로 초기화
	
	//두 카드의 숫자를 비교
	if(aRank > bRank) //a의 숫자가 클 경우 => a승리
	{
		if(aRank == 13 && bRank ==1) //a의 숫자가 에이스고 b의 숫자가 킹인경우 예외적으로 에이스 승리
			result=1;
		
		else result = 0;
	}
	
	else if(aRank < bRank) //b의 숫자가 클 경우 =>b승리
	{
		if(bRank == 13 && aRank ==1)//b의 숫자가 에이스고 a의 숫자가 킹인경우 예외적으로 에이스 승리
			result=0;
		
		else result = 1;
		
	}
	
	else if(aRank == bRank) //a와 b의 숫자가 같은경우
	{
		if(aSuit == "spade") //a의 종류가 스페이드면 =>a승리
			result = 0; 
		
		if(aSuit == "diamond") //a의 종류가 다이아일경우
		{
			if(bSuit == "spade") //b가 스페이드면 => b승리
				result = 1;
			
			else				//중복된 다이아가 나올 경우는 없으므로 b가 스페이드가 아니면  => a승리
				result = 0;
		}
		
		if(aSuit == "heart") //a의 종류가 하트일경우
		{
			if(bSuit == "spade" || bSuit == "diamond") //b가 스페이드or다이아면 =>b승리
				result = 1;
			else //b가 클럽인경우=> a승리
				result =0;
		}
		
		else  if (aSuit == "club") //a의 종류가 클럽일경우
			result = 1; // => b의 승리
	}
	//두 카드의 종류를 비교
	
	return result; //결과값을를 출력
}

}
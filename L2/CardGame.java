public class CardGame
{
	
static int rank[] = new int[52];
static String suit[] = new String[52];

public static void main(String[] args)
{
	
int aRank; // ù ��° ī���� ��
int bRank; // �� ��° ī���� ��
String aSuit; // ù ��° ī���� ����
String bSuit; // �� ��° ī���� ����
int result; // �� ���� ����

String Card1 = null;
String Card2 = null ;


initialize(); //�ΰ� �迭�� �ʱ�ȭ�ϴ� �Լ�
System.out.println("ī�� ��ü ����� ����մϴ�");
printCards();
shuffle();
System.out.println("\n ���ÿϷ�� ī�� ��ü ����� ����մϴ�");
printCards();


// A ���� ī�� �ΰ��� �����ϰ� assign
System.out.println("\n ������ �Ϸ�� ���¿��� �� ��ī��� �� ��ī�带 ���մϴ�");
aRank = rank[0];
aSuit = suit[0];
bRank = rank[51];
bSuit = suit[51];

System.out.println("\n" + aSuit + " " + aRank + " VS " + bSuit + " " + bRank);
System.out.println("---------------------------------------------------------\n");
result = compareCards(aRank, aSuit, bRank, bSuit);
// B �񱳰���� ����ϴ� �κ� 

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
		rank[i] = i+1; //�迭 rank�� ���ҿ� ���� 1���� 52�� �ش��ϴ� ���� ������� �ӽ�����
		suit[i] = "Spade"; //suit�� ��� ���Ҹ� spade ������ �ӽ�����
		}
		
	for(int i =13 ; i <26 ; i++)
		{
		rank[i] = rank[i]-13; //rank[13]~rank[25]�� �ش��ϴ� ���ڸ� 1~13���� ����
		suit[i] = "Diamond"; //suit[13]~rank[25]�� �ش��ϴ� ���ڿ��� diamond�� ����
		}
	
	for(int i =26 ; i <39 ; i++)
		{
		rank[i] = rank[i]-26; //rank[26]~rank[38]�� �ش��ϴ� ���ڸ� 1~13���� ����
		suit[i] = "Heart"; //suit[26]~rank[38]�� �ش��ϴ� ���ڿ� heart�� ����
		}
	
	for(int i =39 ; i <52 ; i++)
		{
		rank[i] = rank[i]-39; //rank[39]~rank[51]�� �ش��ϴ� ���ڸ� 1~13���� ����
		suit[i] = "Club"; //suit[39]~suit[51]�� �ش��ϴ� ���ڿ��� club�� ����
		}

}




public static void shuffle()
{
	int TempRank; //�ӽ�rank��
	String TempSuit;//�ӽ�suit��
	
	for(int i=0 ; i<rank.length ; i++) //0��° ĭ���� 51��° ĭ������ ��� ���ҿ��� �ѹ��� ����
	{
	int RandomNum = (int) (Math.random() * 51); //������ 51 ������ ������ RandomNum �� �Է�
	
	
	//i��° ĭ ������ rank�� suit�� �ӽ�����
	TempRank = rank[i]; 
	TempSuit = suit[i]; 
	
	//i��° ĭ ������ rank�� suit���� RandomNum��° ������ ��ü
	rank[i] = rank[RandomNum]; 
	suit[i] = suit[RandomNum]; 
	
	
	 //RandomNum��° ���Ҹ� �Ʊ� �ӽ������� ������ ��ü
	rank[RandomNum] = TempRank;
	suit[RandomNum] = TempSuit;

	}
	//��������� 1��°���� 52��° ���Ҹ� ���ʴ�� ������ �ٸ� ���ҿ� Swap�ϴ� �Լ��̴�
}




public static void printCards()
{
	//�迭[0]~�迭[51]����  �ش��ϴ� rank�� suit�� ¦��� ����ϴ� �Լ��̴�.
	for(int count=0 ; count <rank.length ; count++ ) 
	System.out.println("���� : " + suit[count] + " ���� :" + rank[count] );
}

public static int compareCards(int aRank, String aSuit,int bRank, String bSuit)
{
	int result=0; //��� (��ī�尡 ũ�� 0 ��ī�尡 ũ�� 1�� �����), �ϴ� 0���� �ʱ�ȭ
	
	//�� ī���� ���ڸ� ��
	if(aRank > bRank) //a�� ���ڰ� Ŭ ��� => a�¸�
	{
		if(aRank == 13 && bRank ==1) //a�� ���ڰ� ���̽��� b�� ���ڰ� ŷ�ΰ�� ���������� ���̽� �¸�
			result=1;
		
		else result = 0;
	}
	
	else if(aRank < bRank) //b�� ���ڰ� Ŭ ��� =>b�¸�
	{
		if(bRank == 13 && aRank ==1)//b�� ���ڰ� ���̽��� a�� ���ڰ� ŷ�ΰ�� ���������� ���̽� �¸�
			result=0;
		
		else result = 1;
		
	}
	
	else if(aRank == bRank) //a�� b�� ���ڰ� �������
	{
		if(aSuit == "spade") //a�� ������ �����̵�� =>a�¸�
			result = 0; 
		
		if(aSuit == "diamond") //a�� ������ ���̾��ϰ��
		{
			if(bSuit == "spade") //b�� �����̵�� => b�¸�
				result = 1;
			
			else				//�ߺ��� ���̾ư� ���� ���� �����Ƿ� b�� �����̵尡 �ƴϸ�  => a�¸�
				result = 0;
		}
		
		if(aSuit == "heart") //a�� ������ ��Ʈ�ϰ��
		{
			if(bSuit == "spade" || bSuit == "diamond") //b�� �����̵�or���̾Ƹ� =>b�¸�
				result = 1;
			else //b�� Ŭ���ΰ��=> a�¸�
				result =0;
		}
		
		else  if (aSuit == "club") //a�� ������ Ŭ���ϰ��
			result = 1; // => b�� �¸�
	}
	//�� ī���� ������ ��
	
	return result; //��������� ���
}

}
// CardDeck.java
public class CardDeck
{
	 Card[] deck;
	 int top; // card deck�� ���� deal�� card ��ġ
	
	public CardDeck()
	{
	top = 0;
	deck = new Card[52]; //deck �̶�� �̸��� ī�� 52���� ���� 52���� ���۷��� ����
	
	
	// fill in the code here
	
	// ���� 1 2 3 ... n ���� �迭��  ���� ����
	
	
		for (int i = 0; i < deck.length; i++)
		{
			deck[i] = new Card(i+1,"Spade" );
			}
			
			
		for(int i =13 ; i <26 ; i++)
			{
			deck[i] = new Card (deck[i].getRank()-13, "Diamond");
			}
		
		for(int i =26 ; i <39 ; i++)
			{
			deck[i] = new Card(deck[i].getRank()- 26,"Heart");
			}
			
		
		for(int i =39 ; i <52 ; i++)
			{
			deck[i] = new Card(deck[i].rank-39, "Club");
			}
	
		top = 51;
	}
	
	
	
	
	public void shuffle()
	{
	// fill in the code here
		int TempRank;
		String TempSuit;
		
		for(int i=0 ; i<this.deck.length ; i++) //0��° ĭ���� 51��° ĭ������ ��� ���ҿ��� �ѹ��� ����
		{
		int RandomNum = (int) (Math.random() * 51);
		
		TempRank = this.deck[i].getRank(); //i��° ĭ ������ rank�� suit�� �ӽ�����
		TempSuit = this.deck[i].getSuit();
		
		this.deck[i].setRank (this.deck[RandomNum].getRank()) ; //i��° ĭ ������ rank�� suit���� RandomNum��° ������ ��ü
		this.deck[i].setSuit (this.deck[RandomNum].getSuit() );
		
		this.deck[RandomNum].setRank(TempRank); //RandomNum��° ���Ҹ� �Ʊ� �ӽ������� ������ ��ü
		this.deck[RandomNum].setSuit(TempSuit);
		}
	}
	
	
	public Card dealCard()
	{
	// fill in the code here

	return this.deck[top--];
	
	}
	
}
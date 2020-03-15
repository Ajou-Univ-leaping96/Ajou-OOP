// CardDeck.java
public class CardDeck
{
	 Card[] deck;
	 int top; // card deck의 현재 deal할 card 위치
	
	public CardDeck()
	{
	top = 0;
	deck = new Card[52]; //deck 이라는 이름의 카드 52개에 대한 52개의 레퍼런스 생성
	
	
	// fill in the code here
	
	// 숫자 1 2 3 ... n 으로 배열에  값을 지정
	
	
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
		
		for(int i=0 ; i<this.deck.length ; i++) //0번째 칸부터 51번째 칸까지의 모든 원소에게 한번씩 실행
		{
		int RandomNum = (int) (Math.random() * 51);
		
		TempRank = this.deck[i].getRank(); //i번째 칸 원소의 rank와 suit를 임시저장
		TempSuit = this.deck[i].getSuit();
		
		this.deck[i].setRank (this.deck[RandomNum].getRank()) ; //i번째 칸 원소의 rank와 suit값을 RandomNum번째 값으로 대체
		this.deck[i].setSuit (this.deck[RandomNum].getSuit() );
		
		this.deck[RandomNum].setRank(TempRank); //RandomNum번째 원소를 아까 임시저장한 값으로 대체
		this.deck[RandomNum].setSuit(TempSuit);
		}
	}
	
	
	public Card dealCard()
	{
	// fill in the code here

	return this.deck[top--];
	
	}
	
}
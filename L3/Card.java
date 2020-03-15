// Card.java
public class Card {
	int rank;
	String suit;

	public Card(int r, String s) {
		rank = r;
		suit = s;
	}

	public int getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}
	
	public void setRank(int R) {
		this.rank = R;
		return;
	}

	public void setSuit(String S) {
		this.suit =  S;
		return;
	}
	
	

	public String toString() {
		String str = null;
		// fill in the code here
		if (rank == 1 || rank == 11 || rank == 12 || rank == 13) {
			if (rank == 1) {
				str = "Ace";
			}

			if (rank == 11) {
				str = "Jack";
			}

			if (rank == 12) {
				str = "Queen";
			}

			if (rank == 13) {
				str = "King";
			}
		} 
		
		else 
			str = String.valueOf(rank);

		return str;
	}
	
	public int compareTo(Card B) {
		int result = 0; //결과는 무승부 0 / A승리 -1 / B승리 1 세가지로 약속함, 일단 0으로 초기화
		
		//두 카드의 숫자를 비교
		if(this.rank > B.rank) //a의 숫자가 클 경우 => a승리
		{
			result = -1;
		}
		
		else if(this.rank < B.rank) //b의 숫자가 클 경우 =>b승리
		{
			result = 1;
		}
		
		else if(this.rank == B.rank) //a와 b의 숫자가 같은경우
		{
			if(this.suit == "Spade") //a의 종류가 스페이드면 =>a승리
				result = -1; 
			
			if(this.suit == "Diamond") //a의 종류가 다이아일경우
			{
				if(B.suit == "Spade") //b가 스페이드면 => b승리
					result = 1;
				
				else if(B.suit == "Diamond")	//중복된 다이아가 나올 경우 => 무승부
					result = 0;
				else                  //b가 다이아,스페이드가 아니면 a의 승리
					result = -1;
			}
			
			if(this.suit == "Heart") //a의 종류가 하트일경우
			{
				if(B.suit == "Spade" || B.suit == "Diamond") //b가 스페이드or다이아면 =>b승리
					result = -1;
				
				else if(B.suit == "Heart")
					result = 0;
				
				else //b가 클럽인경우=> a승리
					result =0;
			}
			
			else  if (this.suit == "Club") //a의 종류가 클럽일경우
				if (B.suit == "Club") //b도 클럽이면 무승부
					result = 0;
				else result = 1; // => 나머지경우 b의 승리
		}
		//두 카드의 종류를 비교
		return result;
	}
	
	
	
	
	//메인 메소드
	public static void main(String[] args)
	{
	Card c1 = new Card(3, "Spade");
	Card c2 = new Card(1, "Diamond");
	System.out.println(c1.toString());
	System.out.println(c2.toString());
	
	int result = c1.compareTo(c2);
	System.out.println(result);
	if(result > 0)
	System.out.println(c2.toString()+" wins "+c1.toString());
	
	else if(result < 0)
	System.out.println(c1.toString()+" wins "+c2.toString());
	
	else
	System.out.println(c1.toString()+" ties to "+c2.toString());
	}
}
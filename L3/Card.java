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
		int result = 0; //����� ���º� 0 / A�¸� -1 / B�¸� 1 �������� �����, �ϴ� 0���� �ʱ�ȭ
		
		//�� ī���� ���ڸ� ��
		if(this.rank > B.rank) //a�� ���ڰ� Ŭ ��� => a�¸�
		{
			result = -1;
		}
		
		else if(this.rank < B.rank) //b�� ���ڰ� Ŭ ��� =>b�¸�
		{
			result = 1;
		}
		
		else if(this.rank == B.rank) //a�� b�� ���ڰ� �������
		{
			if(this.suit == "Spade") //a�� ������ �����̵�� =>a�¸�
				result = -1; 
			
			if(this.suit == "Diamond") //a�� ������ ���̾��ϰ��
			{
				if(B.suit == "Spade") //b�� �����̵�� => b�¸�
					result = 1;
				
				else if(B.suit == "Diamond")	//�ߺ��� ���̾ư� ���� ��� => ���º�
					result = 0;
				else                  //b�� ���̾�,�����̵尡 �ƴϸ� a�� �¸�
					result = -1;
			}
			
			if(this.suit == "Heart") //a�� ������ ��Ʈ�ϰ��
			{
				if(B.suit == "Spade" || B.suit == "Diamond") //b�� �����̵�or���̾Ƹ� =>b�¸�
					result = -1;
				
				else if(B.suit == "Heart")
					result = 0;
				
				else //b�� Ŭ���ΰ��=> a�¸�
					result =0;
			}
			
			else  if (this.suit == "Club") //a�� ������ Ŭ���ϰ��
				if (B.suit == "Club") //b�� Ŭ���̸� ���º�
					result = 0;
				else result = 1; // => ��������� b�� �¸�
		}
		//�� ī���� ������ ��
		return result;
	}
	
	
	
	
	//���� �޼ҵ�
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
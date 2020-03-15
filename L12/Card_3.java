package 실습;

public class Card implements Comparable<Card> {
	char type; // 's' 'd' 'h' 'c'
	int rank; // 1~13 (1-Ace , 11-Jack, 12-Queen)

	public Card(char t, int r) {
		type = t;
		rank = r;
	}

	public char getType() {
		return type;
	}

	public int getRank() {
		return rank;
	}

	public String toString() {
		return ("type: " + type + " rank: " + rank + "\n");
	}

	@Override
	public int compareTo(Card other) {
		if(this.getRank() > other.getRank()) // 왼쪽이 큰경우 1 리턴
			return 1;
		
		else if(this.getRank() < other.getRank()) // 오른쪽이 큰경우 -1 리턴
			return -1;
		
		else{// 같은경우 모양비교
			int thisType, otherType;
			
			if(this.getType() == 's') thisType = 3;
			else if(this.getType() == 'd') thisType = 2;
			else if(this.getType() == 'h') thisType = 1;
			else thisType = 0;
			
			if(other.getType() == 's') otherType = 3;
			else if(other.getType() == 'd') otherType = 2;
			else if(other.getType() == 'h') otherType = 1;
			else otherType = 0;
			
			if(thisType > otherType) return 1;
			else return -1;
		}		
	}
}

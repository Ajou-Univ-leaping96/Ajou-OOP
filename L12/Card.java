package 실습;

public class Card {
	char type; // 's' 'd' 'h' 'c'
	int rank; // 1~13 	(1-Ace , 11-Jack, 12-Queen)
	
	public char getType() {
		return type;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String toString() {
		return ("type: "+type +" rank: "+rank+"\n");
	}
}

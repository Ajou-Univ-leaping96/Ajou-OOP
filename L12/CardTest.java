package 실습;

public class CardTest {

	public static void main(String[] args) {
		
		Card[] cards = new Card[3];
		cards[0] = new Card('s', 11);
		cards[1] = new Card('d', 1);
		cards[2] = new Card('h', 3);
		
		for(Card c : cards) {
			System.out.println(c);
		}
	}

}

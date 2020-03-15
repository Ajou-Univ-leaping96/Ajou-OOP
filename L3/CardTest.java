// CardTest.java
public class CardTest {
	public static void main(String[] args)
	{
		Card c1 = new Card(1, "Heart");
		Card c2 = new Card(2, "Spade");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		int result = c1.compareTo(c2);
if(result > 0)
System.out.println(c2.toString()+ " of " + c2.getSuit() + " wins "+c1.toString() + " of " +c1.getSuit() );
else if(result < 0)
System.out.println(c1.toString()+ " of " + c1.getSuit() + " wins "+c2.toString() + " of " + c2.getSuit() );
else
System.out.println(c1.toString()+" ties to "+c2.toString());
}
}
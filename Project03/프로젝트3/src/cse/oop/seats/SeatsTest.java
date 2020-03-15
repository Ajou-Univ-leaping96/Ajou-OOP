package cse.oop.seats;
import java.util.Scanner;

public class SeatsTest {

	
	public static void main(String[] args) {
		int row,col;
		boolean valid;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Seat info! ex)row col .... 3 5 =>3За 5ї­");
		
		do {
			row = in.nextInt();
			col = in.nextInt();
			
			valid = Seat.checkValidity(row, col);
			if (valid == false)
				System.out.println("Error: enter Seat info again!");
		} while (!valid);
		Seat s1 = new Seat(row, col);
		System.out.println(s1.toString());
	}

}
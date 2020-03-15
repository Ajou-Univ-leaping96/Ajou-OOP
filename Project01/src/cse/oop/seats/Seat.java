package cse.oop.seats;

public class Seat {

	int row;
	int col;

	public Seat(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}

	public static boolean checkValidity(int row, int col) {
		if (row < 0 || row > 10)
			return false;
		if (col < 0 || col > 10)
			return false;
		return true;
	}
	
	public String toString() {
		return ("<" + this.row + " " + this.col + ">" );
	}

}
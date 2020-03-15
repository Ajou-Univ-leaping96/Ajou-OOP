import java.util.Scanner;

//TimeTest.java
public class TimeTest {

	public static void main(String[] args) {
		int year, month, day, hour, min;
		boolean valid;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter time info!");
		do {
			year = in.nextInt();
			month = in.nextInt();
			day = in.nextInt();
			hour = in.nextInt();
			min = in.nextInt();
			valid = Time.checkValidity(year, month, day, hour, min);
			if (valid == false)
				System.out.println("Error: enter time info again!");
		} while (!valid);
		Time t = new Time(year, month, day, hour, min);
		System.out.println(t);
		
		Time t2 = new Time(year, month, day); // hh=12, mm=0 (default values)
		System.out.println(t2);
		
		return;
	}

}
​
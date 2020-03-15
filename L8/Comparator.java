package interfaces;
import java.util.Arrays;
import java.util.Comparator;

class LengthComparator implements Comparator<String> {
	@Override
	public int compare(String first, String second) {
		return first.length() - second.length();
		//return second.length() - first.length();
	}
}

public class WordSortTest {
public static void main(String[] args){
	String[] names = {"Lee", "Chang", "Hong"};
	
	// (1) sorting with LengthComparator
	Arrays.sort(names, new LengthComparator());
	// printing sorted array
     for (String n : names)
        System.out.println("name=" + n);
     System.out.println("====================");
     
     
	// (2) sorting with lambda expression
	Arrays.sort(names,(first,second)-> second.length() - first.length());
	// printing sorted array
	   for (String n : names)
	        System.out.println("name=" + n);
	}
}
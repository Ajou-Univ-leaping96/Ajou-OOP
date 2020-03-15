package GUI_test;

import java.util.*;

public class CurrentTimetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stubint nYear;
		int nMonth;
		int nDay;
		int nYear;
		 
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		nYear = calendar.get(Calendar.YEAR);
		nMonth = calendar.get(Calendar.MONTH) + 1;
		nDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("GregorianCalendar = " + nYear + "-"
		        + nMonth + "-" + nDay);


	}

}

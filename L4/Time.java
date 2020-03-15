import java.util.GregorianCalendar;

//Time.java
public class Time {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;

	public Time(int y, int m, int d, int hh, int mm) {
		year = y;
		month = m;
		day = d;
		hour = hh;
		min = mm;
	}
	
	public Time(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
		this.hour = 12;
		this.min = 0;
	}

public String toString()
{
return(""+year+"-"+month+"-"+day+"/"+hour+":"+min);
}


public static boolean checkValidity(int year, int month, int day, int hour, int min) {

	// year가 2019~9999 사이의 수인가
	if (year < 2019 || year > 9999)
		return false;
	// month가 1~12 사이의 수인가
	if (month < 1 || month > 12)
		return false;
	// month 값에 대한 day 범위가 적절한가
	switch (month) {
	case 1:
		if (day < 1 || day > 31)
			return false;
	case 2:
		// year가 윤년인가 아닌가
		GregorianCalendar gregori = new GregorianCalendar();
		if (gregori.isLeapYear(year) == true) // 윤년일경우 29일까지
			if (day < 1 || day > 29)
				return false;
		if (gregori.isLeapYear(year) == false)// 윤년아닐경우28일까지
			if (day < 1 || day > 28)
				return false;
	case 3:
		if (day < 1 || day > 31)
			return false;
	case 4:
		if (day < 1 || day > 30)
			return false;
	case 5:
		if (day < 1 || day > 31)
			return false;
	case 6:
		if (day < 1 || day > 30)
			return false;
	case 7:
		if (day < 1 || day > 31)
			return false;
	case 8:
		if (day < 1 || day > 31)
			return false;
	case 9:
		if (day < 1 || day > 30)
			return false;
	case 10:
		if (day < 1 || day > 31)
			return false;
	case 11:
		if (day < 1 || day > 30)
			return false;
	case 12:
		if (day < 1 || day > 31)
			return false;
	}
	// hour값이 0~23인가
	if (hour < 0 || hour > 23)
		return false;
	// min값이 0 또는 30인가
	if (min != 0 && min != 30)
		return false;
	// 조건에 모두 부합하면 true 출력
	return true;
}

}
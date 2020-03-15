package cse.oop.seats;

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

	public String toString() {
		return ("" + year + "-" + month + "-" + day + "/" + hour + ":" + min);
	}

	public static boolean checkValidity(int year, int month, int day, int hour, int min) {

		// year�� 2019~9999 ������ ���ΰ�
		if (year < 2019 || year > 9999)
			return false;
		// month�� 1~12 ������ ���ΰ�
		if (month < 1 || month > 12)
			return false;
		// month ���� ���� day ������ �����Ѱ�
		switch (month) {
		case 1:
			if (day < 1 || day > 31)
				return false;
		case 2:
			// year�� �����ΰ� �ƴѰ�
			GregorianCalendar gregori = new GregorianCalendar();
			if (gregori.isLeapYear(year) == true) // �����ϰ�� 29�ϱ���
				if (day < 1 || day > 29)
					return false;
			if (gregori.isLeapYear(year) == false)// ����ƴҰ��28�ϱ���
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
		// hour���� 0~23�ΰ�
		if (hour < 0 || hour > 23)
			return false;
		// min���� 0 �Ǵ� 30�ΰ�
		if (min != 0 && min != 30)
			return false;
		// ���ǿ� ��� �����ϸ� true ���
		return true;
	}

	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public double getOnlyhour() {
		double result=this.hour;
		if(this.min == 30) {
			result = result+0.5;
		}
		return result;
	}
	
	public String toDate() {
		return ("" + year + "-" + month + "-" + day);
	}
	
	public String toTime() {
		return ( hour + ":" + min );
	}

}

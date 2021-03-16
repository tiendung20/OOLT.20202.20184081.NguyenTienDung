import java.util.Scanner;
import java.time.LocalDate;
public class MyDate {
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	int checkday(String[] date) {
		int c=0,kt=0;
		this.day = Integer.parseInt(date[1]);
		this.year = Integer.parseInt(date[2]);
		if(this.year>0) {
			if(this.year%4==0&&this.year%100!=0) {
				c = 1;
			}
			else if(this.year%100==0&&this.year%400==0) {
				c = 1;
			}
			switch(date[0]) {
			case "January": case "Jan.": case "Jan":
				this.month = 1;
				kt = 1;
				break;
			case "February": case "Feb.": case "Feb":
				this.month = 2;
				kt = 1;
				break;
			case "March": case "Mar.": case "Mar":
				this.month = 3;
				kt = 1;
				break;
			case "April": case "Apr.": case "Apr":
				this.month = 4;
				kt = 1;
				break;
			case "May":
				this.month = 5;
				kt = 1;
				break;
			case "June": case "Jun":
				this.month = 6;
				kt = 1;
				break;
			case "July": case "Jul":
				this.month = 7;
				kt = 1;
				break;
			case "August": case "Aug.": case "Aug":
				this.month = 8;
				kt = 1;
				break;
			case "September": case "Sept.": case "Sep":
				this.month = 9;
				kt = 1;
				break;
			case "October": case "Oct.": case "Oct":
				this.month = 10;
				kt = 1;
				break;
			case "November": case "Nov.": case "Nov":
				this.month = 11;
				kt = 1;
				break;
			case "December": case "Dec.": case "Dec":
				this.month = 12;
				kt = 1;
				break;
			default:
				kt = 0;
				break;
			}
			if(kt==0) {
				this.month = Integer.parseInt(date[0]);
				if(this.month>0&&this.month<13) kt=1;
			}
			if(kt == 1) {
				if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12) {
					if(this.day<1||this.day>31) kt = 0;
				}
				else if(this.month==2) {
					if(this.day<1) kt = 0;
					if(this.day>29) kt = 0;
					if(this.day>28&&c!=1) kt = 0; 
				}
			}
		}
		return kt;
	}
	int accept(String st) {
		int a;
		String[] date = new String[3];
		date = st.split("/");
		if(date.length!=3) return 0;
		a = checkday(date);
		return a;
	}
	int accept() {
		LocalDate myObj = LocalDate.now();
		String[] date = new String[3];
		String str = String.valueOf(myObj);
		date = str.split("-");
		str = date[0];
		date[0] = date[1];
		date[1] = date[2];
		date[2] = str;
		int i = checkday(date);
		return i;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MyDate s = new MyDate();
		int a=1;
		do {
			if(a==0) System.out.println("Error!");
			System.out.print("Enter a date (mm/dd/yyyy): ");
			String str = input.nextLine();
			if(str.length()<1) a = s.accept();
			else a = s.accept(str);
		}while(a==0);
		System.out.println(s.month+"/"+s.day+"/"+s.year);
		input.close();
	}

}

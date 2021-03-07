import java.util.Scanner;
public class DaysOfMonth {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year = 0,kt = 0,days,check;
		String month;
		do {
			days = 0;
			kt = 0;
			System.out.print("Enter a month: ");
			month = input.nextLine();
			if(month.equals("January")||month.equals("Jan.")||month.equals("Jan")||month.equals("1")) {
				days = 31;
			}
			else if(month.equals("February")||month.equals("Feb.")||month.equals("Feb")||month.equals("2")) {
				days = 28;
			}
			else if(month.equals("March")||month.equals("Mar.")||month.equals("Mar")||month.equals("3")) {
				days = 31;
			}
			else if(month.equals("April")||month.equals("Apr.")||month.equals("Apr")||month.equals("4")) {
				days = 30;
			}
			else if(month.equals("May")||month.equals("5")) {
				days = 31;
			}
			else if(month.equals("June")||month.equals("Jun")||month.equals("6")) {
				days = 30;
			}
			else if(month.equals("July")||month.equals("Jul")||month.equals("7")) {
				days = 31;
			}
			else if(month.equals("August")||month.equals("Aug.")||month.equals("Aug")||month.equals("8")) {
				days = 31;
			}
			else if(month.equals("September")||month.equals("Sept.")||month.equals("Sep")||month.equals("9")) {
				days = 30;
			}
			else if(month.equals("October")||month.equals("Oct.")||month.equals("Oct")||month.equals("10")) {
				days = 31;
			}
			else if(month.equals("November")||month.equals("Nov.")||month.equals("Nov")||month.equals("11")) {
				days = 30;
			}
			else if(month.equals("December")||month.equals("Dec.")||month.equals("Dec")||month.equals("12")) {
				days = 31;
			}
			else {
				System.out.println("Error month!");
				kt = 1;
			}
		} while(kt==1);
		if(kt==0) {
			do {
				if(year<0) System.out.println("Error year!");
				System.out.print("Enter a year: ");
				year =  input.nextInt();
			}while(year<0);
			if(year%4==0&&year%100!=0) {
				check = 1;
			}
			else if(year%100==0&&year%400==0) {
				check = 1;
			}
			else check = 0;
			if(check==1&&days==28) days = 29;
		}
		System.out.println(month + " has " + days + " days.");
		input.close();
	}

}

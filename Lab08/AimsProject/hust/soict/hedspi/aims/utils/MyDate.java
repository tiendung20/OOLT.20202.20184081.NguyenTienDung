package hust.soict.hedspi.aims.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// mm/dd/yyyy
public class MyDate {
	private int day;
	private int month;
	private int year;
	private String[] namesDay = {"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth","fourteenth",
            "fifteen","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first","twenty-second","twenty-third","twenty-fourth","twenty-fifth","twenty-sixth",
            "twenty-seventh","twenty-eighth","twenty-ninth","thirtieth","thirty-first"};
	private  List<String> validMonth = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
            "Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
            "Jan","Feb","Mar","Apr","Jul","Aug","Aug","Sep","Oct","Nov","Dec"
    );
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		accept(day,this.month,this.year);
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		accept(this.day,month,this.year);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		accept(this.day,this.month,year);
	}
	public MyDate() {
		accept();
	}
	public MyDate(String str) {
		accept(str);
	}
	public MyDate(int day,int month,int year) {
		accept(day,month,year);
	}
	public MyDate(String day,String month,String year) {
		accept(day,month,year);
	}
	public int convertYear(String year){
        String y = year.toLowerCase();
        String[] itemsY = y.split("\\s");
        if(itemsY.length < 2) {
            return -1;
        }
        int num1,num2;
        num1 = cutStringYear(itemsY[0]);
        if(num1 == -1)
            return -1;
        num2 = cutStringYear(itemsY[1]);
        if(num2 == -1 && itemsY[1].equals("hundred"))
            num2 = 0;
        else if(num2 == -1 && !itemsY[1].equals("hundred"))
            return -1;
        return num1*100 + num2;
    }
    public int cutStringYear (String cutItem){
        String[] numType1 = {"one","two","three","four","five","six","seven","eight","nine"};
        String[] numType2 = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] numType3 = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        int num1=0,num2=0;
        int flag = 0;
        if(!cutItem.contains("-")){
            for (int i = 0 ; i < numType1.length ; i++){
                if(numType1[i].equals(cutItem)){
                    num1 = i + 1;
                    num2 = 0 ;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                for (int i = 0 ; i < numType2.length ; i++){
                    if(numType2[i].equals(cutItem)){
                        num1 = 1;
                        num2 = i ;
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                for (int i = 0 ; i < numType3.length ; i++){
                    if(numType3[i].equals(cutItem)){
                        num1 = i + 2;
                        num2 = 0 ;
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0 )
                return -1;
        }
        else{
            String[] itemsArr = cutItem.split("-");
            if (itemsArr.length < 2){
                return -1;
            }

            for (int i = 0 ; i < numType3.length ; i++){
                if(numType3[i].equals(itemsArr[0])){
                    num1 = i + 2;
                    break;
                }
            }
            if(num1 == 0 )
                return -1;
            for (int i = 0 ; i < numType1.length ; i++){
                if(numType1[i].equals(itemsArr[1])){
                    num2 = i + 1;
                    break;
                }
            }
            if(num2 == 0)
                return -1;

        }
        return num1*10 + num2;
    }
    private boolean isNumber(String a) {
    	char[] ch = a.toCharArray();
    	for(int i=0;i<ch.length;i++) {
    		if(Character.isDigit(ch[i])==false) return false;
    	}
    	return true;
    }
	private void checkday(String[] date) {
		int kt = 0;
		if(date.length!=3) {
			kt = 0;
		}
		else {
			int c=0,i;
			for(i=0;i<namesDay.length;i++) {
				if(namesDay[i].equals(date[1].toLowerCase())) date[1] = String.valueOf(i+1);
			}
			if(isNumber(date[2])==false) date[2] = String.valueOf(convertYear(date[2]));
			date[1] = date[1].replace("st", "");
			date[1] = date[1].replace("nd", "");
			date[1] = date[1].replace("rd", "");
			date[1] = date[1].replace("th", "");
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
					else {
						if(this.day<1||this.day>30) kt = 0;
					}
				}
			}
		}
		if(kt==0) {
			//System.out.println("Error!");
			this.day = this.month = this.year = 0;
		}
	}
	private void accept(String st) {
		String[] date = new String[3];
		date = st.split("/");
		checkday(date);
	}
	private void accept() {
		LocalDate myObj = LocalDate.now();
		String[] date = new String[3];
		String str = String.valueOf(myObj);
		date = str.split("-");
		str = date[0];
		date[0] = date[1];
		date[1] = date[2];
		date[2] = str;
		checkday(date);
	}
	private void accept(String day, String month, String year) {
		String[] date = new String[3];
		date[0] = String.valueOf(month);
		date[1] = String.valueOf(day);
		date[2] = String.valueOf(year);
		checkday(date);
	}
	private void accept(int day, int month, int year) {
		String[] date = new String[3];
		date[0] = String.valueOf(month);
		date[1] = String.valueOf(day);
		date[2] = String.valueOf(year);
		checkday(date);
	}
	/*public void print() {
		if(this.day!=0&&this.month!=0&&this.year!=0) System.out.println(this.month+"/"+this.day+"/"+this.year);
		else System.out.println("Error!");
	}*/
	public String print(){
        String m;
        if(month == 1)
            m = "January";
        else if(month == 2)
            m = "February";
        else if(month == 3)
            m = "March";
        else if(month == 4)
            m = "April";
        else if(month == 5)
            m = "May";
        else if(month == 6)
            m = "June";
        else if(month == 7)
            m = "July";
        else if(month == 8)
            m = "August";
        else if(month == 9)
            m = "September";
        else if(month == 10)
            m = "October";
        else if(month == 11)
            m = "November";
        else
            m = "December";
        String d;
        if(day == 1 || day == 21)
            d = day+"st";
        else if(day == 2 || day == 22)
            d = day+"nd";
        else if(day == 3 || day == 23)
            d = day+"rd";
        else
            d = day+"th";
        return "My Date : "+m+" "+d+" "+year;
    }
	public String print(int option){
        String d = (day>9)?day+"":"0"+day;
        String mm = (month>9)?month+"":"0"+month;
        String MMM = validMonth.get(month-1).substring(0,3);
        switch (option){
            case 1:
                return "My Date (yyyy-MM-dd): "+year+"-"+mm+"-"+d;
            case 2:
                return "My Date (d/M/yyyy): "+day+"/"+month+"/"+year;
            case 3:
                return "My Date (dd-MMM-yyyy): "+d+"-"+MMM+"-"+year;
            case 4:
                return "My Date (MMM d yyyy): "+MMM+" "+day+" "+year;
            case 5:
                return "My Date (mm-dd-yyyy): "+mm+"-"+d+"-"+year;
            default:
                return print();
        }
    }

}
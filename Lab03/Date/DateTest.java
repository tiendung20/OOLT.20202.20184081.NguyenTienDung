package Date;

public class DateTest {

	public static void main(String[] args) {
		MyDate myDate = new MyDate("February 29th 2020");
		MyDate myDate1 = new MyDate("February/29th/2021");
		MyDate myDate2 = new MyDate("February/29th/2020");
        MyDate myDate3 = new MyDate();
        MyDate myDate4 = new MyDate(31,5,2019);
        MyDate myDate5 = new MyDate(31,4,2019);
        MyDate myDate6 = new MyDate();
        myDate6.setDay(31);

        myDate.print();
        myDate1.print();
        myDate2.print();
        myDate3.print();
        myDate4.print();
        myDate5.print();
        myDate6.print();

	}

}

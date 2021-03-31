package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Cinderella");
		dvd4.setCategory("Animation");
		dvd4.setCost(100.99f);
		dvd4.setDirector("John Cena");
		dvd4.setLength(120);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Jungle");
		dvd5.setCategory("Animation");
		dvd5.setCost(28.99f);
		dvd5.setDirector("John Cena");
		dvd5.setLength(95);

        assert dvd1.search("Lion the") == true : "Wrong search method";
        assert dvd1.search("lione") == false : "Wrong search method for false";

        Order order = Order.createOrder();
        order.addDigitalVideoDisc(dvd1,dvd2,dvd3,dvd4,dvd5);
        DigitalVideoDisc dvd = order.getALuckyItem();
        assert order.totalCost() == (dvd1.getCost() + dvd2.getCost() + dvd3.getCost() + dvd4.getCost() + dvd5.getCost() - dvd.getCost()) : "Wrong lucky method";
    }
}